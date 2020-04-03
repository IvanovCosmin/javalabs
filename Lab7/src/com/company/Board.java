package com.company;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Token> tokenList;
    private int numberOfTokens;

    public Board(List<Token> tokenList, int numberOfTokens) {
        this.tokenList = new ArrayList<>(tokenList);
        this.numberOfTokens = numberOfTokens;
    }
    public Board() {
        this.tokenList = new ArrayList<>();
    }

    public int getNrOfTokens() {
        return this.numberOfTokens;
    }

    public boolean extractAtIndex(int index) {
        if(tokenList.size() > 0) {
            tokenList.remove(index % tokenList.size());
            return true;
        }
        return false;
    }
}
