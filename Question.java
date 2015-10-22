/* 
Culminating Activity
ICS3U7 - 2D
Stephen Yang
Teacher: Ms. Xie
Program Name: Question.java
Description: In this class, there are methods mainly used to get questions, options, answers, and hints from text files and send it to the main program
*/
   import java.io.*;
   import java.util.*;
   public class Question
   {
   	// Static Variable Declarations
      static FileReader file;
      static BufferedReader buffer;
      static String question , a, b, c, d, answer, hint;
      static int value;
      // Methods
      public void question() // Constructor Method
      {
         try
         {
            file = new FileReader("questions.txt"); // Initializes  the FileReader
            buffer = new BufferedReader(file); // Initializes the BufferedReader
         }
            catch (IOException e)
            {

            }
      }
      public String getQuestion() // Method to return the question
      {
         try
         {
            question = buffer.readLine(); // Sets the value of question
         }
            catch (IOException e)
            {

            }
         return question;
      }
      public String getA() // Method to return option a
      {
         try
         {
            a  = buffer.readLine(); // Sets the value of a
         }
            catch (IOException e)
            {

            }
         return a;
      }
      public String getB() // Method to return option b
      {
         try
         {
            b  = buffer.readLine(); // Sets the value of b
         }
            catch (IOException e)
            {

            }
         return b;
      }
      public String getC() // Method to return option c
      {
         try
         {
            c  = buffer.readLine(); // Sets the value of c
         }
            catch (IOException e)
            {

            }
         return c;
      }
      public String getD() // Method to return option d
      {
         try
         {
            d  = buffer.readLine(); // Sets the value of d
         }
            catch (IOException e)
            {

            }
         return d;
      }
      public String getAnswer() // Method to return the answer
      {
         try
         {
            answer  = buffer.readLine(); // Sets the value of answer
         }
            catch (IOException e)
            {

            }
         return answer;
      }
      public String getHint() // Method to return the hint
      {
         try
         {
            hint  = buffer.readLine(); // Sets the value of hint
         }
            catch (IOException e)
            {

            }
         return hint; // returns hint
      }
      public void resetBuffer () // Method to reset the buffer so that the question becomes the very first question in the text file everytime a contestant finishes his/her turn
      {
         try
         {
            file.close(); // Closes the file
            buffer.close(); // Closes the buffer
            file = new FileReader("questions.txt"); // Reinitializes the file
            buffer = new BufferedReader(file); // Reinitializes the buffer
         }
            catch (IOException e)
            {
            }
      }
   }
