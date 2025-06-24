package GifSpireCard.cards.red;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.unique.SpotWeaknessAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SpotWeakness extends CustomCard {
    public static final String ID = "Spot Weakness";
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public SpotWeakness() {
        super(ID, cardStrings.NAME, "GSCResources/red/spot_weakness.gif", 1, cardStrings.DESCRIPTION,
                CardType.SKILL, CardColor.RED, CardRarity.UNCOMMON, CardTarget.SELF_AND_ENEMY);
        this.baseMagicNumber = 3;
        this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new SpotWeaknessAction(this.magicNumber, m));
    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeMagicNumber(1);
        }
    }

    public AbstractCard makeCopy() {
        return new SpotWeakness();
    }
}
