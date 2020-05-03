package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            GameClient gc = new GameClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
