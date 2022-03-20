package blackjack.state;

import static blackjack.Fixtures.*;
import static org.assertj.core.api.Assertions.assertThat;

import blackjack.Cards;
import blackjack.state.Hit;
import blackjack.state.State;
import org.junit.jupiter.api.Test;

public class HitTest {


    @Test
    void hit() {

        final var state = new Hit(new Cards(SPADE_TWO,
                SPADE_JACK));

        assertThat(state).isInstanceOf(Hit.class);
    }


    @Test
    void hit2() {
        State state = new Hit(new Cards(SPADE_TWO, SPADE_JACK));
        state = state.draw(SPADE_ACE);

        assertThat(state).isInstanceOf(Hit.class);
    }

    @Test
    void stay(){
        State state = new Hit(new Cards(SPADE_TWO, SPADE_JACK))
                .draw(SPADE_ACE)
                .stay();

        assertThat(state).isInstanceOf(Stay.class);
    }
}
