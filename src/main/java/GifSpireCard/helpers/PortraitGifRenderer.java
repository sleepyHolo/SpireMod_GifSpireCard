package GifSpireCard.helpers;

import GifSpireCard.helpers.SimpleGifDecoder.GifFrame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

/**
 * 和 GifRenderer 最大的不同在于这个是创建时加载文件
 * 所以 必须 即用即删
 */
public class PortraitGifRenderer implements Disposable {
    /**
     * 代替管理一个静态 PortraitGifRenderer,用于配合 SingleCardViewPopup 使用
     */
    public static PortraitGifRenderer pGifRenderer = null;

    private final Array<Texture> textures;
    private final Array<Float> delays_s;
    private int frameIndex = 0;
    private float frameTimer = 0.0F;

    public PortraitGifRenderer(String imgUrl) throws Exception {
        Array<GifFrame> gifFrames = SimpleGifDecoder.decode(Gdx.files.internal(imgUrl).read());
        textures = new Array<>();
        delays_s = new Array<>();
        for (GifFrame frame: gifFrames) {
            textures.add(new Texture(frame.pixmap));
            delays_s.add(frame.delay_ms / 1000.0F);
        }
    }

    public void update() {
        frameTimer += Gdx.graphics.getDeltaTime();
        if (frameTimer > delays_s.get(frameIndex)) {
            frameTimer = 0.0F;
            frameIndex = (frameIndex + 1) % textures.size;
        }
    }

    public Texture getPortrait() {
        return textures.get(frameIndex);
    }

    @Override
    public void dispose() {
        for (Texture t: textures) {
            if (t != null) {
                t.dispose();
            }
        }
    }

}
