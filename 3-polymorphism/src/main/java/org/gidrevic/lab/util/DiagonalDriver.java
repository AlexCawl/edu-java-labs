package org.gidrevic.lab.util;

import java.util.ArrayList;
import java.util.List;

public interface DiagonalDriver {
    default List<Pair<Integer>> getDiagonalMoves(int x, int y, int xBound, int yBound) {
        List<Pair<Integer>> moves = new ArrayList<>();
        for (int i = 1; i < Math.max(xBound, yBound); i++) {
            if (x + i < xBound && y + i < yBound) {
                moves.add(new Pair<>(x + i, y + i)); // Вправо вниз
            }
            if (x - i >= 0 && y + i < yBound) {
                moves.add(new Pair<>(x - i, y + i)); // Вправо вверх
            }
            if (x + i < xBound && y - i >= 0) {
                moves.add(new Pair<>(x + i, y - i)); // Влево вниз
            }
            if (x - i >= 0 && y - i >= 0) {
                moves.add(new Pair<>(x - i, y - i)); // Влево вверх
            }
        }
        return moves;
    }
}
