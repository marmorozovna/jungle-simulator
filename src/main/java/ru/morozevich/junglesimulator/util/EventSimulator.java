package ru.morozevich.junglesimulator.util;

import ru.morozevich.junglesimulator.entity.Bonobo;

public class EventSimulator {
    public void startSimulation(Bonobo bonobo) {
        while (bonobo.getEnergy() > 0) {
            int randomNum = (int) (Math.random() * 100);
            if (randomNum < 20) {
                sleepEvent(bonobo);
            } else if (randomNum < 31) {
                meetMumEvent(bonobo);
            } else if (randomNum < 46) {
                meetChimpanzeeEvent(bonobo);
            } else if (randomNum < 63) {
                moveEvent(bonobo);
            } else if (randomNum < 67) {
                meetScientistsEvent(bonobo);
            } else if (randomNum < 76) {
                eatFigsEvent(bonobo);
            } else if (randomNum < 88) {
                eatDatesEvent(bonobo);
            } else if (randomNum < 93) {
                eatTermitsEvent(bonobo);
            } else if (randomNum < 98) {
                catchColobusEvent(bonobo);
            } else {
                fallEvent(bonobo);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }

    private void sleepEvent(Bonobo bonobo) {
        System.out.println("Бонобо спит.");
        int energy = bonobo.getEnergy();
        bonobo.setEnergy(energy + 10);
        int health = bonobo.getHealth();
        bonobo.setHealth(health + 1);
        checkHealth(bonobo);
        checkEnergy(bonobo);
        printStats(bonobo);
    }

    private void meetMumEvent(Bonobo bonobo) {
        System.out.println("Бонобо встречает бонобо-маму.");
        int energy = bonobo.getEnergy();
        bonobo.setEnergy(energy + 7);
        int health = bonobo.getHealth();
        bonobo.setHealth(health + 3);
        checkHealth(bonobo);
        checkEnergy(bonobo);
        printStats(bonobo);
    }

    private void meetChimpanzeeEvent(Bonobo bonobo) {
        System.out.println("Бонобо встречает шимпанзе.");
        int energy = bonobo.getEnergy();
        bonobo.setEnergy(energy - 10);
        int health = bonobo.getHealth();
        bonobo.setHealth(health - 45);
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
        bonobo.setHealth(health - 5);
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
        bonobo.setEnergy(energy - 5);
        int health = bonobo.getHealth();
        bonobo.setHealth(health - 5);
        checkHealth(bonobo);
        checkEnergy(bonobo);
        printStats(bonobo);
    }

    private void fallEvent(Bonobo bonobo) {
        System.out.println("Бонобо падает. Ой, больно!");
        int health = bonobo.getHealth();
        bonobo.setHealth(health - 15);
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
            bonobo.setEnergy(bonobo.getEnergy() - 5);
            System.out.println("Бонобо ранен! Бонобо теряет энергию!");
        }
    }

    private void checkEnergy(Bonobo bonobo) {
        int energy = bonobo.getEnergy();
        if (energy > 100) {
            bonobo.setEnergy(100);
        }
        if (energy <= 0) {
            bonobo.setEnergy(0);
            System.out.println("Бонобо мертв!");
        }
    }
}
