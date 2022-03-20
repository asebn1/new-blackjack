package blackjack;

import java.util.ArrayList;
import java.util.List;

public final class Cards {

    private final List<Card> cards;

    public Cards() {
        this(new ArrayList<>());
    }

    public Cards(final Card... cards) {
        this(new ArrayList<>(List.of(cards)));
    }

    public Cards(final List<Card> cards) {
        this.cards = cards;
    }


    public int sum() {
        return cards.stream().mapToInt(i -> i.point()).sum();
    }

    public boolean hasAce() {
        return cards.stream()
                .anyMatch(i -> i.isAce());
    }

    public boolean isReady(){
        return cards.size() < 2;
    }

    public boolean isBlackjack() {
        return sum() == 11 && hasAce();
    }

    public Cards add(Card card) {
        final var newValue = new ArrayList<>(cards);
        newValue.add(card);
        return new Cards(newValue);
    }

    public boolean isBust() {
        return sum() > 21;
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "cards=" + cards +
                '}';
    }

    public int getSize() {
        System.out.println(cards);
        return cards.size();
    }
}
