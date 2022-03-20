package blackjack.state;

import blackjack.Cards;

public abstract class Running extends Started{

    public Running(Cards cards) {
        super(cards);
    }

    @Override
    public final boolean isFinished() {
        return false;
    }

    @Override
    public final double profit(double money) {
        throw new IllegalStateException();
    }
}
