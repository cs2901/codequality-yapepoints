package calculator;

import org.apache.log4j.Logger;

public class Division implements Operation {

    private Logger logger = Logger.getLogger(Calculator.class);

    @Override
    public float execute(float operand1, float operand2) {
        if (operand2 == 0) {
            logger.debug("Division por 0");
            return 0;
        }else {
            return operand1 / operand2;
        }
    }
}
