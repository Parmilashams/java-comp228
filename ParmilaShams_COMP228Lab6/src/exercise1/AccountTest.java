package exercise1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args) {
        // Created an account with an initial balance
        Account account = new Account(2000.0);

//        Transaction myTransaction = new Transaction(account,"withdraw",700);
//        Transaction myTransaction1 = new Transaction(account,"deposit",700);
//        Transaction myTransaction2 = new Transaction(account,"withdraw",700);
//        Transaction myTransaction3 = new Transaction(account,"deposit",700);
//
//        Transaction[] array1 = new Transaction[]{myTransaction1,myTransaction2,myTransaction3,myTransaction};
//        array1[0].run();
//        array1[1].run();
//        array1[2].run();
//        array1[3].run();

        //Our reason for using the arrayList instead of the array is so that we can increase the size of the number of transactions done
        //on that account

        // Create a list of transactions
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(account, "deposit", 0.0));
        transactions.add(new Transaction(account, "deposit", 100.0));
        transactions.add(new Transaction(account, "withdraw", 250.0));
        transactions.add(new Transaction(account, "deposit", 400.0));
        transactions.add(new Transaction(account, "withdraw", 800.0));

        // Create a thread pool to execute the transactions
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Execute each transaction
        for (Transaction transaction : transactions) {
            executorService.execute(transaction);
        }

        // Shut down the executor
        executorService.shutdown();
    }
}

