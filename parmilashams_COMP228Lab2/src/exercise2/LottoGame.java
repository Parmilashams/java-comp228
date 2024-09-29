package exercise2;

import javax.swing.*;

public class LottoGame {

    public static void main(String[] args) {

        int chosenNumber = Integer.parseInt(JOptionPane.showInputDialog("Choose a number between 3 and 27:"));
        int attempts = 0;


        for (attempts = 0; attempts < 5; attempts++) {
            Lotto lotto = new Lotto();
            int sum = lotto.calculateSum();
            JOptionPane.showMessageDialog(null, "Lotto numbers: " + lotto.getLottoNumbers()[0] + ", " +
                    lotto.getLottoNumbers()[1] + ", " + lotto.getLottoNumbers()[2] + "\nSum: " + sum);

            if (sum == chosenNumber) {
                JOptionPane.showMessageDialog(null, "Congratulations! You win!");
                return;
            } else {
                JOptionPane.showMessageDialog(null, "No match. Try again.");
            }
        }
        JOptionPane.showMessageDialog(null, "You lost! The computer wins.");
    }
}
