public class main {
    
    public static void main(String[] args){

        Board b = new Board();

        
        
        
        b.displayBoard();
        
        System.out.println("Who's gonna move first? (1)Computer (2)User: ");
        int choice = b.scan.nextInt();
        b.setPlayerTurn(choice);
        
        while(!b.gameOver()){
            if(b.getPlayerTurn()==2){
                System.out.println("Your move: ");
                int move = b.scan.nextInt();
                if(!b.getValidMoves().contains(move)){
                    System.out.println("Invalid move!");
                    continue;
                }
                else{
                    b.place_by(move, b.getPlayerTurn());
                    b.displayBoard();
                    if(b.gameOver()){
                        break;
                    }
                    b.nextTurn();
                }
            }
            else if(b.getPlayerTurn()==1){
                minimax alg = new minimax();               
                b.place_by(alg.minimaxMove(b, 2, true), b.getPlayerTurn());
                b.displayBoard();
                b.nextTurn();
            }
            
        }
        
        if(b.userWin()){
            System.out.println("You won!");
        }
        else if(b.computerWin()){
            System.out.println("You Lost");
        }
        else if(b.getValidMoves().isEmpty()){
            System.out.println("It is a a tie!");
        }
        
    }

}
