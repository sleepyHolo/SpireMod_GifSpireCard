package GifSpireCard.patches;

import basemod.abstracts.CustomCard;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.megacrit.cardcrawl.cards.AbstractCard;

@SpirePatch(
        clz = AbstractCard.class,
        method = "renderPortrait",
        paramtypez = {SpriteBatch.class},
        requiredModId = "basemod"
)
public class AbstractCardPatch {
    @SpirePrefixPatch
    public static void prefix(AbstractCard __instance, SpriteBatch sb) {
        if (!(__instance instanceof CustomCard)) {
            return;
        }
        if (CCardFieldPatch.gifRenderer.get(__instance) != null) {
            __instance.portrait = CCardFieldPatch.gifRenderer.get(__instance).getPortrait();
        }

    }

}