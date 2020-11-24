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
1.Ask for number of rounds
2.Ask for chance for win a team
3.Ask for chance for win b team
4.Use patterns

Solved by Jakub Wiśniewski
*/
public class FootballTeams {

    public double FootBall(){
        Scanner scanner = new Scanner(System.in);
        double draw;
        while (true){
            try {
                int numberofrounds;

                double chance_for_b,chance_for_a,b_won_all,b_won_min_one,b_lose_all,b_lose;
                System.out.println("How many rounds :");
                numberofrounds = scanner.nextInt();
                int z=(numberofrounds -3);
                    System.out.println("What is a chance for win team a in percent(example 0,5)? :");
                    chance_for_a = scanner.nextDouble();

                if (chance_for_a > 0.99) {
                    chance_for_a = chance_for_a / 100;
                }
                    System.out.println("What is a chance for win team b in percent(example 0,3)? :");
                    chance_for_b = scanner.nextDouble();
                if (chance_for_b > 0.99) {
                    chance_for_b = chance_for_b / 100;
                }

                    draw = 1 - (chance_for_a + chance_for_b);
                    /*a)*/System.out.println("Chance for draw is equal = " + Math.round(draw * 100) + " %");

                b_won_all = chance_for_b;
                for(int i = 0;i <= numberofrounds-2;i++)
                {
                    b_won_all = b_won_all * chance_for_b;
                }
                /*b)*/ System.out.println("Chance for won all by b is equal : "+ b_won_all * Math.pow(10, numberofrounds-z) + " %");
                b_won_min_one = chance_for_b;
                b_lose = 1 - chance_for_b;
                b_lose_all = b_lose;
                for(int i = 0;i <= numberofrounds - 2 ; i++)
                {
                    b_lose_all = b_lose_all * b_lose;

                }
                b_won_min_one = 1 - b_lose_all;
                /*c)*/  System.out.println("Chance for won min one by b is equal : " + b_won_min_one * 100 + " %");

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
