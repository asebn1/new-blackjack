package blackjack.state;

import blackjack.Cards;

public final class Stay extends Finished{

    protected Stay(Cards cards) {
        super(cards);
    }

    @Override
    protected double earningRate() {
        return 1;
    }
}
