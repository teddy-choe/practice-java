package test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Main {
    public static void main(String[] args) {
        ThreadTask threadTask = new ThreadTask();
        Thread customer1 = new Thread(threadTask);
        Thread customer2 = new Thread(threadTask);

        customer1.start();
        customer2.start();
    }
}

class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public synchronized void withDraw(int money) {
        if (balance >= money) {
            try {
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName() + " money: " + money);
                thread.sleep(1000);
                this.balance -= money;
                System.out.println(thread.getName() + " balance: " + balance);
            } catch (InterruptedException error) {
                error.printStackTrace();
            }
        }
    }

    public int getBalance() {
        return this.balance;
    }
}

class ThreadTask implements Runnable {
    private Account account = new Account(2000);

    @Override
    public void run() {
        while (account.getBalance() > 0) {
            int money = (int) ((Math.random() * 3) + 1) * 100;
            account.withDraw(money);
        }
        DocumentBuilderFactory.newInstance();
    }
}
