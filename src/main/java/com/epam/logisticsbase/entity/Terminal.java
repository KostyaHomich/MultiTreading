package com.epam.logisticsbase.entity;

import java.util.Objects;

public class Terminal {

    private int id;
    public Terminal(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Terminal terminal = (Terminal) o;
        return Integer.compare(terminal.id, id) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Id: " + id;
    }
}
