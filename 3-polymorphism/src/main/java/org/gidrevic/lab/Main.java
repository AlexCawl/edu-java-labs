package org.gidrevic.lab;

public class Main {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard(3, 3);
        board.addFigure(ChessType.KING, 0, 0);
        board.addFigure(ChessType.QUEEN, 2, 2);
        board.addFigure(ChessType.QUEEN, 0, 2);
        board.addFigure(ChessType.QUEEN, 2, 0);
        System.out.println(board.calculateCheck());
        System.out.println(board.calculateCheckmate());
    }
}