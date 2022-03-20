package blackjack;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Card {

    private static final Map<String, Card> cache = new HashMap<>(52);

    private final Suit suit;

    private final Denomination denomination;

    private Card(final Suit suit,
                final Denomination denomination) {
        this.suit = suit;
        this.denomination = denomination;
    }

    public static Card of(final Suit suit,
                          final Denomination denomination) {
        return cache.computeIfAbsent(toKey(suit, denomination),
                i -> new Card(suit, denomination));
    }

    private static String toKey(Suit suit, Denomination denomination) {
        return suit.name() + denomination.name();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Card card = (Card) o;
        return suit == card.suit && denomination == card.denomination;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, denomination);
    }

    public int point() {
        return denomination.point();
    }

    public boolean isAce() {
        return denomination == Denomination.ACE;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", denomination=" + denomination +
                '}';
    }
}
