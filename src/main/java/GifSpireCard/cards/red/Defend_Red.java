package GifSpireCard.cards.red;


import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Defend_Red extends CustomCard {
    public static final String ID = "Defend_R";
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public Defend_Red() {
        super(ID, cardStrings.NAME, "GSCResources/red/defend_r.gif", 1, cardStrings.DESCRIPTION,
                CardType.SKILL, CardColor.RED, CardRarity.BASIC, CardTarget.SELF);
        this.baseBlock = 5;
        this.tags.add(AbstractCard.CardTags.STARTER_DEFEND);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, this.block));
    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeBlock(3);
        }
    }

    public AbstractCard makeCopy() {
        return new Defend_Red();
    }
}