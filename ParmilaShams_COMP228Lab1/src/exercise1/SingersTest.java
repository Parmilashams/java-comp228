package exercise1;

import java.util.Date;

public class SingersTest {
    public static void main(String[] args) {
        // Create a Singer object using the no-argument constructor
        Singers singer1 = new Singers();

        // Display default values
        System.out.println("Default values of singer1:");
        singer1.displaySingerInfo();

        // Set individual values using setters
        singer1.setSingerId(202);
        singer1.setSingerName("Maher Zain");
        singer1.setSingerAddress("Sweden");
        singer1.setDateOfBirth(new Date(81, 6, 16));
        singer1.setAlbumsPublished(3);

        // Display updated values
        System.out.println("\nUpdated values of singer1:");
        singer1.displaySingerInfo();
    }
}
