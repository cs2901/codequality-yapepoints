package calculator;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class Calculator {
    private float operand1;
    private float operand2;

    private Operation operation;
    private ArrayList<Operation> availableOperations = new ArrayList<>();
    private boolean exit = false;
    private Logger logger = Logger.getLogger(Calculator.class);

    Calculator() {
        Operation addition = new Addition();
        Operation substraction = new Substraction();
        Operation multiplication = new Multiplication();
        Operation division = new Division();
        availableOperations.add(addition);
        availableOperations.add(substraction);
        availableOperations.add(multiplication);
        availableOperations.add(division);
    }

    private void getInput() {
        Scanner myObj = new Scanner(System.in);

        logger.debug("Ingrese la operacion \"numero operador numero\": ");

        String line = myObj.nextLine();
        StringTokenizer st = new StringTokenizer(line);
        try {
            operand1 = Float.parseFloat(st.nextToken());
            String op = st.nextToken();

            switch (op) {
                case "+":
                    operation = availableOperations.get(0);
                    break;
                case "-":
                    operation = availableOperations.get(1);
                    break;
                case "*":
                    operation = availableOperations.get(2);
                    break;
                case "/":
                    operation = availableOperations.get(3);
                    break;
                default:
                    exit = true;
                    break;
            }

            operand2 = Float.parseFloat(st.nextToken());
        }catch (Exception e) {
            exit = true;
        }

    }

    void run() {
        while (true) {
            getInput();
            if(exit) {
                logger.debug("Adios");
                break;
            }else {
                logger.debug(operation.execute(operand1, operand2));
            }
        }
    }
}

