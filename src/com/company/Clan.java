package com.company;

public class Clan{
    private String name; // имя клана
    private int gold;    // текущее количество золота в казне клана

    Clan(String name, int gold) {
        this.name = name;
        this.gold = gold;
    }

    synchronized void addGold(int gold) {
        System.out.println("В казне " + this.gold + " золота");
        System.out.println("Увеличение золота в " + name + " на " + gold);
        this.gold += gold;
        System.out.println("После добавления в казне " + this.gold + " золота");
    }

    synchronized void decreaseGold(int gold) {
        System.out.println("В казне " + this.gold + " золота");
        System.out.println("Уменьшение золота в " + name + " на " + gold);
        if (this.gold >= gold) {
            this.gold -= gold;
        } else {
            System.out.println("Недостаточно золота");
        }
        System.out.println("После уменьшения в казне " + this.gold + " золота");
    }
}
