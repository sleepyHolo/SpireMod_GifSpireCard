package GifSpireCard.cards.red;

import basemod.AutoAdd;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

@Deprecated
@AutoAdd.Ignore
public class Impervious extends CustomCard {
    public static final String ID = "Impervious";
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public Impervious() {
        super(ID, cardStrings.NAME, "GSCResources/red/impervious.gif", 2, cardStrings.DESCRIPTION,
                CardType.SKILL, CardColor.RED, CardRarity.RARE, CardTarget.SELF);
        this.baseBlock = 30;
        this.exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, this.block));
    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeBlock(10);
        }
    }

    public AbstractCard makeCopy() {
        return new Impervious();
    }
}