package blackjack.state;

import blackjack.Card;
import blackjack.Cards;

public final class Hit extends Running {

    Hit(final Cards cards) {
        super(cards);
    }

    @Override
    public State draw(final Card card) {
        final var cards = cards().add(card);

        if (cards.isBust()) {
            return new Bust(cards);
        }
        return new Hit(cards);
    }

    @Override
    public State stay() {
        return new Stay(cards());
    }
}
