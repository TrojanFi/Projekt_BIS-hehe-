import Problems.BreakdownCost;
import Problems.ReliabilityTerms;
import Problems.TestLife;
import Problems.FootballTeams;
import Problems.ReliabilitySystem;

import java.util.InputMismatchException;
import java.util.Scanner;


/*
Project Created by: Filip Trojanowski and Jakub Wiśniewski

Task:
Creating Calculators for problems in given materials

Materials:
QITT03 - Reliability Test Planing & Weibull Analysis.pdf
reliability.pdf
ch17pp.doc


 */
    public class Main {
        public static void main(String[] args) {

            BreakdownCost breakdownCost = new BreakdownCost();
            ReliabilityTerms reliabilityTerms = new ReliabilityTerms();
            TestLife testDuration = new TestLife();
            FootballTeams footballTeams = new FootballTeams();
            ReliabilitySystem reliabilitySystem = new ReliabilitySystem();



            Scanner scanner = new Scanner(System.in);
            int choice;
            boolean status = true;
            do{
                try {
                    System.out.println("Please select a problem:");
                    System.out.println("[1] - Breakdown Cost\n[2] - Calculation of specific term (Rc,C,n)\n[3] - Calculation of test duration\n[4] - Calculation of winning the match (Football)\n[5] - Calculation of Reliability System \n[6] - Exit the program");
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
                        testDuration.CalculatingTestLife();
                    }
                    case 4 -> {
                        footballTeams.FootBall();
                    }
                    case 5 -> {
                        reliabilitySystem.Relability();
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
