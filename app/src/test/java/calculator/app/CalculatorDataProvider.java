package calculator.app;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class CalculatorDataProvider {

    @MethodSource("provideInputWithResult")
    public static Stream<Arguments> provideInputWithResult() {
        return Stream.of(
                Arguments.of("1 + 2", "3"),
                Arguments.of("VI / III", "II"),
                Arguments.of("I - II", ""),
                Arguments.of("I + 1", ""),
                Arguments.of("1", ""),
                Arguments.of("1 + 2 + 3", "")
        );
    }
}
