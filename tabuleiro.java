package workspace.lab05;

public class tabuleiro{
    
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
        for(int i = 0; i < 7; i++){
            System.out.print(i+1 + " ");
            for(int j= 0; i<7; i++){
                System.out.print(getState(vTabuleiro[i][j]) + " ")
            }
            System.out.print("\n");
        }
        
        System.out.print(" " +"a "+"b "+"c "+ "d "+ "e "+ "f "+ "g");
    }
    
    void connectPieces(char init_col, char init_row,char end_col, char end_row){
        
        
        movingPiece = vTabuleiro[(init_col)-'a'][(init_row)-'1'];
        endPiece= vTabuleiro[(end_col)-'a'][(end_row)-'1'];
        
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
            
            
            middlePiece = vTabuleiro[middle - 'a'][(end_row)-'1'];
            
        }else if(end_col == init_col){
            
            if(init_row > end_row){
                next_value = (int)end_row + 1;
                middle = (char)next_value;
            }
            else{
                next_value = (int)init_row + 1;
                middle = (char)next_value;
            }
            
            
            middlePiece = vTabuleiro[end_col - 'a'][(middle)-'1'];
        }
        
        movingPiece.state = 0;
        middlePiece.state = 0;
        endPiece.state = 1;
        
        mostrar();
    }
}
