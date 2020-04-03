package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private int numOftokens;

    public Game(int number) {
        numOftokens = number;
        List<Token> tokenList = new ArrayList<>();

        for(int i = 0; i< numOftokens;i++){
            tokenList.add(new Token(i));
        }

        board = new Board(tokenList, numOftokens);
        player1 = new Player(board, "Cosmin1");
        player2 = new Player(board, "Cosmin2");
    }

    void Start() {
        Runnable thread1 = new Thread(player1, "Player1 Thread");
        Runnable thread2 = new Thread(player2, "Player2 Thread");

        new Thread(thread1).start();
        new Thread(thread2).start();


    }
}
