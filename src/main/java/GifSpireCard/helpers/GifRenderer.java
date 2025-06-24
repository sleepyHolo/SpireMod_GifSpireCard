package GifSpireCard.helpers;

import GifSpireCard.helpers.SimpleGifDecoder.GifFrame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;

/**
 * 不要在实际使用时实例化此对象, 应由 CardGifManager 管理
 */
public class GifRenderer {
    private final Array<AtlasRegion> textures;
    private final Array<Float> delays_s;
    private int frameIndex = 0;
    private float frameTimer = 0.0F;

    public GifRenderer(String imgUrl) throws Exception {
        Array<GifFrame> gifFrames;
        gifFrames = SimpleGifDecoder.decode(Gdx.files.internal(imgUrl).read());

        textures = new Array<>();
        delays_s = new Array<>();
        for (GifFrame frame: gifFrames) {
            Texture tmp = new Texture(frame.pixmap);
            textures.add(new AtlasRegion(tmp, 0, 0, tmp.getWidth(), tmp.getHeight()));
            delays_s.add(frame.delay_ms / 1000.0F);
        }

    }

    public void update(float dt) {
        frameTimer += dt;
        if (frameTimer > delays_s.get(frameIndex)) {
            frameTimer = 0.0F;
            frameIndex = (frameIndex + 1) % textures.size;
        }
    }

    public AtlasRegion getPortrait() {
        return textures.get(frameIndex);
    }

}
