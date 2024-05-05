package org.gidrevic.lab.figures;

import java.util.List;
import org.gidrevic.lab.util.DiagonalDriver;
import org.gidrevic.lab.util.Pair;

public class Bishop extends ChessFigure implements DiagonalDriver {
    public Bishop(int x, int y) {
        super(x, y);
    }

    @Override
    public List<Pair<Integer>> getMoves(int xBound, int yBound) {
        return this.getDiagonalMoves(x, y, xBound, yBound);
    }
}
