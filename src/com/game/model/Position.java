package com.game.model;

public class Position {
    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Position(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
