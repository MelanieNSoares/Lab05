public class Tabuleiro{
    
    Piece vTabuleiro[][] = new Piece[7][7];
    Piece movingPiece, middlePiece, endPiece;
    
    void createTable(int i, int j, Piece piece){
        vTabuleiro[i][j] = piece;     
    
    } 
    
    char getState(Piece piece){
        if(piece.state == 0){
            return '-';
        }
        
        else if(piece.state == 1){
            return 'P';
        }
        else{
            return ' ';
        }
    }

    void mostrar(){
      int row;
        for(int i = 0; i < 7; i++){
            row = i + 1;
            System.out.print(row + " ");
            for(int j= 0; j<7; j++){
                System.out.print(getState(vTabuleiro[i][j]) + " ");
            }
            System.out.print("\n");
        }
        
        System.out.println(" " +"a "+"b "+"c "+ "d "+ "e "+ "f "+ "g" + "\n");
    }
    
    void connectPieces(char init_col, char init_row,char end_col, char end_row){
        
        
        movingPiece = vTabuleiro[(init_row)-'1'][(init_col)-'a'];
        endPiece= vTabuleiro[(end_row)-'1'][(end_col)-'a'];
        
        char middle;
        int next_value;

        
        if(init_row == end_row){
            if(init_col > end_col){
                next_value = (int)end_col + 1;
                middle = (char) (next_value);
            }
            else{
                next_value = (int)init_col + 1;
                middle = (char)next_value;
            }
            
            
            middlePiece =vTabuleiro[(end_row)-'1'][middle - 'a'];
            
        }else if(end_col == init_col){
            
            if(init_row > end_row){
                next_value = (int)end_row + 1;
                middle = (char)next_value;
            }
            else{
                next_value = (int)init_row + 1;
                middle = (char)next_value;
            }
            
            
            middlePiece = vTabuleiro[(middle)-'1'][end_col - 'a'];
        }
        
        movingPiece.state = 0;
        middlePiece.state = 0;
        endPiece.state = 1;
        
        mostrar();
    }
}
