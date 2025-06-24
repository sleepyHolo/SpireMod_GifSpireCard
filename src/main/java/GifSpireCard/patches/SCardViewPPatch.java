package GifSpireCard.patches;

import GifSpireCard.helpers.PortraitGifRenderer;
import basemod.abstracts.CustomCard;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.screens.SingleCardViewPopup;

import java.lang.reflect.Field;


public class SCardViewPPatch {
    @SpirePatch(clz = SingleCardViewPopup.class,
            method = "renderPortrait",
            paramtypez = {SpriteBatch.class},
            requiredModId = "basemod"
    )
    public static class UpdatePortrait {
        @SpirePrefixPatch
        public static void prefix(SingleCardViewPopup __instance, SpriteBatch sb, AbstractCard ___card) {
            if (___card instanceof CustomCard && PortraitGifRenderer.pGifRenderer != null) {
                PortraitGifRenderer.pGifRenderer.update();
                try {
                    Field portraitImageField = SingleCardViewPopup.class.getDeclaredField("portraitImg");
                    portraitImageField.setAccessible(true);
                    portraitImageField.set(__instance, PortraitGifRenderer.pGifRenderer.getPortrait());
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 这个补丁可能和 basemod 的同方法的 Postfix 补丁顺序未知, 需要避免 basemod 加载的 Texture 无法 dispose 的可能
     */
    @SpirePatch(clz = SingleCardViewPopup.class,
            method = "loadPortraitImg",
            paramtypez = {void.class},
            requiredModId = "basemod"
    )
    public static class OpenTextureFix {
        @SpirePostfixPatch
        public static void loadPostfix(SingleCardViewPopup __instance, AbstractCard ___card) {
            if (!(___card instanceof CustomCard)) {
                return;
            }
            // 仅搜索 _p.gif
            int endingIndex = ((CustomCard) ___card).textureImg.lastIndexOf(".");
            String extension = ((CustomCard) ___card).textureImg.substring(endingIndex);
            String newPath = ((CustomCard) ___card).textureImg.substring(0, endingIndex) + "_p" + extension;
            if (extension.equals(".gif")) {
                try {
                    PortraitGifRenderer.pGifRenderer = new PortraitGifRenderer(newPath);
                } catch (Exception e) {
                    PortraitGifRenderer.pGifRenderer = null;
                }
            }
            if (PortraitGifRenderer.pGifRenderer != null) {
                try {
                    Field portraitImageField = SingleCardViewPopup.class.getDeclaredField("portraitImg");
                    portraitImageField.setAccessible(true);
                    if (portraitImageField.get(__instance) != null) {
                        // 这个是 basemod 先于此补丁加载时, 加载的 Texture
                        ((Texture) portraitImageField.get(__instance)).dispose();
                    }
                    // 如果 basemod 后于此补丁加载, 检测到 portraitImg != null 就不会加载 Texture
                    portraitImageField.set(__instance, PortraitGifRenderer.pGifRenderer.getPortrait());
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }
        
    }

    @SpirePatch(clz = SingleCardViewPopup.class,
            method = "close",
            paramtypez = {void.class},
            requiredModId = "basemod"
    )
    public static class PortraitDispose {
        /**
         * prefix 而不是 postfix 是为了尽可能避免可能出现的 dispose 冲突
         * 虽然之前用 prefix 其实没有什么问题
         */
        @SpirePrefixPatch
        public static void prefix(SingleCardViewPopup __instance) {
            if (PortraitGifRenderer.pGifRenderer != null) {
                PortraitGifRenderer.pGifRenderer.dispose();
                PortraitGifRenderer.pGifRenderer = null;
            }
        }
    }

}
