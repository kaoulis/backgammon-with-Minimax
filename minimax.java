public class minimax {

    
    public minimax() {
        
    }
    
    public int nodeEvaluation(Board finalNode){
        int max = 10;
        int min = -10;
        if(finalNode.computerWin()){
            return max;
        }else if(finalNode.userWin()){
            return min;
        }else if(finalNode.computerTriple()){
            return 5;
        }else if(finalNode.userTriple()){
            return -5;
        }else return 0;
    }
    
    public int minimaxMove(Board node, int depth, boolean maximized){
        int bestPath = 3;
        
        if(depth==0 || node.getValidMoves().isEmpty() || node.gameOver()){
            return nodeEvaluation(node);
        }
        
        if(maximized){
            int bestValue = -1000;
            for(int i=0; i<node.getValidMoves().size(); i++){
                Board childNode = new Board();
                childNode.intArrayToObject(node.objectToIntArray());
                childNode.setPlayerTurn(node.getPlayerTurn());
                childNode.place_by(node.getValidMoves().get(i), childNode.getPlayerTurn());
                childNode.nextTurn();
                int v = minimaxMove(childNode, depth-1, false);
                if(v>=bestValue){
                    bestValue=v;
                    bestPath=node.getValidMoves().get(i);
                } 
            }
            return bestPath;
        }
        
        else{
            int bestValue = 1000;
            for(int i=0; i<node.getValidMoves().size(); i++){
                Board childNode = new Board();
                childNode.intArrayToObject(node.objectToIntArray());
                childNode.setPlayerTurn(node.getPlayerTurn());
                childNode.place_by(node.getValidMoves().get(i), childNode.getPlayerTurn());
                childNode.nextTurn();
                int v = minimaxMove(childNode, depth-1, true);
                if(v<=bestValue){
                    bestValue=v;
                    bestPath=node.getValidMoves().get(i);
                } 
            }
            return bestPath;
        }

    }
    
    
    
    
    
    
    
    
    
    
//    public int minimaxMove(Board parentNode, int depth, boolean maximized){
//        int move = 0;
//        if(depth==0 || parentNode.getValidMoves().isEmpty()){
//            return nodeEvaluation(parentNode);
//        }
//        
//        if(maximized){
//            System.out.println("max");
//            parentNode.displayBoard();
//            HashMap<Integer,Integer> map1 = new HashMap<>();                         
//            for(int i=0; i<parentNode.getValidMoves().size(); i++){    
//                tempNode.intArrayToObject(parentNode.objectToIntArray());
//                tempNode.setPlayerTurn(parentNode.getPlayerTurn());
//                tempNode.place_by(tempNode.getValidMoves().get(i), tempNode.getPlayerTurn());
//                childNode.intArrayToObject(tempNode.objectToIntArray());
//                childNode.setPlayerTurn(tempNode.getPlayerTurn());
//                childNode.nextTurn();
//                map1.put(i, minimaxMove(childNode,depth-1,false));
//                int maxValueInMap=(Collections.max(map1.values()));
//                for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
//                    if (entry.getValue()==maxValueInMap) {
//                        move = entry.getKey();
//                    }
//                }
//            }
//        }
//        
//        else if(!maximized){ //minimized
//            System.out.println("min");
//            parentNode.displayBoard();
//            HashMap<Integer,Integer> map2 = new HashMap<>(); 
//            for(int i=0; i<parentNode.getValidMoves().size(); i++){
//                tempNode.intArrayToObject(parentNode.objectToIntArray());
//                tempNode.setPlayerTurn(parentNode.getPlayerTurn());
//                tempNode.place_by(tempNode.getValidMoves().get(i), tempNode.getPlayerTurn());
//                childNode.intArrayToObject(tempNode.objectToIntArray());
//                childNode.setPlayerTurn(tempNode.getPlayerTurn());
//                childNode.nextTurn();
//                map2.put(i, minimaxMove(childNode,depth-1,true));
//                int minValueInMap=(Collections.min(map2.values()));
//                for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
//                    if (entry.getValue()==minValueInMap) {
//                        move = entry.getKey();
//                    }
//                }
//            }
//        }
//        return move;
//    }
    
    
    
    
}
