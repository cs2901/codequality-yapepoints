package calculator;

public class Division implements Operation {

    @Override
    public float execute(float operand1, float operand2) {
        if (operand2 == 0) {
            System.out.println("Division por 0");
            return 0;
        }else {
            return operand1 / operand2;
        }
    }

    Division() {}
}
