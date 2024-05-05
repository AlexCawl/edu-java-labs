package org.gidrevic.lab.figures;

import java.util.List;
import org.gidrevic.lab.util.CustomDriver;
import org.gidrevic.lab.util.Pair;

public class Pawn extends ChessFigure implements CustomDriver {
    public Pawn(int x, int y) {
        super(x, y);
    }

    @Override
    public List<Pair<Integer>> getMoves(int xBound, int yBound) {
        List<Pair<Integer>> moves = List.of(new Pair<>(1, 0));
        return this.getCustomMoves(x, y, xBound, yBound, moves);
    }

    @Override
    public List<Pair<Integer>> getAttackMoves(int xBound, int yBound) {
        List<Pair<Integer>> moves = List.of(
                new Pair<>(1, 1),
                new Pair<>(1, -1)
        );
        return this.getCustomMoves(x, y, xBound, yBound, moves);
    }
}
