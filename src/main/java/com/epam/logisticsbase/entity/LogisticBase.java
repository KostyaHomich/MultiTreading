package com.epam.logisticsbase.entity;


import java.util.ArrayList;
import java.util.List;

public class LogisticBase {


    private static LogisticBase instance = new LogisticBase();
    private List<Terminal> terminalList = new ArrayList<>();


    private LogisticBase() {
    }

    public static LogisticBase getInstance() {
        return instance;
    }

    public void addTerminal(Terminal terminal) {
        terminalList.add(terminal);
    }

    public void removeTerminal(Terminal terminal) {
        terminalList.remove(terminal);
    }

}
