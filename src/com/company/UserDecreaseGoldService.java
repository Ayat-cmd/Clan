package com.company;

import java.util.concurrent.Semaphore;

public class UserDecreaseGoldService implements Runnable{
    private Clan clan;
    private Semaphore semaphore;
    private int decreaseGold;

    UserDecreaseGoldService(Semaphore semaphore, int decreaseGold, Clan clan) {
        this.semaphore = semaphore;
        this.decreaseGold = decreaseGold;
        this.clan = clan;
    }

    private void decreaseGoldToClan(int gold) {
        try {
            semaphore.acquire();
            clan.decreaseGold(gold);
        } catch (InterruptedException e) {
            System.out.println("Проблемы с добавлением золота");
        }
        semaphore.release();
    }

    @Override
    public void run() {
        decreaseGoldToClan(decreaseGold);
    }
}
