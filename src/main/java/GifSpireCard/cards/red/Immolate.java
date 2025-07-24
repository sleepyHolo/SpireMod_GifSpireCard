package GifSpireCard.cards.red;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Burn;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Immolate extends CustomCard {
    public static final String ID = "Immolate";
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public Immolate() {
        super(ID, cardStrings.NAME, "GSCResources/red/immolate.gif", 2, cardStrings.DESCRIPTION,
                CardType.ATTACK, CardColor.RED, CardRarity.RARE, CardTarget.ALL_ENEMY);
        this.baseDamage = 21;
        this.isMultiDamage = true;
        this.cardsToPreview = new Burn();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.FIRE));
        addToBot(new MakeTempCardInDiscardAction(new Burn(), 1));
    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeDamage(7);
        }
    }

    public AbstractCard makeCopy() {
        return new Immolate();
    }
}