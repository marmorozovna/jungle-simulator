package ru.morozevich.junglesimulator.entity;

public class Bonobo {
    private int health = 100;
    private int energy = 100;
    private final double NUTRITION_FRUIT_COEFF = 1.8;
    private final double NUTRITION_MEAT_COEFF = 0.8;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public double getNUTRITION_FRUIT_COEFF() {
        return NUTRITION_FRUIT_COEFF;
    }

    public double getNUTRITION_MEAT_COEFF() {
        return NUTRITION_MEAT_COEFF;
    }
}
