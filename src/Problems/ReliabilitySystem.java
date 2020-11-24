package Problems;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
Problem 3 from file ch11pp.d

Description:
Find the reliability of system

Patterns:
Example for :

     [0,92]              [0,95]
       |                   |
       |                   |
     [0,95]----[0,98]----[0,90]
     R= 0,95 + 0,92 * (1 - 0,95) * 0,98 * 0,90 + 0,95 * (1 - 0,90) = 0,966 what is 96,6%


Solution:
1.Ask for number of horizontal systems
2.Ask for relabilities of horizontal system
3. ask does this system have an added vertical system
4.if yes or no use other patterns
5.loop from 2. to 4 n times where n is number of horizontal systems

Solved by Jakub Wiśniewski
*/
public class ReliabilitySystem {
    public double Relability(){
        Scanner scanner = new Scanner(System.in);
        int choose,numberofsystem;
        double relability,relability2,sum=1;
        while (true){
            try {

                    System.out.println(" Please enter number of horizontal systems : ");
                   numberofsystem = scanner.nextInt();
                   for(int i = 0 ; i <= numberofsystem - 1 ; i++) {
                       System.out.println(" Please enter the reliability of horizontal System : ");
                       relability = scanner.nextDouble();
                       if (relability > 0.99) {
                           relability = relability / 100;
                       }
                       System.out.println(" Does this system have an added vertical system ? ( 1 - yes 2 -no) : ");
                       choose = scanner.nextInt();
                       if (choose == 1) {
                           System.out.println(" Please enter the reliability of vertical System: ");
                           relability2 = scanner.nextDouble();
                           if (relability2 > 0.99) {
                               relability2 = relability2 / 100;
                           }
                           sum = sum * ( relability + relability2 * ( 1 - relability ));
                       } else if (choose == 2) {
                          sum = sum * relability;
                       } else {
                           System.out.println(" You can only choose 1 or 2 ");
                       }
                   }
                System.out.println("The Reliability of the whole system you have build is: " + sum + ", which is: " + sum * 100 + "%.");

            }catch (InputMismatchException exception){
                System.out.println(" Bad type of input :( ");
                scanner.next();
                continue;
            }
            break;
        }
        return 0;
    }
}
