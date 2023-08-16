package ru.morozevich.junglesimulator.entity;

public class Bonobo {
    private int health = 100;
    private int energy = 100;
    private final double nutritionFruitCoeff = 1.8;
    private final double nutritionMeatCoeff = 0.8;

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

    public double getNutritionFruitCoeff() {
        return nutritionFruitCoeff;
    }

    public double getNutritionMeatCoeff() {
        return nutritionMeatCoeff;
    }
}
