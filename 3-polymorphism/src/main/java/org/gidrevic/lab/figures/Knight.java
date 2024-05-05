package org.gidrevic.lab.figures;

import java.util.List;
import org.gidrevic.lab.util.CustomDriver;
import org.gidrevic.lab.util.Pair;

public class Knight extends ChessFigure implements CustomDriver {
    public Knight(int x, int y) {
        super(x, y);
    }

    @Override
    public List<Pair<Integer>> getMoves(int xBound, int yBound) {
        List<Pair<Integer>> moves = List.of(
                new Pair<>(-2, -1),
                new Pair<>(-2, 1),
                new Pair<>(2, -1),
                new Pair<>(2, 1),
                new Pair<>(-1, -2),
                new Pair<>(-1, 2),
                new Pair<>(1, -2),
                new Pair<>(1, 2)
        );
        return this.getCustomMoves(x, y, xBound, yBound, moves);
    }
}
