import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board{
    
    List<Integer> validMoves;
    Scanner scan = new Scanner(System.in);
    int[][] board;//arxikopoiei se 0?
    int playerTurn;

    
    public Board() {
        board = new int[6][7];
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                board[i][j] = 0;
            }
        }
    }
    
    public int[][] objectToIntArray(){
        int[][] newBoard = new int[6][7];
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 7; ++j) {
                newBoard[i][j] = this.board[i][j];
            } 
        }
        return newBoard;
    }
    
    public void intArrayToObject(int[][] tmp){
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 7; ++j) {
                this.board[i][j] = tmp[i][j];
            } 
        }
    }
    
    public void displayBoard() {
        
        System.out.println("0 1 2 3 4 5 6   <~ Move keys");
        System.out.println("-------------");
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 7; ++j) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();

        }
        System.out.println("-------------");
    }
    
    public void place_by(int move,int player){
        int i = 5;
        while(i>=0){
            if(board[i][move]==0){
                board[i][move] = player;
                break;
            }else {
                i--;
            }
        }
    }
    
    public List<Integer> getValidMoves(){
        validMoves = new ArrayList<>();
        for (int j=0; j<7; j++){
            if(board[0][j]==0){
                validMoves.add(j);
            }
        }
        return validMoves;
    }
   
    public boolean gameOver(){
        return (getValidMoves().isEmpty() || userWin() || computerWin());
    }
    
    public boolean userWin(){
        boolean win = false;
        //checkHorizontalWin
        for(int i=0; i<6; i++){
            for(int j=0; j<4; j++){
                if(board[i][j] == 2 &&
                   board[i][j] == board[i][j+1] &&
                   board[i][j] == board[i][j+2] &&
                   board[i][j] == board[i][j+3]){
                    win = true;
                }
            }
        }
        //checkVerticalWin
        for(int i=0; i<3; i++){
            for(int j=0; j<7; j++){
                if(board[i][j] == 2 &&
                   board[i][j] == board[i+1][j] &&
                   board[i][j] == board[i+2][j] &&
                   board[i][j] == board[i+3][j]){
                    win = true;
                }
            }
        }
        //checkNWDiagonalWin
        for(int i=0; i<3; i++){
            for(int j=0; j<4; j++){
                if(board[i][j] == 2 &&
                   board[i][j] == board[i+1][j+1] &&
                   board[i][j] == board[i+2][j+2] &&
                   board[i][j] == board[i+3][j+3] ){
                    win = true;
                }
            }
        }
        //checkNEDiagonalWin
        for(int i=5; i>2; i--){
            for(int j=0; j<4; j++){
                if(board[i][j] == 2 &&
                   board[i][j] == board[i-1][j+1] &&
                   board[i][j] == board[i-2][j+2] &&
                   board[i][j] == board[i-3][j+3] ){
                    win = true;
                }
            }
        }
        return win;
    }
    
    public boolean computerWin(){
        boolean win = false;
        //checkHorizontalWin
        for(int i=0; i<6; i++){
            for(int j=0; j<4; j++){
                if(board[i][j] == 1 &&
                   board[i][j] == board[i][j+1] &&
                   board[i][j] == board[i][j+2] &&
                   board[i][j] == board[i][j+3]){
                    win = true;
                }
            }
        }
        //checkVerticalWin
        for(int i=0; i<3; i++){
            for(int j=0; j<7; j++){
                if(board[i][j] == 1 &&
                   board[i][j] == board[i+1][j] &&
                   board[i][j] == board[i+2][j] &&
                   board[i][j] == board[i+3][j]){
                    win = true;
                }
            }
        }
        //checkNWDiagonalWin
        for(int i=0; i<3; i++){
            for(int j=0; j<4; j++){
                if(board[i][j] == 1 &&
                   board[i][j] == board[i+1][j+1] &&
                   board[i][j] == board[i+2][j+2] &&
                   board[i][j] == board[i+3][j+3] ){
                    win = true;
                }
            }
        }
        //checkNEDiagonalWin
        for(int i=5; i>2; i--){
            for(int j=0; j<4; j++){
                if(board[i][j] == 1 &&
                   board[i][j] == board[i-1][j+1] &&
                   board[i][j] == board[i-2][j+2] &&
                   board[i][j] == board[i-3][j+3] ){
                    win = true;
                }
            }
        }
        return win;
    }
    
    public void setPlayerTurn(int turn){
        playerTurn = turn;
    }
    
    public void nextTurn(){
        if(playerTurn==1){
            setPlayerTurn(2);
        }else setPlayerTurn(1);
    }
    
    public int getPlayerTurn(){
        return playerTurn;
    }
    
    public boolean userTriple(){
        boolean triple = false;
        //checkHorizontalWin
        for(int i=0; i<6; i++){
            for(int j=0; j<5; j++){
                if(board[i][j] == 2 &&
                   board[i][j] == board[i][j+1] &&
                   board[i][j] == board[i][j+2]){
                    triple = true;
                }
            }
        }
        //checkVerticalWin
        for(int i=0; i<4; i++){
            for(int j=0; j<7; j++){
                if(board[i][j] == 2 &&
                   board[i][j] == board[i+1][j] &&
                   board[i][j] == board[i+2][j]){
                    triple = true;
                }
            }
        }
        //checkNWDiagonalWin
        for(int i=0; i<4; i++){
            for(int j=0; j<5; j++){
                if(board[i][j] == 2 &&
                   board[i][j] == board[i+1][j+1] &&
                   board[i][j] == board[i+2][j+2] ){
                    triple = true;
                }
            }
        }
        //checkNEDiagonalWin
        for(int i=5; i>1; i--){
            for(int j=0; j<5; j++){
                if(board[i][j] == 2 &&
                   board[i][j] == board[i-1][j+1] &&
                   board[i][j] == board[i-2][j+2] ){
                    triple = true;
                }
            }
        }
        return triple;
    }
    
    public boolean computerTriple(){
        boolean triple = false;
        //checkHorizontalWin
        for(int i=0; i<6; i++){
            for(int j=0; j<5; j++){
                if(board[i][j] == 1 &&
                   board[i][j] == board[i][j+1] &&
                   board[i][j] == board[i][j+2]){
                    triple = true;
                }
            }
        }
        //checkVerticalWin
        for(int i=0; i<4; i++){
            for(int j=0; j<7; j++){
                if(board[i][j] == 1 &&
                   board[i][j] == board[i+1][j] &&
                   board[i][j] == board[i+2][j]){
                    triple = true;
                }
            }
        }
        //checkNWDiagonalWin
        for(int i=0; i<4; i++){
            for(int j=0; j<5; j++){
                if(board[i][j] == 1 &&
                   board[i][j] == board[i+1][j+1] &&
                   board[i][j] == board[i+2][j+2] ){
                    triple = true;
                }
            }
        }
        //checkNEDiagonalWin
        for(int i=5; i>1; i--){
            for(int j=0; j<5; j++){
                if(board[i][j] == 1 &&
                   board[i][j] == board[i-1][j+1] &&
                   board[i][j] == board[i-2][j+2] ){
                    triple = true;
                }
            }
        }
        return triple;
    }
    
}
