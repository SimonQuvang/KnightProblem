package com.company;

class Node {
    int x, y, steps;

    public Node(int x, int y, int steps) {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }

    @Override
    public boolean equals(Object o) {
        //Written by IDEA generate code
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public String toString() {
        return this.x + ", " + this.y;
    }

}
