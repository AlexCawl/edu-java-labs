package org.gidrevic.lab.figures;

import java.util.List;
import org.gidrevic.lab.util.Pair;

public abstract class ChessFigure {
    protected int x;
    protected int y;

    public ChessFigure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract List<Pair<Integer>> getMoves(int xBound, int yBound);

    public List<Pair<Integer>> getAttackMoves(int xBound, int yBound) {
        return getMoves(xBound, yBound);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
