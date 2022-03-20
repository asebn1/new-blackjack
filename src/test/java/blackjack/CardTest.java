package blackjack;

import static blackjack.Fixtures.SPADE_ACE;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;


class CardTest {

    @Test
    void of(){
        assertThat(SPADE_ACE).isSameAs(SPADE_ACE);
    }
}
