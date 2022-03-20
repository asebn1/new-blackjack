package blackjack.state;

import static blackjack.Fixtures.*;
import static org.assertj.core.api.Assertions.*;

import blackjack.state.Bust;
import blackjack.state.Hit;
import blackjack.state.Ready;
import org.junit.jupiter.api.Test;

public class ReadyTest {

    @Test
    void ready() {
        final var state = new Ready().draw(SPADE_TWO);

        assertThat(state).isInstanceOf(Ready.class);
    }

    @Test
    void hit() {
        final var state = new Ready().draw(SPADE_TWO)
                .draw(SPADE_JACK);

        assertThat(state).isInstanceOf(Hit.class);
    }

    @Test
    void hitHit() {
        final var state = new Ready().draw(SPADE_TWO)
                .draw(SPADE_JACK)
                .draw(SPADE_ACE);

        assertThat(state).isInstanceOf(Hit.class);
    }

    @Test
    void hitBust() {
        var state = new Ready().draw(SPADE_TWO)
                .draw(SPADE_JACK)
                .draw(SPADE_TEN);

        assertThat(state).isInstanceOf(Bust.class);
    }

    @Test
    void blackjack() {
        // blackjack은 더 이상 게임할 수 없다.
        final var state = new Ready().draw(SPADE_ACE)
                .draw(SPADE_JACK);

        assertThatThrownBy(() -> state.draw(SPADE_ACE))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void bustDraw() {
        var state = new Ready().draw(SPADE_TWO)
                .draw(SPADE_JACK)
                .draw(SPADE_TEN);

        assertThatThrownBy(() -> state.draw(SPADE_ACE))
                .isInstanceOf(IllegalStateException.class);
    }
}
