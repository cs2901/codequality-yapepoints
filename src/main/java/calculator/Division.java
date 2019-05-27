package calculator;

public class Division implements Operation {

    @Override
    public float execute(float operand1, float operand2) {
        try {
            return operand1 / operand2;
        }catch(Exception e) {
            System.out.println("Division por 0");
        }
        return 0;
    }

    Division() {}
}
