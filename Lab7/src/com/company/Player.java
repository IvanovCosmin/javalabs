package com.company;

import java.util.Random;


public class Player implements Runnable {

    private String name;
    private Board board;
    private Progression progression;

    public Player(Board board, String name) {
        this.board = board;
        this.name = name;
        Random rand = new Random();
        int start = rand.nextInt() % 5;
        if(start < 0) start *= -1;
        int step = rand.nextInt() % 5;
        if(step < 0) step *= -1;
        step += 1;
        progression = new Progression(start, step);
    }

    @Override
    public synchronized void run() {

        while (true) {
            int value = progression.getNext();
            System.out.println(name + " a extras " + value);
            synchronized (board){
                if(!this.board.extractAtIndex(value)) return;
            }
        }
    }
}
