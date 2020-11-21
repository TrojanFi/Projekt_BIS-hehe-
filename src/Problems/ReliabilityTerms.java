package Problems;

import java.util.InputMismatchException;
import java.util.Scanner;

/*

RELATIONSHIP AMONG SAMPLE SIZE, CONFIDENCE AND RELIABILITY

Success-run theorem (Bayes’ formula)
 C = 1 - (Rc ) n+1

Where Rc = Reliability at confidence
 C = Confidence level
 n = Sample size
Assumption: All samples tested at desired life and there is no failure.



Solved by Filip Trojanowski
 */
public class ReliabilityTerms {

    public double CalculationOfSpecificTerm(){
        Scanner scanner = new Scanner(System.in);
        int choice = 3;
        double result = 0;
        while(true){
            try{
                do {
                    System.out.println("What do you want to calculate from : C = 1 - (Rc)^(n+1)\nWhere:\n[0] Rc = Reliability at confidence\n[1] C = Confidence level\n[2] n = Sample size");
                    choice = scanner.nextInt();
                }while(choice != 0 && choice !=1 && choice != 2 );
                switch (choice){
                    case 0-> {
                        System.out.println("You chose to calculate Reliability at confidence");
                        result = CalculatingReliabilityAtConfidence();
                        System.out.println( "Result:\nRc = " + result + "%" );
                        return result;
                    }
                    case 1->{
                        System.out.println("You chose to calculate Confidence level");
                        result = CalculatingConfidenceLevel();
                        System.out.println( "Result:\nC = " + result + "%" );
                        return result;
                    }
                    case 2-> {
                        System.out.println("You chose to calculate Sample size");
                        result = CalculatingSampleSize();
                        System.out.println( "Result:\nn = " + result );
                        return result;
                    }
                    default -> System.out.println("Error");
                }
            }catch (InputMismatchException inputMismatchException){
                System.out.println("You put wrong type of input :(");
                scanner.next();
                continue;
            }
            break;
        }
        return result;
    }

    public double CalculatingReliabilityAtConfidence(){
        Scanner scanner = new Scanner(System.in);
        double confidenceLevel = 0;
        double sampleSize = 0;
        double result = 0;
        while(true){
            try {
                System.out.println("Set Confidence Level(%).[For example: 0,90, 0,23] :");
                confidenceLevel = scanner.nextDouble();
                System.out.println("C = " + confidenceLevel + "\nSet Sample Size.[For example: 4,7] :");
                sampleSize = scanner.nextDouble();
                System.out.println("C = " + confidenceLevel + ", n = " + sampleSize);
                result = ProvidedDataForRc(confidenceLevel,sampleSize);
            }catch (InputMismatchException inputMismatchException){
                System.out.println("You put wrong type of input :(");
                scanner.next();
                continue;
            }
            break;
        }
    return result;
    }
    public double ProvidedDataForRc(double confidenceLevel,double sampleSize){
        double Rc = Math.pow(1 - confidenceLevel,1/sampleSize);
        return Math.round(Rc*100);
    }
    public double CalculatingConfidenceLevel(){
        Scanner scanner = new Scanner(System.in);
        double reliability = 0;
        double sampleSize = 0;

        double result = 0;
        while(true){
            try {
                System.out.println("Set Reliability at confidence (%).[For example: 0,90, 0,23] :");
                reliability = scanner.nextDouble();
                System.out.println("Rc = " + reliability + "\nSet Sample Size.[For example: 4,7] :");
                sampleSize = scanner.nextDouble();
                System.out.println("Rc = " + reliability + ", n = " + sampleSize);
                result = ProvidedDataForC(reliability,sampleSize);
            }catch (InputMismatchException inputMismatchException){
                System.out.println("You put wrong type of input :(");
                scanner.next();
                continue;
            }
            break;
        }
        return result;
    }
    public double ProvidedDataForC(double reliability,double sampleSize){
        double C = 1 - Math.pow(reliability,sampleSize+1);
        return Math.round(C*100);
    }
    public double CalculatingSampleSize(){
        Scanner scanner = new Scanner(System.in);
        double reliability = 0;
        double confidenceLevel = 0;
        double result = 0;
        while(true){
            try {
                System.out.println("Set Reliability at confidence (%).[For example: 0,90, 0,23] :");
                reliability = scanner.nextDouble();
                System.out.println("Rc = " + reliability + "\nSet Confidence Level(%).[For example: 0,90, 0,23] :");
                confidenceLevel = scanner.nextDouble();
                System.out.println("Rc = " + reliability + ", C = " + confidenceLevel);
                result = ProvidedDataForN(reliability,confidenceLevel);
            }catch (InputMismatchException inputMismatchException){
                System.out.println("You put wrong type of input :(");
                scanner.next();
                continue;
            }
            break;
        }
        return result;
    }
    public double ProvidedDataForN(double reliability,double confidenceLevel){
        double n = Math.log(1 - confidenceLevel)/Math.log(reliability) - 1;
        return Math.round(n);
    }

}
