package Problems;


import javax.sound.midi.Soundbank;
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

    public void CalculationOfSpecificTerm(){
        Scanner scanner = new Scanner(System.in);
        int choice = 3;
        double result;
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
                    }
                    case 1->{
                        System.out.println("You chose to calculate Confidence level");
                        result = CalculatingConfidenceLevel();
                    }
                    case 2-> {
                        System.out.println("You chose to calculate Sample size");
                        result = CalculatingSampleSize();
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
    }

    public double CalculatingReliabilityAtConfidence(){

        while(true){
            try {
                System.out.println("Set Confidence Level. For example: 0.90,0.23");

            }catch (InputMismatchException inputMismatchException){
                System.out.println("You put wrong type of input :(");
            }
            break;
        }
    return 0;
    }
    public double CalculatingConfidenceLevel(){
    return 0;
    }
    public double CalculatingSampleSize(){
    return 0;
    }

}
