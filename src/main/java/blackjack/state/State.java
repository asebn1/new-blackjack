package blackjack.state;

import blackjack.Card;
import blackjack.Cards;

public interface State {

    State draw(Card card);

    State stay();

    Cards cards();

    boolean isFinished();

    double profit(double money);
}
