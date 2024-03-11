package math;

import java.util.logging.Logger;

public class CalculatorLogger implements Calculator{

    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    private final Calculator calculator;

    public CalculatorLogger(final Calculator calculator) {

        this.calculator = calculator;
    }

    public double add(final double a, final double b) {
        logger.info("Add wird gerufen");

        return calculator.add(a, b);
    }

    public double sub(final double a, final double b) {
        return calculator.sub(a, b);
    }
}
