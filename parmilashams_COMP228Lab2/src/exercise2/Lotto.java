package exercise2;

import java.util.Random;

public class Lotto {
    private int[] lottoNumbers; // Array

    // Constructor
    public Lotto() {
        lottoNumbers = new int[3];
        generateLottoNumbers();
    }

    // Method
    private void generateLottoNumbers() {
        Random random = new Random();
        for (int i = 0; i < lottoNumbers.length; i++) {
            lottoNumbers[i] = random.nextInt(9) + 1; // Generate numbers 1-9
        }
    }

    // Method
    public int[] getLottoNumbers() {
        return lottoNumbers;
    }

    // Method
    public int calculateSum() {
        int sum = 0;
        for (int num : lottoNumbers) {
            sum += num;
        }
        return sum;
    }
}
