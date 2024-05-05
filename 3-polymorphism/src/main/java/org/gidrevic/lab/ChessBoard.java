package org.gidrevic.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.gidrevic.lab.figures.Bishop;
import org.gidrevic.lab.figures.ChessFigure;
import org.gidrevic.lab.figures.King;
import org.gidrevic.lab.figures.Knight;
import org.gidrevic.lab.figures.Pawn;
import org.gidrevic.lab.figures.Queen;
import org.gidrevic.lab.figures.Rook;

public class ChessBoard {
    private final int xSize;
    private final int ySize;
    private final List<ChessFigure> figures = new ArrayList<>();

    public ChessBoard() {
        xSize = 8;
        ySize = 8;
    }

    public ChessBoard(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public void addFigure(ChessType type, int x, int y) {
        if (x >= 0 && x < xSize && y >= 0 && y < ySize) {
            switch (type) {
                case BISHOP:
                    figures.add(new Bishop(x, y));
                    break;
                case KNIGHT:
                    figures.add(new Knight(x, y));
                    break;
                case PAWN:
                    figures.add(new Pawn(x, y));
                    break;
                case KING:
                    boolean isKingAlreadyPlaced = figures.stream().anyMatch(figure -> figure instanceof King);
                    if (!isKingAlreadyPlaced) {
                        figures.add(new King(x, y));
                    } else {
                        throw new IllegalArgumentException("King already exists.");
                    }
                    break;
                case ROOK:
                    figures.add(new Rook(x, y));
                    break;
                case QUEEN:
                    figures.add(new Queen(x, y));
                    break;
            }
        } else {
            throw new IllegalArgumentException("Invalid figure coordinates.");
        }
    }

    public boolean calculateCheck() {
        Optional<ChessFigure> optionalKing = figures.stream().filter(figure -> figure instanceof King).findAny();
        if (optionalKing.isPresent()) {
            ChessFigure king = optionalKing.get();
            return figures.stream()
                    .filter(figure -> !(figure instanceof King))
                    .map(figure -> figure.getAttackMoves(xSize, ySize))
                    .flatMap(List::stream)
                    .anyMatch(move -> move.first == king.getX() && move.second == king.getY());
        } else {
            return false;
        }
    }

    public boolean calculateCheckmate() {
        Optional<ChessFigure> optionalKing = figures.stream().filter(figure -> figure instanceof King).findAny();
        if (optionalKing.isPresent()) {
            ChessFigure king = optionalKing.get();
            return calculateCheck() && figures.stream()
                    .filter(figure -> !(figure instanceof King))
                    .map(figure -> figure.getAttackMoves(xSize, ySize))
                    .flatMap(List::stream)
                    .collect(Collectors.toSet())
                    .containsAll(king.getMoves(xSize, ySize));
        } else {
            return false;
        }
    }
}
