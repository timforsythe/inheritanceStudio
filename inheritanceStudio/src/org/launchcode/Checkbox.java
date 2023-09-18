package org.launchcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Checkbox extends Question {

    private ArrayList<String> possibleAnswers;
    private ArrayList<Integer> correctAnswers;

    public Checkbox(int pointValue, String text, ArrayList<String> possibleAnswers, ArrayList<Integer> correctAnswers) {
        super(pointValue, text);
        this.possibleAnswers = possibleAnswers;
        this.correctAnswers = correctAnswers;
        setPointValue(this.correctAnswers.size());
    }

    @Override
    public void displayAnswers () {
        for (int i = 0; i < possibleAnswers.size(); i++) {
            System.out.println(possibleAnswers.get(i));
        }
    }

    public int checkAnswers(ArrayList<Integer> check) {
        int answersCorrect = 0;
        for (int i = 0; i < check.size(); i++) {
            if (correctAnswers.contains(check.get(i))) {
                answersCorrect++;
            }
        }
        return answersCorrect;
    }

    @Override
    public int getAnswers() {
        ArrayList<Integer> usersAnswers = new ArrayList<>();
        System.out.println("For this question, there could be multiple correct answers. To begin answering the question, simply press 'y'.");
        Scanner userContinue = new Scanner(System.in);
        String goingToContinue = userContinue.nextLine();
        while (goingToContinue.indexOf('y') >= 0 && usersAnswers.size() <= possibleAnswers.size()) {
            System.out.println("What will your answer(s) be? Enter the number of an answer you believe is correct. For example, to select the first option, enter 1");
            Scanner userAnswer = new Scanner(System.in);
            String answer = userAnswer.nextLine();
            int option = Integer.parseInt(answer);
            usersAnswers.add(option);

            System.out.println("For this question, there could be multiple correct answers. To continue selecting answers, press 'y'. If you are finished, press 'n'");
            goingToContinue = userContinue.nextLine();
        }

        return checkAnswers(usersAnswers);
    }

}
