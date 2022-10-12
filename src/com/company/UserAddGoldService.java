package com.company;

import java.util.concurrent.Semaphore;

public class UserAddGoldService implements Runnable{
    private Clan clan;
    private Semaphore semaphore;
    private int addGold;

    UserAddGoldService(Semaphore semaphore, int addGold, Clan clan) {
        this.semaphore = semaphore;
        this.addGold = addGold;
        this.clan = clan;
    }

    private void addGoldToClan(int gold) {
        try {
            semaphore.acquire();
            clan.addGold(gold);
        } catch (InterruptedException e) {
            System.out.println("Проблемы с добавлением золота");
        }
        semaphore.release();
    }

    @Override
    public void run() {
        addGoldToClan(addGold);
    }
}
