package MathProblems.Solutions;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
PROBLEM NUMBER 4 

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

    public void BreakdownCost() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("Give me number of tests:");
                int numberOfTests = scanner.nextInt();
                double expectedNumberOfBreakDowns = NumberOfBreakdowns(numberOfTests);
                System.out.println("Give me a cost of one breakdown ($):");
                double cost = scanner.nextDouble();
                System.out.println("Expected breakdown cost:\n$" + cost*expectedNumberOfBreakDowns + "/day");
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
        double expectedNumberOfBreakDowns;
        while (true){
            try {
                expectedNumberOfBreakDowns = 0;
                double numberOfBreakDowns,dailyProbability;
                for(int i = 0; i < numberOfTests;i++){
                    System.out.println("Put Number of Breakdowns for test[" + i + "]:");
                    numberOfBreakDowns = scanner.nextDouble();
                    System.out.println("Put Daily Probability for test[" + i + "]:");
                    dailyProbability = scanner.nextDouble();
                    expectedNumberOfBreakDowns += numberOfBreakDowns * (dailyProbability/10);
                    System.out.println("Expected number of breakdowns = " + expectedNumberOfBreakDowns + " breakdowns/day");
                }

            }catch (InputMismatchException exception){
                System.out.println("Bad type of input :(");
                scanner.next();
                continue;
            }
            break;
        }
        return expectedNumberOfBreakDowns;
    }
}
