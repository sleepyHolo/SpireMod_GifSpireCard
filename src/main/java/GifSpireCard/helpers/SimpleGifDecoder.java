package GifSpireCard.helpers;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.Array;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Iterator;

public class SimpleGifDecoder {

    public static class GifFrame {
        public Pixmap pixmap;
        public int delay_ms;

        public GifFrame(Pixmap pixmap, int delay_ms) {
            this.pixmap = pixmap;
            this.delay_ms = delay_ms;
        }
    }

    public static Array<GifFrame> decode(InputStream inputStream) throws Exception {
        Array<GifFrame> frames = new Array<>();

        ImageInputStream stream = ImageIO.createImageInputStream(inputStream);
        Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("gif");

        if (!readers.hasNext()) {
            throw new RuntimeException("No GIF reader available");
        }

        ImageReader reader = readers.next();
        reader.setInput(stream);

        int numFrames = reader.getNumImages(true);
        for (int i = 0; i < numFrames; i++) {
            BufferedImage bufferedImage = reader.read(i);

            // Get delay time from metadata
            int delay = 100; // default 100ms
            try {
                IIOMetadataNode root = (IIOMetadataNode) reader.getImageMetadata(i).getAsTree("javax_imageio_gif_image_1.0");
                IIOMetadataNode gce = (IIOMetadataNode) root.getElementsByTagName("GraphicControlExtension").item(0);
                String delayTime = gce.getAttribute("delayTime");
                delay = Integer.parseInt(delayTime) * 10; // convert from 1/100s to ms
            } catch (Exception e) {
                // use default delay
            }

            Pixmap pixmap = bufferedImageToPixmap(bufferedImage);
            frames.add(new GifFrame(pixmap, delay));
        }

        reader.dispose();
        return frames;
    }

    private static Pixmap bufferedImageToPixmap(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int argb = image.getRGB(x, y);
                int a = (argb >> 24) & 0xff;
                int r = (argb >> 16) & 0xff;
                int g = (argb >> 8) & 0xff;
                int b = (argb) & 0xff;
                int rgba = (r << 24) | (g << 16) | (b << 8) | a;
                pixmap.drawPixel(x, y, rgba);
            }
        }

        return pixmap;
    }
}


