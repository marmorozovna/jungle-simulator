package ru.morozevich.junglesimulator.util;

import ru.morozevich.junglesimulator.entity.Bonobo;

public class EventSimulator {
    public void startSimulation(Bonobo bonobo) {
        while (bonobo.getHealth() > 0) {
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
            checkPrintStats(bonobo);
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
        System.out.println("Бонобо спит.");
    }

    private void meetMumEvent(Bonobo bonobo) {
        bonobo.setEnergy(bonobo.getEnergy() + 7);
        bonobo.setHealth(bonobo.getHealth() + 7);
        System.out.println("Бонобо встречает бонобо-маму.");
    }

    private void meetChimpanzeeEvent(Bonobo bonobo) {
        bonobo.setEnergy(bonobo.getEnergy() - 25);
        bonobo.setHealth(bonobo.getHealth() - 15);
        System.out.println("Бонобо встречает шимпанзе.");
    }

    private void moveEvent(Bonobo bonobo) {
        bonobo.setEnergy(bonobo.getEnergy() - 5);
        System.out.println("Бонобо перемещается с ветки на ветку по лианам.");
    }

    private void meetScientistEvent(Bonobo bonobo) {
        bonobo.setEnergy(bonobo.getEnergy() - 10);
        bonobo.setHealth(bonobo.getHealth() - 5);
        System.out.println("Бонобо встречает ученых.");
    }

    private void eatFigEvent(Bonobo bonobo) {
        bonobo.setEnergy(bonobo.getEnergy() - 3);
        bonobo.setHealth(bonobo.getHealth() + (int) (3 * bonobo.getNUTRITION_FRUIT_COEFF()));
        System.out.println("Бонобо ест инжир.");
    }

    private void eatDateEvent(Bonobo bonobo) {
        bonobo.setEnergy(bonobo.getEnergy() - 2);
        bonobo.setHealth(bonobo.getHealth() + (int) (5 * bonobo.getNUTRITION_FRUIT_COEFF()));
        System.out.println("Бонобо ест финики.");
    }

    private void eatTermitEvent(Bonobo bonobo) {
        bonobo.setEnergy(bonobo.getEnergy() - 5);
        bonobo.setHealth(bonobo.getHealth() + (int) (4 * bonobo.getNUTRITION_MEAT_COEFF()));
        System.out.println("Бонобо ест термитов.");
    }

    private void catchColobusEvent(Bonobo bonobo) {
        bonobo.setEnergy(bonobo.getEnergy() - 10);
        bonobo.setHealth(bonobo.getHealth() - 5);
        System.out.println("Бонобо ловит колобуса.");
    }

    private void fallEvent(Bonobo bonobo) {
        bonobo.setHealth(bonobo.getHealth() - 10);
        bonobo.setEnergy(bonobo.getEnergy() - 10);
        System.out.println("Бонобо падает. Ой, больно!");
    }

    private void checkPrintStats(Bonobo bonobo) {
        checkEnergy(bonobo);
        checkHealth(bonobo);
        printStats(bonobo);
    }

    private void printStats(Bonobo bonobo) {
        System.out.println("Текущее здоровье: " + bonobo.getHealth() + " Текущая энергия: " + bonobo.getEnergy());
    }

    private void checkHealth(Bonobo bonobo) {
        if (bonobo.getHealth() > 100) {
            bonobo.setHealth(100);
        } else if (bonobo.getHealth() <= 0) {
            bonobo.setHealth(0);
            System.out.println("Бонобо мертв!");
        }
    }

    private void checkEnergy(Bonobo bonobo) {
        if (bonobo.getEnergy() > 100) {
            bonobo.setEnergy(100);
        } else if (bonobo.getEnergy() <= 0) {
            bonobo.setEnergy(0);
            bonobo.setHealth(bonobo.getHealth()-5);
            System.out.println("Бонобо изнеможден! Бонобо теряет здоровье!");
        }
    }
}