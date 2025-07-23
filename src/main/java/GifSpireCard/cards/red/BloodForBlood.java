package GifSpireCard.cards.red;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class BloodForBlood extends CustomCard {
    public static final String ID = "Blood for Blood";
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public BloodForBlood() {
        super(ID, cardStrings.NAME, "GSCResources/red/blood_for_blood.gif", 4, cardStrings.DESCRIPTION,
                CardType.ATTACK, CardColor.RED, CardRarity.UNCOMMON, CardTarget.ENEMY);
        this.baseDamage = 18;
    }

    public void tookDamage() {
        updateCost(-1);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HEAVY));
    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            if (this.cost < 4) {
                upgradeBaseCost(this.cost - 1);
                if (this.cost < 0)
                    this.cost = 0;
            } else {
                upgradeBaseCost(3);
            }
            upgradeDamage(4);
        }
    }

    public AbstractCard makeCopy() {
        AbstractCard tmp = new BloodForBlood();
        if (AbstractDungeon.player != null)
            tmp.updateCost(-AbstractDungeon.player.damagedThisCombat);
        return tmp;
    }
}