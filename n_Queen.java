

import java.util.*;

public class n_Queen {
    public static void main(String[] args) {
        int n=4;
        char[][] board=new char[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                board[i][j]='X';
            }
        }
        nqueen(board, 0);

    }

    private static void nqueen(char[][] board, int row) {
        int n= board.length;
        if (row==n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

            //kaam
            for (int j=0; j<n;j++){
               if(isSafe(board,row, j)){
                   board[row][j]='Q';
                   nqueen(board,row+1);
                   board[row][j]='X';
               }
            }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        int n=board.length;
        //row
        for (int i=0; i<n; i++){
          if (board[row][i]=='Q') return false;
        }
        //col
        for(int j=0; j<n; j++){
            if (board[j][col]=='Q') return false;
        }

        int i=row;
        int j=col;
        //north east
        while(i>=0 && j<n){
            if (board[i][j]=='Q') return false;
            i--;
            j++;
        }

        //north west
        i=row;
        j=col;
        while (i>=0 && j>=0) {
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        //for east south
        i=row;
        j=col;
        while (i<n && j<n){
            if (board[i][j]=='Q') return false;
            i++;
            j++;
        }
        //for south west
        i=row;
        j=col;
        while (i< n && j>n){
            if (board[i][j]=='Q') return  false;
            i++;
            j--;
        }
        return true;
    }
}
