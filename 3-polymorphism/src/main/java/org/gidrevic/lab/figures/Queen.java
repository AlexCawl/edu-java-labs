package org.gidrevic.lab.figures;

import java.util.ArrayList;
import java.util.List;
import org.gidrevic.lab.util.DiagonalDriver;
import org.gidrevic.lab.util.Pair;
import org.gidrevic.lab.util.StraightDriver;

public class Queen extends ChessFigure implements StraightDriver, DiagonalDriver {
    public Queen(int x, int y) {
        super(x, y);
    }

    @Override
    public List<Pair<Integer>> getMoves(int xBound, int yBound) {
        List<Pair<Integer>> moves = new ArrayList<>();
        moves.addAll(this.getStraightMoves(x, y, xBound, yBound));
        moves.addAll(this.getDiagonalMoves(x, y, xBound, yBound));
        return moves;
    }
}
