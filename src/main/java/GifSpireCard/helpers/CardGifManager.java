package GifSpireCard.helpers;

import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class CardGifManager {
    private static final Logger logger = LogManager.getLogger(CardGifManager.class.getName());
    public static HashMap<String, GifRenderer> gifRendererMap = new HashMap<>();

    @Nullable
    public static GifRenderer getGifRenderer(String imgUrl) {
        if (gifRendererMap.containsKey(imgUrl)) {
            return gifRendererMap.get(imgUrl);
        }
        GifRenderer tmp = null;
        try {
            tmp = new GifRenderer(imgUrl);
        } catch (Exception e) {
            logger.info(e);
            return null;
        }
        gifRendererMap.put(imgUrl, tmp);
        return gifRendererMap.get(imgUrl);

    }

    public static void update_all() {
        // 每帧主动更新
        float dt = Gdx.graphics.getDeltaTime();
        for (GifRenderer gr: gifRendererMap.values()) {
            gr.update(dt);
        }
    }

    @SpirePatch(clz = CardCrawlGame.class,
            method = "update",
            paramtypez = {void.class},
            requiredModId = "basemod"
    )
    public static class UpdateAnytime {
        @SpirePostfixPatch
        public static void postfix(CardCrawlGame __instance) {
            update_all();
        }
    }

}
