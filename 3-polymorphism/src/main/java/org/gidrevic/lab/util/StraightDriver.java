package org.gidrevic.lab.util;

import java.util.ArrayList;
import java.util.List;

public interface StraightDriver {
    default List<Pair<Integer>> getStraightMoves(int x, int y, int xBound, int yBound) {
        List<Pair<Integer>> moves = new ArrayList<>();
        for (int i = 0; i < xBound; i++) {
            if (i != x) {
                moves.add(new Pair<>(x, i)); // Горизонтальные ходы
            }
        }
        for (int i = 0; i < yBound; i++) {
            if (i != y) {
                moves.add(new Pair<>(i, y)); // Вертикальные ходы
            }
        }
        return moves;
    }
}
