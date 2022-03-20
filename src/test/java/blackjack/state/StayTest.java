package blackjack.state;

import static blackjack.Fixtures.*;
import static org.assertj.core.api.Assertions.*;

import blackjack.Cards;
import blackjack.Fixtures;
import org.junit.jupiter.api.Test;

class StayTest {

    @Test
    void stay() {
        final var state = new Stay(new Cards(SPADE_TWO, SPADE_JACK));

        assertThatThrownBy(state::stay)
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void draw() {
        final var state = new Stay(new Cards(SPADE_TWO, SPADE_JACK));

        assertThatThrownBy(() -> state.draw(SPADE_ACE))
                .isInstanceOf(IllegalStateException.class);
    }
}
