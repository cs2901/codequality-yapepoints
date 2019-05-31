package calculator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class Calculator {
    private float operand1;
    private float operand2;

    private Operation operation;
    private ArrayList<Operation> availableOperations = new ArrayList<>();
    private boolean exit = false;

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
        System.out.println("Ingrese la operacion \"numero operador numero\": ");

        String line = myObj.nextLine();
        StringTokenizer st = new StringTokenizer(line);
        try {
            operand1 = Float.parseFloat(st.nextToken());
            String op = st.nextToken();

            if(op.equals("+")) {
                operation = availableOperations.get(0);
            }else if(op.equals("-")) {
                operation = availableOperations.get(1);
            }else if(op.equals("*")) {
                operation = availableOperations.get(2);
            }else if(op.equals("/")) {
                operation = availableOperations.get(3);
            }else {
                exit = true;
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
                System.out.println("Adios");
                break;
            }else {
                System.out.println(operation.execute(operand1, operand2));
            }
        }
    }
}
