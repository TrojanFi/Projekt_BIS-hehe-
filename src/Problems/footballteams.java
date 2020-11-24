package Problems;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
Exercise 9 from file reliability.pdf

Description:
Calculate chance for draw , won all by b team and chance for won minimal one match by b

Patterns:
draw = 100% -(chance for won a + chance for won b)
P(B winning three matches)=P(B wins 1st match)*P(B wins 2nd match)*P(B wins 3rd)
P(B loses three matches)=P(B lose 1st match)*P(B lose 2nd match)*P(B lose 3rd)
P(B wins at least one match) = 100% - P(B loses three matches)

Solution:
Create Test which have "Number of Breakdowns" and "Daily Frequency" and sum the result using the pattern.
If we have more rounds we multiplie more times the results which need multiplie.

Solved by Jakub Wiśniewski
*/
public class FootballTeams {

    public double FootBall(int numberofrounds){
        Scanner scanner = new Scanner(System.in);
        double draw;
        while (true || draw <= 100){
            try {
                draw = 0;
                double chance_for_b,chance_for_a,b_won_all,b_won_min_one,b_lose_all,b_lose;

                    System.out.println("What is a chance for win team a (example 50)? :");
                    chance_for_a = scanner.nextDouble();
                    System.out.println("What is a chance for win team b (example 30)? :");
                    chance_for_b = scanner.nextDouble();
                   draw = 100 - ((chance_for_a+chance_for_b));
                System.out.println("Chance for draw is equal = " + draw);

                b_won_all = chance_for_b/10;
                for(int i=0;i<=numberofrounds-1;i++)
                {
                    b_won_all=(b_won_all*chance_for_b)/10;
                }
                System.out.println("Chance for won all by b is equal : "+b_won_all);
                b_won_min_one=chance_for_b/10;
                b_lose=100-chance_for_b;
                b_lose_all = b_lose;
                for(int i=0;i<=numberofrounds-1;i++)
                {
                    b_lose_all =b_lose_all *b_lose;

                }
                b_won_min_one = 100 - b_lose_all;
                System.out.println("Chance for won min one by b is equal : "+b_won_min_one);

            }catch (InputMismatchException exception){
                System.out.println("Bad type of input :(");
                scanner.next();
                continue;
            }
            break;
        }
        return 0;
    }
}
