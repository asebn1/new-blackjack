package blackjack.state;

import blackjack.Card;
import blackjack.Cards;

public final class Ready extends Running{

    public Ready() {
        this(new Cards());
    }

    public Ready(final Cards cards) {
        super(cards);
    }

    @Override
    public State draw(Card card) {
        final var cards = cards().add(card);
        if (cards.isReady()){
            return new Ready(cards);
        }
        if (cards.isBlackjack()) {
            return new Blackjack(cards);
        }
        return new Hit(cards);
    }

    @Override
    public State stay() {
        throw new IllegalStateException();
    }
}
