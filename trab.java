public class main(String args[]){
    
    char init_col, init_row, end_col, end_row;
    string command;
    
    CSVReader csv = new CSVReader();
    csv.setDataSource("../../../src/db/arq001.csv");
    String commands[] = csv.requestCommands();


	
    Tabuleiro tabuleiro = new Tabuleiro();

    int state;
    
    for(int i = 0; i < 7;i++){
    for(int j=0; j<7; j++){
        if(i<=1 && j<=1) || (i>=5 && j>=5){
            state = -1;
        }
        else if(i==3 && j==3){
            state = 0;
        }
        else{
            state = 1;
        }
        tabuleiro.createTable(i,j,new Piece(state));
    }
    
    for(int i = 0; i < commands.size();i++){

        command = commands[i];
        init_col = command.charAt(0);
        init_row = command.charAt(1);
    
        end_col= command.charAt(3);
        end_row = command.chatAt(4);
    
        tabuleiro.connectPieces(init_col, init_row, end_col, end_row);
     
    }
}

