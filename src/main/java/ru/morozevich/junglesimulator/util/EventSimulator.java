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
        moveEvent(bonobo);
        meetScientistsEvent(bonobo);
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

    private void printStats(Bonobo bonobo) {
        System.out.println("Текущее здоровье: " + bonobo.getHealth() + " Текущая энергия: " + bonobo.getEnergy());
    }

    private void checkHealth(Bonobo bonobo) {
        int health = bonobo.getHealth();
        if (health > 100) {
            bonobo.setHealth(100);
        }
    }

    private void checkEnergy(Bonobo bonobo) {
        int energy = bonobo.getEnergy();
        if (energy > 100) {
            bonobo.setEnergy(100);
        }
    }
}
