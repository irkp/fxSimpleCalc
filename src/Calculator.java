import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.math.MathContext;

class Calculator {

    private Logger log = Logger.getLogger(Calculator.class);

    BigDecimal calculate(BigDecimal firstNumber, BigDecimal secondNumber, String operator) {
        switch (operator) {
            case "+":
                return firstNumber.add(secondNumber);
            case "-":
                return firstNumber.subtract(secondNumber);
            case "*":
                return firstNumber.multiply(secondNumber);
            case "/":
                if (BigDecimal.ZERO.equals(secondNumber)){
                    throw new IllegalArgumentException("Argument 'divisor' is 0");
                }
                return firstNumber.divide(secondNumber, MathContext.DECIMAL64);
        }
        log.info("Unknown operator - " + operator);
        return BigDecimal.ZERO;
    }
}