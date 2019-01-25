package com.epam.logisticsbase.entity;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Objects;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car implements Runnable {

    private static Logger logger = LogManager.getLogger(Car.class);

    private String name;
    private String action;
    private int priority;
    private int terminal;
    private Semaphore semaphore;
    private Terminal terminalObj;


    public Car() {
    }

    public Car(String name, String action, int priority, int terminal) {
        this.name = name;
        this.action = action;
        this.priority = priority;
        this.terminal = terminal;
    }


    @Override
    public void run() {

        try {
            logger.info(name + " waiting for enter to logistic base");
            semaphore.acquire();
            TimeUnit.SECONDS.sleep(1);
            logger.info(name + " changed condition in terminal " + terminalObj.getId() + " priority " + priority);
            changeAction(this);

        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            logger.info(name + " finish the job");
            semaphore.release();
        }
    }

    private void changeAction(Car car) {
        switch (car.getAction()) {
            case "unloading":
                car.setAction("unload");
                break;
            case "loading":
                car.setAction("load");
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Integer.compare(car.priority, priority) == 0 &&
                Integer.compare(car.terminal, terminal) == 0 &&
                Objects.equals(name, car.name) &&
                Objects.equals(action, car.action);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, action, priority, terminal);
    }

    @Override
    public String toString() {
        return "Name: " + name + " Action: " + action + " Priority: " + priority + " Terminal: " + terminal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getTerminal() {
        return terminal;
    }

    public void setTerminal(int terminal) {
        this.terminal = terminal;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public Terminal getTerminalObj() {
        return terminalObj;
    }

    public void setTerminalObj(Terminal terminalObj) {
        this.terminalObj = terminalObj;
    }
}
