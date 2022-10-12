package com.company;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(100);
        Clan clan1 = new Clan("Clane", 0);
        for (int i = 0; i < 400; i++) {
            Thread thread = new Thread(new UserAddGoldService(semaphore, i+1, clan1));
            Thread thread2 = new Thread(new UserDecreaseGoldService(semaphore, i+1, clan1));
            thread.start();
            thread2.start();
        }
    }
}
