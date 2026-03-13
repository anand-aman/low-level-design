package com.lld.games;

import com.lld.games.model.PlayingPiece;

public class ConsolePrinter implements Display{

    @Override
    public void displayBoard(PlayingPiece[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != null) {
                    System.out.print(grid[i][j].name() + " ");
                } else {
                    System.out.print("  ");
                }
                if (j != grid[0].length - 1)
                    System.out.print(" | ");
            }
            if (i != grid.length-1){
                System.out.println();
                for(int k=0; k<grid.length; k++){
                    System.out.print("---  ");
                }
                System.out.println();
            } else {
                System.out.println();
            }
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

}
