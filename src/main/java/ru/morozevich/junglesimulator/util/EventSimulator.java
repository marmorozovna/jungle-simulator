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
                meetScientistEvent(bonobo);
            } else if (randomNum < 76) {
                eatFigEvent(bonobo);
            } else if (randomNum < 88) {
                eatDateEvent(bonobo);
            } else if (randomNum < 93) {
                eatTermitEvent(bonobo);
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
        bonobo.setEnergy(bonobo.getEnergy() + 10);
        bonobo.setHealth(bonobo.getHealth() + 1);
        checkAndPrintStats(bonobo);
        System.out.println("Бонобо спит.");
    }

    private void meetMumEvent(Bonobo bonobo) {
        bonobo.setEnergy(bonobo.getEnergy() + 7);
        bonobo.setHealth(bonobo.getHealth() + 3);
        checkAndPrintStats(bonobo);
        System.out.println("Бонобо встречает бонобо-маму.");
    }

    private void meetChimpanzeeEvent(Bonobo bonobo) {
        bonobo.setEnergy(bonobo.getEnergy() - 10);
        bonobo.setHealth(bonobo.getHealth() - 45);
        checkAndPrintStats(bonobo);
        System.out.println("Бонобо встречает шимпанзе.");
    }

    private void moveEvent(Bonobo bonobo) {
        bonobo.setEnergy(bonobo.getEnergy() - 5);
        checkAndPrintStats(bonobo);
        System.out.println("Бонобо перемещается с ветки на ветку по лианам.");
    }

    private void meetScientistEvent(Bonobo bonobo) {
        bonobo.setEnergy(bonobo.getEnergy() - 10);
        bonobo.setHealth(bonobo.getHealth() - 5);
        checkAndPrintStats(bonobo);
        System.out.println("Бонобо встречает ученых.");
    }

    private void eatFigEvent(Bonobo bonobo) {
        bonobo.setEnergy(bonobo.getEnergy() - 3);
        bonobo.setHealth(bonobo.getHealth() + (int) (3 * bonobo.getNUTRITION_FRUIT_COEFF()));
        checkAndPrintStats(bonobo);
        System.out.println("Бонобо ест инжир.");
    }

    private void eatDateEvent(Bonobo bonobo) {
        bonobo.setEnergy(bonobo.getEnergy() - 2);
        bonobo.setHealth(bonobo.getHealth() + (int) (5 * bonobo.getNUTRITION_FRUIT_COEFF()));
        checkAndPrintStats(bonobo);
        System.out.println("Бонобо ест финики.");
    }

    private void eatTermitEvent(Bonobo bonobo) {
        bonobo.setEnergy(bonobo.getEnergy() - 5);
        bonobo.setHealth(bonobo.getHealth() + (int) (4 * bonobo.getNUTRITION_MEAT_COEFF()));
        checkAndPrintStats(bonobo);
        System.out.println("Бонобо ест термитов.");
    }

    private void catchColobusEvent(Bonobo bonobo) {
        bonobo.setEnergy(bonobo.getEnergy() - 5);
        bonobo.setHealth(bonobo.getHealth() - 5);
        checkAndPrintStats(bonobo);
        System.out.println("Бонобо ловит колобуса.");
    }

    private void fallEvent(Bonobo bonobo) {
        bonobo.setHealth(bonobo.getHealth() - 15);
        checkAndPrintStats(bonobo);
        System.out.println("Бонобо падает. Ой, больно!");
    }

    private void checkAndPrintStats(Bonobo bonobo) {
        checkHealth(bonobo);
        checkEnergy(bonobo);
        printStats(bonobo);
    }

    private void printStats(Bonobo bonobo) {
        System.out.println("Текущее здоровье: " + bonobo.getHealth() + " Текущая энергия: " + bonobo.getEnergy());
    }

    private void checkHealth(Bonobo bonobo) {
        if (bonobo.getHealth() > 100) {
            bonobo.setHealth(100);
        }
        if (bonobo.getHealth() <= 0) {
            bonobo.setHealth(0);
            bonobo.setEnergy(bonobo.getEnergy() - 5);
            System.out.println("Бонобо ранен! Бонобо теряет энергию!");
        }
    }

    private void checkEnergy(Bonobo bonobo) {
        if (bonobo.getEnergy() > 100) {
            bonobo.setEnergy(100);
        }
        if (bonobo.getEnergy() <= 0) {
            bonobo.setEnergy(0);
            System.out.println("Бонобо мертв!");
        }
    }
}