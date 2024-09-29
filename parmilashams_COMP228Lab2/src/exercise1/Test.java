package exercise1;

import javax.swing.*;
import java.util.Random;

public class Test {

    private String[] questions = {
            "Who is the designer of Java?",
            "Which of the following Java program units defines a group of related objects?",
            "Which access modifier is used to declare a private variable?",
            "Which keyword is used to define a constant variable?",
            "Which statement is used to exit a loop in Java?"
    };


    private String[][] options = {
            {"1. Guido van Rossum", "2. Anders Hejlsberg", "3. Bjarne Stroustrup", "4. James Gosling"},
            {"1. Java Method", "2. Java", "3. Java Default Constructor", "4. Java Class"},
            {"1. public", "2. private", "3. protected", "4. default"},
            {"1. static", "2. final", "3. const", "4. var"},
            {"1. exit", "2. break", "3. continue", "4. stop"}
    };


    private int[] answers = {4, 4, 2, 2, 2};
    private int correctAnswers = 0;
    private int incorrectAnswers = 0;
    private Random randomObject = new Random();

    public void inputAnswer() {
        for (int i = 0; i < questions.length; i++) {
            String userAnswer = simulateQuestion(i);
            checkAnswer(i, userAnswer);
        }
        displayResults();
    }

    private String simulateQuestion(int questionIndex) {
        StringBuilder questionWithOptions = new StringBuilder(questions[questionIndex]).append("\n");
        for (String option : options[questionIndex]) {
            questionWithOptions.append(option).append("\n");
        }
        return JOptionPane.showInputDialog(questionWithOptions.toString());
    }

    private void checkAnswer(int questionIndex, String userAnswer) {
        try {
            int answer = Integer.parseInt(userAnswer);
            if (answer == answers[questionIndex]) {
                correctAnswers++;
                generateMessage(true);
                incorrectAnswers++;
                generateMessage(false, answers[questionIndex]);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number between 1 and 4.");
        }
    }

    private void generateMessage(boolean isCorrect) {
        String message;
        switch (randomObject.nextInt(4)) { // Random feedback message generation
            case 0:
                message = isCorrect ? "Excellent!" : "No. Please try again.";
                break;
            case 1:
                message = isCorrect ? "Good!" : "Wrong. Try once more.";
                break;
            case 2:
                message = isCorrect ? "Keep up the good work!" : "Don't give up!";
                break;
            case 3:
                message = isCorrect ? "Nice work!" : "No. Keep trying.";
                break;
            default:
                message = "Try again.";
        }
        JOptionPane.showMessageDialog(null, message);
    }


    private void generateMessage(boolean isCorrect, int correctAnswer) {
        String incorrectMessage;
        switch (randomObject.nextInt(4)) {
            case 0:
                incorrectMessage = "No. Please try again.";
                break;
            case 1:
                incorrectMessage = "Wrong. Try once more.";
                break;
            case 2:
                incorrectMessage = "Don't give up!";
                break;
            case 3:
                incorrectMessage = "No. Keep trying.";
                break;
            default:
                incorrectMessage = "Wrong answer.";
        }

        JOptionPane.showMessageDialog(null, incorrectMessage + "\nThe correct answer was: " + correctAnswer);
    }


    private void displayResults() {
        int totalQuestions = questions.length;
        double percentage = (double) correctAnswers / totalQuestions * 100;
        String resultMessage = "Correct Answers: " + correctAnswers +
                "\nIncorrect Answers: " + incorrectAnswers +
                "\nPercentage Correct: " + String.format("%.2f", percentage) + "%";
        JOptionPane.showMessageDialog(null, resultMessage);
    }


}
