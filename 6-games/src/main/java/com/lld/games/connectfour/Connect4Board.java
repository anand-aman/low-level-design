package com.lld.games.connectfour;

import com.lld.games.Board;
import com.lld.games.ConsolePrinter;
import com.lld.games.Display;
import com.lld.games.model.GameState;
import com.lld.games.model.Move;
import com.lld.games.model.Player;
import com.lld.games.model.PlayingPiece;

public class Connect4Board implements Board {
    private final PlayingPiece[][] grid;
    private final Display display;

    public  Connect4Board(int rowSize, int colSize) {
        grid = new PlayingPiece[rowSize][colSize];
        display = new ConsolePrinter();
    }

    @Override
    public void display(){
        display.displayBoard(grid);
    }

    @Override
    public GameState makeMove(Move move) {
        if(!isValidMove(move)){
            return GameState.RETRY;
        }
        placeMove(move);
        if(isWinner(move)){
            return GameState.WON;
        }
        if(isBoardFull()){
            return GameState.DRAW;
        }
        return GameState.IN_PROGRESS;
    }

    private boolean isValidMove(Move move) {
        if(move.getCol()>=grid[0].length) {
            display.displayMessage("Invalid move. Please select valid column.");
            return false;
        }
        if(!canPlace(move)){
            display.displayMessage("Column is full. Please select any other column.");
            return false;
        }
        return true;
    }

    private boolean canPlace(Move move){
        int col = move.getCol();
        return grid[0][col]==null;
    }

    private void placeMove(Move move){
        for(int i= grid.length-1; i>=0; i--){
            if(grid[i][move.getCol()] == null) {
                grid[i][move.getCol()] = move.getPlayer().getPlayingPiece();
                move.setRow(i);
                return;
            }
        }
    }

    @Override
    public boolean isWinner(Move move) {
        int[][] directions = new int[][] {
                {0, 1},
                {1, 0},
                {1, 1},
                {-1, 1}
        };

        for(int[] dir : directions){
            int count=1;
            //count in direction
            count += countInDirection(move, dir[0], dir[1]);
            //count in anti direction
            count += countInDirection(move, -dir[0], -dir[1]);
            if(count>=4){
                return true;
            }
        }
        return false;
    }

    private int countInDirection(Move move, int rowDirection, int columnDirection) {
        PlayingPiece playingPiece = move.getPlayer().getPlayingPiece();
        int count = 0;
        for(
            int r=move.getRow()+rowDirection, c=move.getCol()+columnDirection;
            r>=0 && c>=0 && r<grid.length && c<grid[0].length;
            r+=rowDirection, c+=columnDirection
        ) {
            if(grid[r][c]==playingPiece){
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private boolean isBoardFull() {
        for(int i=0; i<grid[0].length; i++){
            if(grid[0][i]==null){
                return false;
            }
        }
        return true;
    }
}
