package fr.lernejo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SampleTest {

    private final Sample sample = new Sample();

    @Test
    void add_2_and_2_should_return_4() {
        int result = sample.op(Sample.Operation.ADD, 2, 2);

        Assertions.assertThat(result)
            .as("Addition of 2 and 2")
            .isEqualTo(4);
    }
    @Test
    void fact_return_int() {
        int result = sample.fact( 4);

        boolean isInt = (result>=0);

        Assertions.assertThat(isInt)
            .as("Is it an int ?")
            .isEqualTo(true);
    }
    @Test
    void multi_2_and_3_should_return_6() {
        int result = sample.op(Sample.Operation.MULT, 2, 3);

        Assertions.assertThat(result)
            .as("Multiplication of 2 and 3")
            .isEqualTo(6);
    }

    @Test
    void fact_3_return_6() {
        int result = sample.fact( 3);

        Assertions.assertThat(result)
            .as("Facto of 3")
            .isEqualTo(6);
    }

    @Test
    void n_should_be_positive() {
        assertThrows( IllegalArgumentException.class, () -> sample.fact( -3));
    }
}
