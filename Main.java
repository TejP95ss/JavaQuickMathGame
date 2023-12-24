import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {

    ArrayList<Long> TimesAL = new ArrayList<Long>();
    ArrayList<Integer> WrongAnswersAL = new ArrayList<Integer>();
    int contin = 0;
    Scanner Ans = new Scanner(System.in);
    while (contin == 0) {
    int Questions = 5,  WrongAnswers = 0;
    char[] OperatorArray = {'+', '-', '*', '^'};
    long start = System.nanoTime();

    for (int i = 0; i < Questions; i++)
    {
  boolean Correct = false; 
  boolean CurrentAnswerWrong = false;
  int IntAns = 0;
  int OpNum = (int)(Math.random() * OperatorArray.length);
  char ActualOperator = OperatorArray[OpNum];
  int CorrectAnswerBased = 0;
  switch (ActualOperator) {
    case '+':
      int LeftAdd = (int)(Math.random() * 50);
	    int RightAdd = (int)(Math.random() * 50);
      String SLeftAdd = String.valueOf(LeftAdd); 
      String SRightAdd = String.valueOf(RightAdd);
      while (Correct == false) {
      System.out.print(SLeftAdd + " + " + SRightAdd + " = ");
      IntAns = Ans.nextInt();  
      CorrectAnswerBased = LeftAdd + RightAdd;
      if (IntAns == CorrectAnswerBased) {
          Correct = true;
          continue;
        } else {
        if (CurrentAnswerWrong == false) {
          WrongAnswers += 1;
          CurrentAnswerWrong = true; 
          System.out.println("The answer is incorrect. Try again."); }

        else {System.out.println("The answer is incorrect. Try again.");} }   
    }
      break;
    case '-':
      int LeftSub = (int)(Math.random() * 50);
	    int RightSub = (int)(Math.random() * 50);
      String SLeftSub = String.valueOf(LeftSub); 
      String SRightSub = String.valueOf(RightSub);
      while (Correct == false) {
      System.out.print(SLeftSub + " - " + SRightSub + " = ");
      IntAns = Ans.nextInt();  
      CorrectAnswerBased = LeftSub - RightSub;
      if (IntAns == CorrectAnswerBased) {
          Correct = true;
          continue;
        } else {
        if (CurrentAnswerWrong == false) {
          WrongAnswers += 1;
          CurrentAnswerWrong = true; 
          System.out.println("The answer is incorrect. Try again."); }
          
        else {System.out.println("The answer is incorrect. Try again.");}}   
    }
      break;
    case '*':
      int LeftMult = (int)(Math.random() * 20);
	    int RightMult = (int)(Math.random() * 20);
      String SLeftMult = String.valueOf(LeftMult); 
      String SRightMult = String.valueOf(RightMult);
      while (Correct == false) {
      System.out.print(SLeftMult + " * " + SRightMult + " = ");
      IntAns = Ans.nextInt();  
      CorrectAnswerBased = LeftMult * RightMult;
      if (IntAns == CorrectAnswerBased) {
          Correct = true;
          continue;
        } else {
        if (CurrentAnswerWrong == false) {
          WrongAnswers += 1;
          CurrentAnswerWrong = true; 
          System.out.println("The answer is incorrect. Try again."); }
          
        else {System.out.println("The answer is incorrect. Try again.");}}   
    }
      break;
      case '^':
      int LeftExp = (int)(Math.random() * 20) + 1;
	    int RightExp = (int)(Math.random() * 2) + 2;
      String SLeftExp = String.valueOf(LeftExp); 
      String SRightExp = String.valueOf(RightExp);
      while (Correct == false) {
      System.out.print(SLeftExp + " ^ " + SRightExp + " = ");
      IntAns = Ans.nextInt();  
      CorrectAnswerBased = (int)Math.pow(LeftExp, RightExp);
      if (IntAns == CorrectAnswerBased) {
          Correct = true;
          continue;
        } else {
        if (CurrentAnswerWrong == false) {
          WrongAnswers += 1;
          CurrentAnswerWrong = true; 
          System.out.println("The answer is incorrect. Try again."); }
          
        else {System.out.println("The answer is incorrect. Try again.");}}   
    }
      break;
    }


if (i == Questions - 1) {
  long end = System.nanoTime();
  long timeElapsed = (end - start);
  TimesAL.add(timeElapsed);
  WrongAnswersAL.add(WrongAnswers);
  int totalwrong = Main.sumsArray(WrongAnswersAL);
  long average = Main.calculateAverage(TimesAL);
  long average_time_per_question = (average * TimesAL.size())/(Questions * TimesAL.size());
  String ActualStringTime = Main.FormatString(timeElapsed);
  String ActualAverageTime = Main.FormatString(average);
  String ActualATPTime = Main.FormatString(average_time_per_question);
  
  switch (WrongAnswers)
  {
    case 0:
    System.out.println("You answered all questions correctly in " + ActualStringTime + " seconds!");
    break;

    default:
    System.out.println("You got " + WrongAnswers + " question(s) wrong in " + ActualStringTime + " seconds!");
    break;
}
  System.out.println("Type '1' to quit and see your results or any other integer to continue: ");
  contin = Ans.nextInt(); 
  if (contin == 1) {
    Ans.close(); 
    System.out.print("You averaged " + ActualAverageTime + " seconds over the past " + TimesAL.size()); 
    System.out.println(" attempt(s) of " + Questions + " question(s) each spending an average of " +  ActualATPTime + " seconds per question");
    System.out.println("In total, you got " + totalwrong + " question(s) wrong out of " + (Questions * TimesAL.size()) + " total question(s).");} }
}
  
}
}
static long calculateAverage(ArrayList<Long> values) {
    long sum = 0;
    long sizeofvalues = values.size();
    if (!values.isEmpty()) {
        for (long v : values) {
            sum += v;
        }
    }
     return sum/sizeofvalues;
}

static int sumsArray(ArrayList<Integer> values) {
    int sum = 0;
    if (!values.isEmpty()) {
        for (long v: values) {
            sum += v;
        }
    }
     return sum;
}

static String FormatString(Long str) {
  String Converted = String.valueOf(str);
  String formatted = "";
  for (int n = 0; n < Converted.length() - 6; n++) {
    if (n == Converted.length() - 9) {
      formatted = formatted + "." + Converted.charAt(n); 
    } 
    else {formatted = formatted + Converted.charAt(n);}
  }
  return formatted;
}

}