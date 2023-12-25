import java.util.ArrayList;
import java.util.Scanner;

public class ActualGame{

    public void Game(){
    ArrayList<Long> TimesAL = new ArrayList<Long>();
    ArrayList<Integer> WrongAnswersAL = new ArrayList<Integer>();
    Scanner Ans = new Scanner(System.in);
    System.out.println("How many questions do you want in each attempt? ");
    int Questions = Ans.nextInt();
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
    int contin = 0;
    while (contin == 0) {
    int WrongAnswers = 0;
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
  int totalwrong = Methods.sumsArray(WrongAnswersAL);
  long average = Methods.calculateAverage(TimesAL);
  long average_time_per_question = (average * TimesAL.size())/(Questions * TimesAL.size());
  String ActualStringTime = Methods.FormatString(timeElapsed);
  String ActualAverageTime = Methods.FormatString(average);
  String ActualATPTime = Methods.FormatString(average_time_per_question);
  
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
}