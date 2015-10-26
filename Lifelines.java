/* 
Stephen Yang
Program Name: Lifelines.java
Description: This class handles everything to do with the lifelines including using them, checking to see if you have any left, tc.
*/
	// Import Statements
   import java.io.*;
   import java.util.*;
   public class Lifelines
   {
   	// Static variable declarations
      static String lifelines[] = {"25-75", "50-50", "HINT"};
      static int numLifelines=3, value = 0;
      static Scanner scanner = new Scanner(System.in);
      static String[] answers = new String[4];
      static String a, b, c, d, question, hint;
      static boolean haslife = true, sameturn = false;
      // Methods
      public void lifelines(String ma, String mb, String mc, String md, String manswer, String mquestion, String mhint, int mvalue)
      {
      	// The following statements initialize variables with the question, options, hints and answers of the question the user is currently on.
         a = ma;
         b= mb;
         c = mc;
         d = md;
         question = mquestion;
         hint = mhint;
         answers = new String[] {a, b, c, d};
         value = mvalue;
      }
      public boolean hasLifeline()
      {
         if (numLifelines>0) // Checks to see if the user has a lifeline to use
         {
            return true; // If yes, return ture
         }
         else
         {
            return false; // Otherwise return false
         }
      }
      public String useLifeline(String a, String b, String c, String d, String answer, String question, String hint)
      {
      	// Variable Declarations
         String fa = Character.toString(a.charAt(0)), fb=Character.toString(b.charAt(0)), fc=Character.toString(c.charAt(0)), fd=Character.toString(d.charAt(0)), useranswer = "";
         String choice;
         boolean choicevar = false, exit = false;
         Random random = new Random();
         int randomnum;
         if (hasLifeline()) // Checks if they a lifeline and outputs it
         {
            System.out.println("\nYou have exactly "+numLifelines+" Lifelines remaining");
            for (int i = 0; i<3; i++)
            {
               if (lifelines[i]!="")
               {
                  System.out.println(lifelines[i]+" ");
               }
            }
            do // Do while loop to get them to enter a lifeline to use
            {
               exit = false; // Resets exit to false
               System.out.print("Enter a Lifeline to use: ");
               choice = scanner.nextLine(); // Gets the choice the user makes
               if (choice.compareTo("25-75")==0&&lifelines[0].compareTo("")==0) // Sees if they have the 25-75 lifeline
               {
                  System.out.println("Error! Invalid Entry");
                  exit = true;
               }
               else if (choice.compareTo("50-50")==0&&lifelines[1].compareTo("")==0) // Sees if they have the 50-50 lifeline
               {
                  System.out.println("Error! Invalid Entry");
                  exit = true;
               }
               else if (choice.compareTo("HINT")==0&&lifelines[2].compareTo("")==0) // Sees if they have the HINT lifeline
               {
                  System.out.println("Error! Invalid Entry");
                  exit = true;
               }
               if (exit != true && choice != "50-50") // Checks to see if the exit is true and if they chose 50-50 or not
               {
                  if (choice.compareTo(lifelines[0])!=0&&choice.compareTo(lifelines[1])!=0&&choice.compareTo(lifelines[2])!=0) // If the choice does not equal any lifeline, it outputs an error message
                  {
                     System.out.println("Error! Invalid Entry");
                     exit = true;
                  }
               }
            } while (exit == true);
            if (choice.compareTo("25-75")==0&&sameturn == false) // 25-75 Lifeline
            {
               if (lifelines[0].compareTo("")!=0) // Checks to see if you have used 25-75 or not
               {
                  if (answer.compareTo(fa)==0) // Checks to see what the answer is
                  {
                     answers = new String[] {b, c, d}; // Creates an array using the remaining possible answers
                  }
                  else if (answer.compareTo(fb)==0) // Checks to see what the answer is
                  {
                     answers = new String[] {a, c, d}; // Creates an array using the remaining possible answers
                  }
                  else if (answer.compareTo(fc)==0) // Checks to see what the answer is
                  {
                     answers = new String[] {a, b, d}; // Creates an array using the remaining possible answers
                  }
                  else if (answer.compareTo(fd)==0) // Checks to see what the answer is
                  {
                     answers = new String[] {a, b, c}; // Creates an array using the remaining possible answers
                  }
                  randomnum = random.nextInt(3); // New Random Integer
                  answers[randomnum] = answer; // Replaces a random answer with the actual answer
                  Arrays.sort(answers); // Sorts the array
                  System.out.println("\n"+question); // Outputs the question once again
                  for (int i = 0; i<3; i++) // For loop to display possible answers
                  {
                     if (a.charAt(0) == answers[i].charAt(0)) // Checks to see if the first character for a is the same as the first character of the answer.
                     {
                        answers[i] = a; // Sets a as the value as answers with the index of i
                        System.out.println(a+" "); // Prints a
                     }
                     if (b.charAt(0) == answers[i].charAt(0)) // Checks to see if the first character for b is the same as the first character of the answer.
                     {
                        answers[i] = b; // Sets b as the value as answers with the index of i
                        System.out.println(b+" ");  // Prints b
                     }
                     if (c.charAt(0) == answers[i].charAt(0)) // Checks to see if the first character for c is the same as the first character of the answer.
                     {
                        answers[i] = c; // Sets c as the value as answers with the index of i
                        System.out.println(c+" ");  // Prints c
                     }
                     if (d.charAt(0) == answers[i].charAt(0)) // Checks to see if the first character for d is the same as the first character of the answer.
                     {
                        answers[i] = d; // Sets d as the value as answers with the index of i
                        System.out.println(d+" ");  // Prints d
                     }
                  }
                  if (hasLifeline()) // Checks if you have a lifeline
                  {
                     System.out.println("\ne) Use a lifeline");
                  }
                  if (value != 500) // Checks to see if the value is 500 or not
                  {
                     System.out.println("f) Give up\n");
                  }
                  numLifelines--; // Decreases the number of Lifelines
                  do // Do while loop for the answer
                  {
                     System.out.print("Enter your answer: ");
                     useranswer = scanner.nextLine(); // Gets the user's answer
                     useranswer = useranswer.toLowerCase(); // Changes the answer to lower case
                     if (useranswer.charAt(0)<97|| useranswer.charAt(0)>102) // Checks to see if the answer is between a and f
                     {
                        System.out.println("Invalid Entry!");
                     }
                     if (useranswer.compareTo("e")== 0&& haslife == false) // Checks to see if you have any lifelines left
                     {
                        System.out.println("Error! You are out of Lifelines!");
                        do // Do while loop for the answer
                        {
                           System.out.print("Enter your answer: ");
                           useranswer = scanner.nextLine(); // Gets the user's answer
                           useranswer = useranswer.toLowerCase(); // Changes the answer to lower case
                           if (useranswer.charAt(0)<97|| useranswer.charAt(0)>102) // Checks to see if the answer is between a and f
                           {
                              System.out.println("Invalid Entry!");
                           }
                           if (useranswer.compareTo("e")== 0&& haslife == false) // Checks to see if you have any lifelines left
                           {
                              System.out.println("Error! You are out of Lifelines!");
                           }
                        } while (useranswer.compareTo("e")== 0 ||(useranswer.charAt(0)<97|| useranswer.charAt(0)>102)); // Keeps going if the user enters e again
                     }
                     if (useranswer.compareTo("f")==0&&value==500) // Checks to see if it is the first turn and outputs an error if they attempt to quit on the first turn
                     {
                        System.out.println("You cannot quit on the first turn!");
                     }
                  } while ((useranswer.charAt(0)<97|| useranswer.charAt(0)>102)||(useranswer.compareTo("f")==0&&value==500)); // End of Do While Loop
                  lifelines[0]=""; // Sets the value of the index of lifelines for 25-75 as nothing
               }
               else if (choice.compareTo("25-75")==0&&sameturn == true) // Else statement if they have just used 50-50
               {
                  System.out.println("If you use this lifeline you will get the same results you already have.\n");
                  System.out.println(question); // Reprints the question
                  for (int i = 0; i<answers.length; i++)
                  {
                     System.out.println(answers[i]); // Prints all possible answers
                  }
                  if (hasLifeline())
                  {
                     System.out.println("\ne) Use a lifeline\n"); // Checks to see if the user has a lifeline
                  }
                  System.out.println("Enter your answer: ");
                  useranswer = scanner.nextLine(); // Gets the users response
               }
            }
            else if (choice.compareTo("50-50")==0&&lifelines[1]!="") // 50-50
            {
               if (answer.compareTo(fa)==0) // Checks to see what the answer is
               {
                  answers = new String[] {b, c, d}; // Creates an array using the remaining possible answers
               }
               else if (answer.compareTo(fb)==0) // Checks to see what the answer is
               {
                  answers = new String[] {a, c, d}; // Creates an array using the remaining possible answers
               }
               else if (answer.compareTo(fc)==0) // Checks to see what the answer is
               {
                  answers = new String[] {a, b, d}; // Creates an array using the remaining possible answers
               }
               else if (answer.compareTo(fd)==0) // Checks to see what the answer is
               {
                  answers = new String[] {a, b, c}; // Creates an array using the remaining possible answers
               }
               randomnum = random.nextInt(3); // Random Number
               answers[randomnum] = "";; // Replaces a random answer with nothing
               if (randomnum == 0) // Checks to see what the random number is
               {
                  answers = new String[] {answers[1], answers[2]}; // Creates new array based on the remaining answers
               }
               else if (randomnum == 1) // Checks to see what the random number is
               {
                  answers = new String[] {answers[0], answers[2]}; // Creates new array based on the remaining answers
               }
               else if (randomnum == 2) // Checks to see what the random number is
               {
                  answers = new String[] {answers[0], answers[1]}; // Creates new array based on the remaining answers
               }
               randomnum = random.nextInt(2); // Gets a random number
               answers[randomnum] = answer; // Resets the possible answer at that number to the actual answer
               Arrays.sort(answers); // Sorts array
               System.out.println("\n"+question); // Prints Question
               for (int i = 0; i<2; i++) // For loop to print answers
               {
                  if (a.charAt(0) == answers[i].charAt(0)) // Checks to see if the first character for a is the same as the first character of the answer.
                  {
                     answers[i] = a; // Sets a as the value as answers with the index of i
                     System.out.println(a+" "); // Prints a
                  }
                  if (b.charAt(0) == answers[i].charAt(0)) // Checks to see if the first character for a is the same as the first character of the answer.
                  {
                     answers[i] = b; // Sets b as the value as answers with the index of i
                     System.out.println(b+" "); // Prints b
                  }
                  if (c.charAt(0) == answers[i].charAt(0)) // Checks to see if the first character for a is the same as the first character of the answer.
                  {
                     answers[i] = c; // Sets c as the value as answers with the index of i
                     System.out.println(c+" "); // Prints c
                  }
                  if (d.charAt(0) == answers[i].charAt(0)) // Checks to see if the first character for a is the same as the first character of the answer.
                  {
                     answers[i] = d; // Sets d as the value as answers with the index of i
                     System.out.println(d+" "); // Prints d
                  }
               }
               numLifelines--; // Decreases numLifelines by 1
               if (hasLifeline()) // Checks to see if they have a lifeline
               {
                  System.out.println("\ne) Use a lifeline"); // Prints the option for e
               }
               if (value != 500) // Checks to see if it is the first turn
               {
                  System.out.println("f) Give up\n"); // Prints the option for f
               }
               else
               {
                  System.out.println(); // Prints extra line
               }
               do{ // Do while loop to get the answer
                  System.out.print("Enter your answer: ");
                  useranswer = scanner.nextLine(); // Gets the answer
                  useranswer = useranswer.toLowerCase(); // Changes it to lowercase
                  if (useranswer.charAt(0)<97|| useranswer.charAt(0)>102) // Checks to see if it is between a and f
                  {
                     System.out.println("Invalid Entry!");
                  }
                  if (useranswer.compareTo("f")==0&&value==500) // Checks to see if the user wants to quit the game
                  {
                     System.out.println("You cannot quit on the first turn!");
                  }
               } while ((useranswer.charAt(0)<97|| useranswer.charAt(0)>102)||(useranswer.compareTo("f")==0&&value==500)); // End of Do while Loop
               lifelines[1]=""; // Resets the lifeline for 50-50 to nothing
               sameturn = true; // Sets it to true showing it has been used this turn
            }
            else if (choice.compareTo("HINT")==0&&lifelines[2]!="") // Hint
            {
               System.out.println("\n"+question); // Prints out the question
               for (int i = 0; i<answers.length; i++)
               {
                  System.out.println(answers[i]); // Prints out the answers
               }
               numLifelines--; // Lowers the number of lifelines by 1
               if (hasLifeline()) // Checks to see if they have a lifeline
               {
                  System.out.println("\ne) Use a lifeline"); // Prints the option for e
               }
               if (value != 500) // Prints out the option to give up/quit
               {
                  System.out.println("f) Give up\n");
               }
               System.out.println("\n"+hint+"\n"); // Prints out the hint
               do // Do while loop for their answer
               {
                  System.out.print("Enter your answer: ");
                  useranswer = scanner.nextLine(); // Gets their answer
                  useranswer = useranswer.toLowerCase(); // Makes the answer lowercase
                  if (useranswer.charAt(0)<97|| useranswer.charAt(0)>102) // Checks to see if the answer is between a and f
                  {
                     System.out.println("Invalid Entry!");
                  }
                  if (useranswer.compareTo("e")== 0&& haslife == false) // Checks to see if they have any lifelines should they want to use it
                  {
                     System.out.println("Error! You are out of Lifelines!"); // Error Printing
                     do // Do while loop for the answer
                     {
                        System.out.print("Enter your answer: ");
                        useranswer = scanner.nextLine(); // Gets their answer
                        useranswer = useranswer.toLowerCase(); // Makes the answer lowercase
                        if (useranswer.charAt(0)<97|| useranswer.charAt(0)>102) // Checks to see if the answer is between a and f
                        {
                           System.out.println("Invalid Entry!");
                        }
                        if (useranswer.compareTo("e")== 0&& numLifelines<=0) // Checks to see if they have any lifelines should they want to use it
                        {
                           System.out.println("Error! You are out of Lifelines!");
                        }
                     } while (useranswer.compareTo("e")== 0 ||(useranswer.charAt(0)<97|| useranswer.charAt(0)>102)); // End of Do while Loop
                  }
                  if (useranswer.compareTo("f")==0&&value==500) // Checks to see if they want to quit on the first turn
                  {
                     System.out.println("You cannot quit on the first turn!"); // Error Message
                  }
               } while ((useranswer.charAt(0)<97|| useranswer.charAt(0)>102)||(useranswer.compareTo("f")==0&&value==500)); // End of Do While Loop
               lifelines[2] = ""; // Set the lifeline for HINT as nothing
               answers = new String[4]; // Reset Answers
            }
         }
         else // If they have no lifelines
         {
            System.out.println("Error! You are out of Lifelines!"); // Error Message
            do  // Do while loop for the answer
            {
               System.out.print("Enter your answer: ");
               useranswer = scanner.nextLine(); // Gets the answer
               useranswer = useranswer.toLowerCase(); // Changes to lowercase
               if (useranswer.charAt(0)<97|| useranswer.charAt(0)>102) // Checks to see if the answer is between a and f
               {
                  System.out.println("Invalid Entry!");
               }
               if (useranswer.compareTo("e")== 0&& numLifelines<=0) // Checks to see if they have any lifelines should they want to use it
               {
                  System.out.println("Error! You are out of Lifelines!");
               }
            } while (useranswer.compareTo("e")== 0 ||(useranswer.charAt(0)<97|| useranswer.charAt(0)>102)); // End of Do While Loop
         }
         return useranswer; // Return the Answer
      }
      public void resetLifelines () // Reset Lifelines
      {
         numLifelines = 3; // Reset NumofLifelines
         lifelines = new String[] {"25-75", "50-50", "HINT"}; // Reset all lifelines
      }
      public void resetAnswers (String ma, String mb, String mc, String md) // Reset the answers
      {
         answers = new String[] {ma, mb, mc, md}; // New Array
      }
      public void newValue (int mvalue) // Get the New Value and assign it to value
      {
         value = mvalue; // assigning the value from the main file to the value here
      }
      public void resetSameturn () // Get the New Value and assign it to value
      {
         sameturn = false; // resetting sameturn
      }
   }
