package GifSpireCard.cards.red;

import basemod.AutoAdd;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.unique.BlockPerNonAttackAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SecondWind extends CustomCard {
    public static final String ID = "Second Wind";
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public SecondWind() {
        super(ID, cardStrings.NAME, "GSCResources/red/second_wind.gif", 1, cardStrings.DESCRIPTION,
                CardType.SKILL, CardColor.RED, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseBlock = 5;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new BlockPerNonAttackAction(this.block));
    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeBlock(2);
        }
    }

    public AbstractCard makeCopy() {
        return new SecondWind();
    }
}
