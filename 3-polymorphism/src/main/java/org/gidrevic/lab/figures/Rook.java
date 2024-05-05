package org.gidrevic.lab.figures;

import java.util.List;
import org.gidrevic.lab.util.Pair;
import org.gidrevic.lab.util.StraightDriver;

public class Rook extends ChessFigure implements StraightDriver {
    public Rook(int x, int y) {
        super(x, y);
    }

    @Override
    public List<Pair<Integer>> getMoves(int xBound, int yBound) {
        return this.getStraightMoves(x, y, xBound, yBound);
    }
}
