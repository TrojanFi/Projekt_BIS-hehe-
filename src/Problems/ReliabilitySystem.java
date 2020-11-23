package Problems;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReliabilitySystem {
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
