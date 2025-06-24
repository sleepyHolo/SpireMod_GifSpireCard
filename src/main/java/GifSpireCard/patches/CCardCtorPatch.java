package GifSpireCard.patches;

import GifSpireCard.helpers.CardGifManager;
import basemod.abstracts.CustomCard;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.cards.AbstractCard.CardType;
import com.megacrit.cardcrawl.cards.AbstractCard.CardColor;
import com.megacrit.cardcrawl.cards.AbstractCard.CardRarity;
import com.megacrit.cardcrawl.cards.AbstractCard.CardTarget;

@SpirePatch(
        clz = CustomCard.class,
        method = SpirePatch.CONSTRUCTOR,
        paramtypez = {String.class, String.class, String.class, int.class, String.class,
                CardType.class, CardColor.class, CardRarity.class, CardTarget.class},
        requiredModId = "basemod"
)
public class CCardCtorPatch {
    @SpirePostfixPatch
    public static void postfix(CustomCard __instance, String id, String name, String imgUrl, int cost, String rawDescription,
                               CardType type, CardColor color, CardRarity rarity, CardTarget target) {
        if (imgUrl.substring(imgUrl.lastIndexOf(".")).equals(".gif")) {
            CCardFieldPatch.gifRenderer.set(__instance, CardGifManager.getGifRenderer(imgUrl));
        }
    }

}
