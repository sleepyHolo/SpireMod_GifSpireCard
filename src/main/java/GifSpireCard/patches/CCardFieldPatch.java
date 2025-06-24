package GifSpireCard.patches;

import GifSpireCard.helpers.GifRenderer;
import basemod.abstracts.CustomCard;
import com.evacipated.cardcrawl.modthespire.lib.SpireField;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;

@SpirePatch(
        clz = CustomCard.class,
        method = SpirePatch.CLASS,
        requiredModId = "basemod"
)
public class CCardFieldPatch {
    public static SpireField<GifRenderer> gifRenderer = new SpireField<>(() -> null);

}
