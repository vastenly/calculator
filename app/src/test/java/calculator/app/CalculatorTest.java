package calculator.app;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("calculator.app.CalculatorDataProvider#provideInputWithResult")
    void testGetMessage(String input, String testResult) {
         try {
             String result = Calculator.calc(input);
             System.out.println(result);
             assertEquals(testResult, result);
         } catch (IllegalArgumentException e) {
             System.out.println(e.getMessage());
         }
     }
}
