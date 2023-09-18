package org.launchcode;

import java.util.ArrayList;
import java.util.Arrays;

public class QuizRunner {
    public static void main(String[] args) {
        Quiz myQuiz = new Quiz(new ArrayList<>());
        ArrayList<String> possAns1 = new ArrayList<>(Arrays.asList("1. Garfield", "2. Salem", "3. Cheshire", "4. Tom"));
        ArrayList<Integer> correctAns1 = new ArrayList<>(Arrays.asList(2,3));
        Checkbox newQuestion1 = new Checkbox(2, "Who is the best cat in the world?", possAns1, correctAns1);
        myQuiz.addQuestion(newQuestion1);
        ArrayList<String> possAns2 = new ArrayList<>(Arrays.asList("1. Doc", "2. Tillie", "3. Gizmo", "4. Benji", "5. Nala"));
        MultipleChoice newQuestion2 = new MultipleChoice(1, "Who won the Halloween Costume Contest?", 3, possAns2);
        myQuiz.addQuestion(newQuestion2);
        TrueOrFalse newQuestion3 = new TrueOrFalse(1, "Are all dogs the best?", true);
        myQuiz.addQuestion(newQuestion3);

        myQuiz.runQuiz();

        myQuiz.gradeQuiz();
    }

}
