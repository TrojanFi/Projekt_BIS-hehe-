package Problems;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
PROBLEM NUMBER 4 from file ch17pp.doc

Description:
Calculating the breakdown cost

Patterns:
Number of BreakDowns * Daily Frequency = breakdowns/day
breakdowns/day * cost of one breakdown = Expected breakdown cost

Solution:
Create Test which have "Number of Breakdowns" and "Daily Frequency" and sum the result using the pattern.
If we have more tests we sum the results of each test.

Solved by Filip Trojanowski
*/

public class BreakdownCost {

    public void BreakdownCostTest() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("Give me number of tests:");
                int numberOfTests = scanner.nextInt();
                double expectedNumberOfBreakdowns = NumberOfBreakdowns(numberOfTests);
                System.out.println("Give me a cost of one breakdown ($):");
                double cost = scanner.nextDouble();
                System.out.println("Expected breakdown cost:\n$" + cost*expectedNumberOfBreakdowns + "/day");
            }catch (InputMismatchException inputMismatchException){
                System.out.println("Bad type of input :(");
                scanner.next();
                continue;
            }
            break;
        }

    }

    public double NumberOfBreakdowns(int numberOfTests){
        Scanner scanner = new Scanner(System.in);
        double expectedNumberOfBreakdowns;
        while (true){
            try {
                expectedNumberOfBreakdowns = 0;
                double numberOfBreakdowns,dailyFrequency;
                for(int i = 0; i < numberOfTests;i++){
                    System.out.println("Put Number of Breakdowns for test[" + i + "].[For example: 3, 4, 9]:");
                    numberOfBreakdowns = scanner.nextDouble();
                    System.out.println("Put Daily Frequency for test[" + i + "].[For example: 3, 4, 9]:");
                    dailyFrequency = scanner.nextDouble();
                    expectedNumberOfBreakdowns += numberOfBreakdowns * (dailyFrequency/10);
                    System.out.println("Expected number of breakdowns = " + expectedNumberOfBreakdowns + " breakdowns/day");
                }

            }catch (InputMismatchException exception){
                System.out.println("Bad type of input :(");
                scanner.next();
                continue;
            }
            break;
        }
        return expectedNumberOfBreakdowns;
    }
}
