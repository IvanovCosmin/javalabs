package com.company;

public class Progression {
    private int curr;
    private int step;
    Progression(int first, int step) {
        this.curr = first;
        this.step = step;
    }
    int getNext() {
        curr += step;
        return curr;
    }
}
