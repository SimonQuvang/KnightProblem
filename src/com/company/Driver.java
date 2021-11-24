package com.company;

public class Driver {

    public int minimum_steps(int boardHeight, int boardWdith, int knightStartXPosition, int knightStartYPosition, int knightEndXPosition, int knightEndYPosition){
        // Driver function that follows the interface decribed in the task
        Tree tree = new Tree();
        return tree.minimumSteps(boardHeight, boardWdith, knightStartXPosition, knightStartYPosition, knightEndXPosition, knightEndYPosition);
    }

}
