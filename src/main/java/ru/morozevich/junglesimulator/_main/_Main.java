package ru.morozevich.junglesimulator._main;

import ru.morozevich.junglesimulator.entity.Bonobo;
import ru.morozevich.junglesimulator.util.EventSimulator;

public class _Main {
    public static void main(String[] args) {
        Bonobo bonobo = new Bonobo();
        EventSimulator eventSimulator = new EventSimulator();
        eventSimulator.startSimulation(bonobo);
    }
}