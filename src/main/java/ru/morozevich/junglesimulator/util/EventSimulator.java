package ru.morozevich.junglesimulator.util;

import ru.morozevich.junglesimulator.entity.Bonobo;

public class EventSimulator {
    // бонобо спит +20 энергии, +5 здоровья - 20 %
// бонобо встречает бонобо-маму + 10 энергии; + 10 здоровья - 11 %
// бонобо встречает шимпанзе - 10 энергии, - 20 здоровья - 15 %
// бонобо передвигается -5 энергии - 17 %
// бонобо встречает ученых - 10 энергии, + 10 здоровья - 4 %
// бонобо ест инжир - 3 энергии + 3 здоровья - 9 %
// бонобо ест фиги - 2 энергии + 5 здоровья - 12 %
// бонобо есть термитов - 5 энергии + 4 здоровья - 5 %
// бонобо ловит колобуса - 10 энергии - 5 %;
// бонобо падает с ветки - 5 энергии - 5 здоровья - 2 %
    public void startSimulation(Bonobo bonobo) {
        while (bonobo.getEnergy() > 0) {
            int randomNum = (int) (Math.random() * 100);
            if (randomNum < 50) {
                meetChimpanzeeEvent(bonobo);
            } else fallEvent(bonobo);
        }
    }

    private void sleepEvent(Bonobo bonobo) {
        System.out.println("Бонобо спит.");
        int energy = bonobo.getEnergy();
        bonobo.setEnergy(energy + 20);
        int health = bonobo.getHealth();
        bonobo.setHealth(health + 5);
        checkHealth(bonobo);
        checkEnergy(bonobo);
        printStats(bonobo);
    }

    private void meetMumEvent(Bonobo bonobo) {
        System.out.println("Бонобо встречает бонобо-маму.");
        int energy = bonobo.getEnergy();
        bonobo.setEnergy(energy + 10);
        int health = bonobo.getHealth();
        bonobo.setHealth(health + 10);
        checkHealth(bonobo);
        checkEnergy(bonobo);
        printStats(bonobo);
    }

    private void meetChimpanzeeEvent(Bonobo bonobo) {
        System.out.println("Бонобо встречает шимпанзе.");
        int energy = bonobo.getEnergy();
        bonobo.setEnergy(energy - 10);
        int health = bonobo.getHealth();
        bonobo.setHealth(health - 20);
        checkHealth(bonobo);
        checkEnergy(bonobo);
        printStats(bonobo);
    }

    private void moveEvent(Bonobo bonobo) {
        System.out.println("Бонобо перемещается с ветки на ветку по лианам.");
        int energy = bonobo.getEnergy();
        bonobo.setEnergy(energy - 5);
        checkHealth(bonobo);
        checkEnergy(bonobo);
        printStats(bonobo);
    }

    private void meetScientistsEvent(Bonobo bonobo) {
        System.out.println("Бонобо встречает ученых.");
        int energy = bonobo.getEnergy();
        bonobo.setEnergy(energy - 10);
        int health = bonobo.getHealth();
        bonobo.setHealth(health + 10);
        checkHealth(bonobo);
        checkEnergy(bonobo);
        printStats(bonobo);
    }

    private void eatFigsEvent(Bonobo bonobo) {
        System.out.println("Бонобо ест инжир.");
        int energy = bonobo.getEnergy();
        bonobo.setEnergy(energy - 3);
        int health = bonobo.getHealth();
        bonobo.setHealth(health + (int) (3 * bonobo.getNutritionFruitCoeff()));
        checkHealth(bonobo);
        checkEnergy(bonobo);
        printStats(bonobo);
    }

    private void eatDatesEvent(Bonobo bonobo) {
        System.out.println("Бонобо ест финики.");
        int energy = bonobo.getEnergy();
        bonobo.setEnergy(energy - 2);
        int health = bonobo.getHealth();
        bonobo.setHealth(health + (int) (5 * bonobo.getNutritionFruitCoeff()));
        checkHealth(bonobo);
        checkEnergy(bonobo);
        printStats(bonobo);
    }

    private void eatTermitsEvent(Bonobo bonobo) {
        System.out.println("Бонобо ест термитов.");
        int energy = bonobo.getEnergy();
        bonobo.setEnergy(energy - 5);
        int health = bonobo.getHealth();
        bonobo.setHealth(health + (int) (4 * bonobo.getNutritionMeatCoeff()));
        checkHealth(bonobo);
        checkEnergy(bonobo);
        printStats(bonobo);
    }

    private void catchColobusEvent(Bonobo bonobo) {
        System.out.println("Бонобо ловит колобуса.");
        int energy = bonobo.getEnergy();
        bonobo.setEnergy(energy - 10);
        checkHealth(bonobo);
        checkEnergy(bonobo);
        printStats(bonobo);
    }

    private void fallEvent(Bonobo bonobo) {
        System.out.println("Бонобо падает. Ой, больно!");
        int energy = bonobo.getEnergy();
        bonobo.setEnergy(energy - 5);
        checkHealth(bonobo);
        checkEnergy(bonobo);
        printStats(bonobo);
    }

    private void printStats(Bonobo bonobo) {
        System.out.println("Текущее здоровье: " + bonobo.getHealth() + " Текущая энергия: " + bonobo.getEnergy());
    }

    private void checkHealth(Bonobo bonobo) {
        int health = bonobo.getHealth();
        if (health > 100) {
            bonobo.setHealth(100);
        }
        if (health <= 0) {
            bonobo.setHealth(0);
            bonobo.setEnergy(bonobo.getEnergy()-5);
            System.out.println("Бонобо ранен! Бонобо теряет энергию!");
        }
    }

    private void checkEnergy(Bonobo bonobo) {
        int energy = bonobo.getEnergy();
        if (energy > 100) {
            bonobo.setEnergy(100);
        }
        if (energy <= 0) {
            System.out.println("Бонобо мертв!");
        }
    }
}
