package blackjack.state;

import blackjack.Cards;

public final class Bust extends Finished{

    Bust(Cards cards) {
        super(cards);
    }

    @Override
    protected double earningRate() {
        return -1;
    }
}
