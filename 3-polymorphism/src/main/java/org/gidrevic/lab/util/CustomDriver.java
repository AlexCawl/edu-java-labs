package org.gidrevic.lab.util;

import java.util.List;
import java.util.stream.Collectors;

public interface CustomDriver {
    default List<Pair<Integer>> getCustomMoves(int x, int y, int xBound, int yBound, List<Pair<Integer>> baseMoves) {
        return baseMoves.stream()
                .map(move -> new Pair<>(move.first + x, move.second + y))
                .filter(move -> move.first >= 0 && move.first < xBound && move.second >= 0 && move.second < yBound)
                .collect(Collectors.toList());
    }
}
