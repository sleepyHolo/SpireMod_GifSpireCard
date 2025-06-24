package GifSpireCard;

import basemod.AutoAdd;
import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpireInitializer
public class GifSpireCard implements
        EditCardsSubscriber,
        PostInitializeSubscriber {
    private static final Logger logger = LogManager.getLogger(GifSpireCard.class.getName());
    public static String MOD_ID = "GifSpireCard";

    public GifSpireCard() {
    }

    public static void initialize() {
        GifSpireCard mod = new GifSpireCard();
        BaseMod.subscribe(mod, EditCardsSubscriber.class);
        BaseMod.subscribe(mod, PostInitializeSubscriber.class);
    }

    public static void sideload() {
        GifSpireCard mod = new GifSpireCard();
        BaseMod.subscribe(mod, PostInitializeSubscriber.class);
    }

    @Override
    public void receiveEditCards() {
        logger.info("Override red cards.");
        new AutoAdd(MOD_ID)
                .packageFilter("GifSpireCard.cards.red")
                .setDefaultSeen(true)
                .cards();
    }

    @Override
    public void receivePostInitialize() {
        BaseMod.registerModBadge(ImageMaster.loadImage("GSCResources/badge.png"),
                MOD_ID, "__name__", "", null);
    }

}
