package GifSpireCard.cards.red;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.NoDrawPower;

public class BattleTrance extends CustomCard {
    public static final String ID = "Battle Trance";
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public BattleTrance() {
        super(ID, cardStrings.NAME, "GSCResources/red/battle_trance.gif", 0, cardStrings.DESCRIPTION,
                CardType.SKILL, CardColor.RED, CardRarity.UNCOMMON, CardTarget.NONE);
        this.baseMagicNumber = 3;
        this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DrawCardAction(p, this.magicNumber));
        addToBot(new ApplyPowerAction(p, p, new NoDrawPower(p)));
    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeMagicNumber(1);
        }
    }

    public AbstractCard makeCopy() {
        return new BattleTrance();
    }
}