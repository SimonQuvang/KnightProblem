package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Tree {

    ArrayList<Node> validMoves;

    public Tree() {
        this.validMoves = new ArrayList<>();
    }

    boolean isWithinChessboard(Node node, int N) {
        return node.x >= 0 && node.x < N && node.y >= 0 && node.y < N;
    }

    public int minimumSteps(int boardHeight, int boardWdith, int knightStartXPosition, int knightStartYPosition, int knightEndXPosition, int knightEndYPosition) {

        // defining the legalmoves for a knight for later use
        int[] legalMovesX = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] legalMovesY = {-1, 1, -2, 2, -2, 2, -1, 1};
        int legalMovesAmount = 8;

        //By removing the negative coordinates we can remove 3/4 parts of the chessboard and thus making the algorithm much faster
        knightEndXPosition = Math.abs(knightEndXPosition);
        knightEndYPosition = Math.abs(knightEndYPosition);

        Node endPosition = new Node(knightEndXPosition, knightEndYPosition, 0);
        Node currentPosition = new Node(knightStartXPosition, knightStartYPosition, 0);
        this.validMoves.add(currentPosition);


        if (!isWithinChessboard(currentPosition, boardHeight) || !isWithinChessboard(endPosition, boardHeight)) {
            //Checking if the current and end position/node is within the chessboard, if not return -1
            return -1;
        }

        //Setting up a hashset to add in the visited positions on the chessboard(In reality it will only visit 1/4 of the board at max)
        //The set stores a coordinatset in a string, that is plenty fine
        Set<String> searchedPositions = new HashSet<>();
        searchedPositions.add(currentPosition.toString());

        int nodeNumber = 0;

        while (!this.validMoves.isEmpty()) {
            //Loop as long as there is nodes in the arraylist

            if (currentPosition.equals(endPosition)) {
                // end position found, return the steps it took to get to it.
                return currentPosition.steps;
            }

            for (int i = 0; i < legalMovesAmount; i++) {
                //By looping through all the 8 legal moves, all the position it can reach from current position can be added to the list
                //Making a new tempoary node object with the new posible position
                Node nextPosition = new Node(Math.abs(currentPosition.x + legalMovesX[i]), Math.abs(currentPosition.y + legalMovesY[i]), currentPosition.steps + 1);

                if (isWithinChessboard(nextPosition, boardHeight) && !searchedPositions.contains(nextPosition.toString()) && nextPosition.x >= -2 && nextPosition.y >= -2) {
                    //Checking if the new possible position is within the board.
                    //Also checking we havent already been at that position
                    //Also checking if x and y is bigger or equal to -2. If not there is no reason to add it to the list of to visit nodes
                    //this is because we have cut the board down by 3/4 by only looking at the positives positions.
                    //By allowing coordinates down to -2 we are taking care of corner cases where it is faster to go intro the negative and then back to the positive
                    //This can be done because all 4 parts of a coordinate system/chessboard is the same so the amount of steps to a random positive position
                    // will be the same to the same position but negative.
                    // A bit hard to explain over text, but it makes sense when drawing a coordinate system on top of a chessboard.
                    searchedPositions.add(nextPosition.toString());
                    this.validMoves.add(nextPosition);
                    // adding the new postion to the list to visit later

                }

            }

            currentPosition = this.validMoves.get(nodeNumber++);
        }
        return -1;
    }
}
