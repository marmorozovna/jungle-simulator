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
        bonobo.setEnergy(bonobo.getEnergy() + 10);
        bonobo.setHealth(bonobo.getHealth() + 1);
        checkAndPrintStats(bonobo);
    }

    private void meetMumEvent(Bonobo bonobo) {
        System.out.println("Бонобо встречает бонобо-маму.");
        bonobo.setEnergy(bonobo.getEnergy() + 7);
        bonobo.setHealth(bonobo.getHealth() + 3);
        checkAndPrintStats(bonobo);
    }

    private void meetChimpanzeeEvent(Bonobo bonobo) {
        System.out.println("Бонобо встречает шимпанзе.");
        bonobo.setEnergy(bonobo.getEnergy() - 10);
        bonobo.setHealth(bonobo.getHealth() - 45);
        checkAndPrintStats(bonobo);
    }

    private void moveEvent(Bonobo bonobo) {
        System.out.println("Бонобо перемещается с ветки на ветку по лианам.");
        bonobo.setEnergy(bonobo.getEnergy() - 5);
        checkAndPrintStats(bonobo);
    }

    private void meetScientistsEvent(Bonobo bonobo) {
        System.out.println("Бонобо встречает ученых.");
        bonobo.setEnergy(bonobo.getEnergy() - 10);
        bonobo.setHealth(bonobo.getHealth() - 5);
        checkAndPrintStats(bonobo);
    }

    private void eatFigsEvent(Bonobo bonobo) {
        System.out.println("Бонобо ест инжир.");
        bonobo.setEnergy(bonobo.getEnergy() - 3);
        bonobo.setHealth(bonobo.getHealth() + (int) (3 * bonobo.getNUTRITION_FRUIT_COEFF()));
        checkAndPrintStats(bonobo);
    }

    private void eatDatesEvent(Bonobo bonobo) {
        System.out.println("Бонобо ест финики.");
        bonobo.setEnergy(bonobo.getEnergy() - 2);
        bonobo.setHealth(bonobo.getHealth() + (int) (5 * bonobo.getNUTRITION_FRUIT_COEFF()));
        checkAndPrintStats(bonobo);
    }

    private void eatTermitsEvent(Bonobo bonobo) {
        System.out.println("Бонобо ест термитов.");
        bonobo.setEnergy(bonobo.getEnergy() - 5);
        bonobo.setHealth(bonobo.getHealth() + (int) (4 * bonobo.getNUTRITION_MEAT_COEFF()));
        checkAndPrintStats(bonobo);
    }

    private void catchColobusEvent(Bonobo bonobo) {
        System.out.println("Бонобо ловит колобуса.");
        bonobo.setEnergy(bonobo.getEnergy() - 5);
        bonobo.setHealth(bonobo.getHealth() - 5);
        checkAndPrintStats(bonobo);
    }

    private void fallEvent(Bonobo bonobo) {
        System.out.println("Бонобо падает. Ой, больно!");
        bonobo.setHealth(bonobo.getHealth() - 15);
        checkAndPrintStats(bonobo);
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