import Problems.BreakdownCost;
import Problems.ReliabilityTerms;
import Problems.TestDuration;
import Problems.FootballTeams;

import java.util.InputMismatchException;
import java.util.Scanner;


/*
Project Created by: Filip Trojanowski and Jakub Wiśniewski

 */
    public class Main {
        public static void main(String[] args) {

            BreakdownCost breakdownCost = new BreakdownCost();
            ReliabilityTerms reliabilityTerms = new ReliabilityTerms();
            TestDuration testDuration = new TestDuration();
            FootballTeams footballTeams = new FootballTeams();



            Scanner scanner = new Scanner(System.in);
            int choice;
            boolean status = true;
            do{
                try {
                    System.out.println("Please select a problem:");
                    System.out.println("[1] - Breakdown Cost\n[2] - Calculation of specific term (Rc,C,n)\n[3] - Calculation of test duration\n[4] - Calculation of winning the match (Football)\n[5] - \n[6] - Exit the program");
                    choice = scanner.nextInt();
                }catch (InputMismatchException inputMismatchException){
                    System.out.println("Wrong input try again :(");
                    scanner.next();
                    continue;
                }
                switch (choice){
                    case 1 -> {
                        breakdownCost.BreakdownCostTest();
                    }
                    case 2 -> {
                        reliabilityTerms.CalculationOfSpecificTerm();
                    }
                    case 3 -> {
                        testDuration.CalculatingTestDuration();
                    }
                    case 4 -> {
                        footballTeams.FootBall();
                    }
                    case 5 -> {
                    }
                    case 6 -> {
                        System.out.println("You exit the program");
                        status = false;
                    }
                    default -> {
                        System.out.println("Error");
                        status = false;
                    }
                }
            }while (status);
    }
}
