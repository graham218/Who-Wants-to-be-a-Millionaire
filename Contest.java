/* 
Bill Graham
Program Name: Contest.java
Description: This program is the main program of the Who Wants to be a Millionaire game. In this file, it outputs all the questions and possible answers then asks the user for a response. Afterwards, It verifies the answer and calls on the according methods from other classes to do tasks. In the end, It also calculates the winners and outputs them.
*/

// Import Packages
import java.io.*;
import java.util.*;

public class Contest
{
	// Static Variable Declarations
   static Question questionclass[] = new Question[4]; // Initialize the questionclass object
   static Contestant contestantclass[] = new Contestant[4]; // Initialize the contestantclass object
   static Lifelines lifelineclass[] = new Lifelines [4]; // Initialize the lifelineclass object
   public static void main (String[] args)
   {
      // Variable Declarations
      Scanner scanner = new Scanner (System.in);
      int value = 500, values [] = new int [] {500, 1000, 2000, 5000, 10000, 20000, 50000, 75000, 150000, 250000, 500000, 1000000}, money[] = new int [4], winnervalue=0, count = 0;
      String question="", a = "", b = "", c = "", d = "", answer="", hint = "", names[] = new String [4], response = "";
      boolean rightwrong = false, quit = false;
      // Main Program
      for (int i = 0; i<4; i++) // In this for loop, All of the Class Objects Ex. Contestantclass are initialized through the use of constructor methods.
      {
         questionclass[i]= new Question (); // Initialize questionclass
         questionclass[i].question(); // Execute Question Method
         contestantclass[i] = new Contestant(); // Initialize contestantclass
         contestantclass[i].contestant(); // Execute Contestant Method
         names = contestantclass[i].getNames();  // Initialize names of contestants
         lifelineclass[i] = new Lifelines (); // Initialize lifelineclass
         lifelineclass[i].lifelines (a, b, c, d, answer, question, hint, values[i]); // Initializes values in Lifeline class
      }
      System.out.println("\t\t-----------------------------");
      System.out.println("\t\tWho Wants to be a Millionaire");
      System.out.println("\t\t-----------------------------");
      for (int i = 0; i<4; i++) // For loop for the 4 contestants
      {
         count = 0;
         quit = false;
         value = 500; // Initializes value as the first value, $500
         questionclass[i].resetBuffer(); // Resets the Buffer for every Contestants
         lifelineclass[i].resetLifelines(); // Resets Lifelines for the contestants
         do // Do while loop for the questions until the player chooses to quit or gets a question wrong
         {
            lifelineclass[i].newValue(value); // Resets the value in Lifelines Class
            if (value == 500)
            {
               System.out.println(names[i]+", It's Your Turn to play...... Who wants to be a Millionaire! Piracy Edition\n"); // Outputs a player's name and introduction to the game
            }
            for (int j = 1; j<=7; j++) // For loop to initalize all the questions, answers, possible answers, and the hints.
            {
               if (j == 1)
               {
                  question = questionclass[i].getQuestion(); // Initializes Question
                  System.out.println("For $"+value+"....... "+question);
               }
               if (j == 2)
               {
                  a = questionclass[i].getA(); // Initializes option a
                  System.out.println(a);
               }
               if (j == 3)
               {
                  b = questionclass[i].getB(); // Initializes option b
                  System.out.println(b);
               }
               if (j == 4)
               {
                  c = questionclass[i].getC(); // Initializes option c
                  System.out.println(c);
               }
               if (j == 5)
               {
                  d = questionclass[i].getD(); // Initializes option d
                  System.out.println(d);
               }
               if (j == 6)
               {
                  answer = questionclass[i].getAnswer(); // Intialize the answer
               }
               if (j == 7)
               {
                  hint = questionclass[i].getHint(); // Initialize the hint
               }
            }
            if (lifelineclass[i].hasLifeline()) // Checks to see if there are any lifelines
            {
               System.out.println("\ne) Use a lifeline");
               if (value == 500) // If this is the first question, output an extra line
               {
                  System.out.println();
               }
            }
            lifelineclass[i].resetAnswers(a, b, c, d); // Resets the answers for the values in the lifeline class
            if (value != 500&&lifelineclass[i].hasLifeline() == false) // Check if it is the first question or not and if there are any lifelines
            {
               System.out.println("\nf) Walk out\n");
            }
            else  if (value != 500) // Check if it is the first question or not
            {
               System.out.println("f) Walk out\n");
            }
            do // Do while to check the response of the contestant and to ensure they enter a valid option
            {
               System.out.print("Enter your answer: ");
               response = scanner.nextLine(); // Gets the input of the user
               response = response.toLowerCase(); // Changes the input to lowercase
               if (response.charAt(0)<97|| response.charAt(0)>102) // Check to see if the value is between a and f
               {
                  System.out.println("Invalid Entry!");
               }
               if (lifelineclass[i].hasLifeline() == false&&response.compareTo("e")==0) // Checks to see if there are any lifelines
               {
                  System.out.println("Invalid Entry! You are out of Lifeline!");
               }
               if (response.compareTo("f")==0&&value==500) // Error output if they attempt to quit on the first turn
               {
                  System.out.println("You cannot quit on the first turn!");
               }
            } while ((response.charAt(0)<97|| response.charAt(0)>102)||(lifelineclass[i].hasLifeline() == false&&response.compareTo("e")==0)|| (response.compareTo("f")==0&&value==500));
            if (response.compareTo("e")==0&&lifelineclass[i].hasLifeline()) // If statement to check if they have any lifelines and if they choose lifelines.
            {
               do // Do while loop to keep using a lifeline as long as they enter e.
               {
                  response = lifelineclass[i].useLifeline(a, b, c, d, answer, question, hint);
               } while (response.compareTo("e")==0);
            }
            if (response.compareTo("f")==0&&value != 500) // Checks to see if the user wants to quit, then it outputs a thank you statement and quits the game for that user.
            {
               System.out.println("Thanks for playing!");
               quit = true; // Boolean to tell the game to end for that user
            }
            if (lifelineclass[i].hasLifeline() == false) // Checks to see if the user has any lifelines
            {
               if (response.compareTo("e") == 0) // Checks to see if the user has chosen to use a lifeline
               {
                  do{ // Do while loop to tell them they are out of lifelines and input the correct answer
                     System.out.print("You are out of lifelines!\nEnter your response again: ");
                     response = scanner.nextLine();
                  } while (response.compareTo("a")!=0&&response.compareTo("b")!=0&&response.compareTo("c")!=0&&response.compareTo("d")!=0&&response.compareTo("f")!=0);
               }
            }
            if (response.compareTo(answer) == 0) // Checks to see if the question is correct
            {
               rightwrong = true;
            }
            else // Otherwise it keeps the variable as false and shows that they did not answer correctly
            {
               rightwrong = false;
            }
            if (rightwrong == true&&value!=1000000) // Outputs if they are correct or not while it is not the last question
            {
               System.out.println ("\nWell done! "+answer+" is correct!\n");
               value = values[count+1];
            }
            else if (rightwrong == true&&value==1000000)  // Outputs if they are corect or not while it is the last question
            {
               System.out.println("Congratulations!!!! You have now won One Million Dollars!\n");
               contestantclass[i].setValue(value, names[i]); // Set the value won by that user
               rightwrong = false;
            }
            else if (rightwrong == false&&response.compareTo("f")!=0) // Checks to see if they have not chosen to leave the game and got the question right or wrong
            {
               value = contestantclass[i].getLastValue(value, rightwrong); // Finds the last milestone they reached
               contestantclass[i].setValue(value, names[i]); // Sets the last value as the value won
               System.out.println("\nSorry, You are Incorrect! The correct answer was: "+answer);
               System.out.println("You are going home with.......... $" + value+"\n");
            }
            else if (rightwrong == false&&response.compareTo("f")==0) // Checks to see if they have chosen to leave the game
            {
               value = contestantclass[i].getExitValue(value); // Gets the value of the last question they got right
               contestantclass[i].setValue(value, names[i]); // Sets the value to be the amount won
               System.out.println("\nYou have decided to leave the game! The correct answer was: "+answer);
               System.out.println("You are going home with.......... $" + value+"\n");
            }
            count++; // Increases the count
            lifelineclass[i].resetSameturn();
         }  while (rightwrong != false && value<=1000000 && quit!=true); // End of Do While Loop
      }
      money = contestantclass[1].getArray(); // Gets the array of the values won and gives it to the array called money
      for (int i = 0; i<4; i++) // For loop to find the value of the winner
      {
         if (i == 0) // Checks to see if it is the first time. If yes, it initializes the first users values as the winners values
         {
            winnervalue = money[i];
         }
         else
         {
            if (money[i]>winnervalue) // Checks to see if the value won by the user is higher than the current highest value
            {
               winnervalue = money[i]; // Finds the value of the winner
            }
         }
      }
      System.out.println("Results"); // Outputs a table of the results
      for (int i = 0; i<4; i++) // For loop to Output the names and values of the money for each contestant
      {
         System.out.println(names[i]+"\t$"+money[i]);
      }
      if (winnervalue!=0) // Checks to see if the value of the winner is 0 or not to determine what to output
      {
         System.out.print ("The winners are: ");
      }
      else if (winnervalue == 0) // Checks to see if the value of the winner is 0 or not to determine what to output
      {
         System.out.print ("Nobody Won!");
      }
      for (int i = 0; i<4; i++) // For loop to find the names of the winners
      {
         if (money[i] == winnervalue&&money[i]!=0&&winnervalue!=0) // Checks to see if the winners value is equal to the value won by the current user
         {
            System.out.print(names[i]+", ");
         }
      }
   }
}
