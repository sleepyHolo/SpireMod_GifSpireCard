# -*- coding: utf-8 -*-

from typing import Tuple, Union
from PIL import Image, ImageSequence
from pillow_gif_fix import save_transparent_gif

def resize_helper(width: int, height: int) -> None:
    """print recommended size"""
    target_HperW = 0.76 # 380 / 500
    if (height / width) >= target_HperW:
        print(f'fit width : {width}x{int(width * target_HperW)}')
    else:
        print(f'fit height: {int(height / target_HperW)}x{height}')
    return

def resize_gif(filename: str, output: str, target_size: Tuple[int, int]) -> None:
    with Image.open(filename) as img:
        duration = img.info.get('duration', 100)
        
        frames = []
        for frame in ImageSequence.Iterator(img):
            frames.append(frame.resize(target_size, resample=Image.LANCZOS))
            
    save_transparent_gif(frames, duration, output)
    
    return

def add_transparent_mask(filename: str, output: str, mask: Image) -> None:
    """
    for every pixel: pixel.alpha = mask.alpha
    never check mask size
    """
    with Image.open(filename) as img:
        duration = img.info.get('duration', 100)
        
        frames = []
        for frame in ImageSequence.Iterator(img):
            frame = frame.convert('RGB');
            frames.append(Image.merge('RGBA', (*frame.split(), mask.getchannel('A'))))
            
    save_transparent_gif(frames, duration, output)
    
def build_card_gif(filename: str, output: str, mask: Union[str, Image]) -> None:
    """
    using gif file 'filename' to build a STS card image.
        output.gif -> size 250x190
        output_p.gif -> size 500x380
    mask: filename / Image object
    """
    should_close_mask: bool = False
    if isinstance(mask, str):
        mask = Image.open(mask)
        should_close_mask = True
    mask_alpha_p = mask.resize((500, 380), resample=Image.LANCZOS).getchannel('A')
    mask_alpha = mask_alpha_p.resize((250, 190), resample=Image.LANCZOS)
    
    with Image.open(filename) as img:
        duration = img.info.get('duration', 100)
        if duration == 0:
            print('Gif duration is 0. Set 100 now.')
            duration = 100;
        
        frames = []
        frames_p = []
        for frame in ImageSequence.Iterator(img):
            frame = frame.convert('RGB');
            # to 500x380
            frame_p = frame.resize((500, 380), resample=Image.LANCZOS)
            frames_p.append(Image.merge('RGBA', (*frame_p.split(), mask_alpha_p)))
            # to 250x190
            frame = frame_p.resize((250, 190), resample=Image.LANCZOS)
            frames.append(Image.merge('RGBA', (*frame.split(), mask_alpha)))
            
    save_transparent_gif(frames_p, duration, output + '_p.gif')
    save_transparent_gif(frames, duration, output + '.gif')
    
    if should_close_mask:
        mask.close()

if __name__ == "__main__":
    import os
    import argparse
    
    parser = argparse.ArgumentParser(
        prog='gif builder',
        description='a simple gif builder for SlayTheSpire card',
        epilog='for more infomation, please read GifSpireCard wiki'
        )
    parser.add_argument('filename', help='gif file to process, with extension')
    parser.add_argument('mask', help='mask file you want to apply')
    parser.add_argument('-o', '--output', default=None,
                        help='processed filename, without extension. default is the same as filename')
    args = parser.parse_args()
    if args.output is None:
        args.output, _ = os.path.splitext(args.filename)
    
    assert os.path.exists(args.filename), f'file not found: {args.filename}'
    assert os.path.exists(args.mask), f'mask not found: {args.mask}'
    
    build_card_gif(args.filename, args.output, args.mask)
    print(f'output saved as: {args.output}.gif, {args.output}_p.gif')
    