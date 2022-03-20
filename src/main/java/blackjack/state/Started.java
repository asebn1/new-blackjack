package blackjack.state;

import blackjack.Cards;

public abstract class Started implements State {

    private final Cards cards;

    Started(final Cards cards) {
        this.cards = cards;
    }

    @Override
    public final Cards cards() {
        return cards;
    }
}
