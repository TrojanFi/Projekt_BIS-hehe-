package Problems;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
Exercise 4.1 from QITT03 - Reliability Test Planing & Weibull Analysis.pdf

Description:
Design a test to demonstrate 100,000 miles life at 95% reliability and 60% confidence.
The available sample size is 6.(Assume b=2)

Ans:
Test life 179,000 miles.

Solution:
Creating a calculator with data given from a user. Use formula from example 2.1.

Solved by Filip Trojanowski
*/
public class TestLife {

    public void CalculatingTestLife(){
        Scanner scanner = new Scanner(System.in);
        double miles,reliability,confidence,sampleSize,weibull;
        while(true){
            try{
                do {
                    System.out.println("Give How long life in miles must have a test.[For example: 100000]:");
                    miles = scanner.nextDouble();
                    System.out.println("Give the reliability %.[For example: 0,95]:");
                    reliability = scanner.nextDouble();
                    System.out.println("Give the confidence %.[For example: 0,6]:");
                    confidence = scanner.nextDouble();
                    System.out.println("Give available sample size.[For example: 6]");
                    sampleSize = Math.round(scanner.nextDouble());
                    System.out.println("Give Weibull.[For example: 2]");
                    weibull = scanner.nextDouble();
                }while (miles == 0 || reliability == 0 || confidence == 0 || sampleSize ==0 || weibull ==0);
                System.out.println("Test life = " + ProvidedDataForTestLife(miles,reliability,confidence,sampleSize,weibull) + " miles");
            }catch (InputMismatchException inputMismatchException){
                System.out.println("Bad input :(");
                scanner.next();
                continue;
            }
            break;
        }
    }
    public double ProvidedDataForTestLife(double miles, double reliability, double confidence, double sampleSize, double weibull){
        double result = miles*(Math.pow(((1/sampleSize)*Math.log(1/(1-confidence)))/(Math.log(1/(reliability))),(1/weibull)));
        System.out.println("Calculated result without rounding:\n" + result);
        return Math.abs(Math.round(result));
    }
}
