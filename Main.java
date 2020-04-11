public class Main{
    public static void main(String args[]){

        char init_col, init_row, end_col, end_row;
        String command;

        CSVReader csv = new CSVReader();
        csv.setDataSource("Untitled spreadsheet - Sheet1.csv");
        String commands[] = csv.requestCommands();


    
        Tabuleiro tabuleiro = new Tabuleiro();

        int state;

        for(int i = 0; i < 7;i++){
            for(int j=0; j<7; j++){
                if((i<=1 && j<=1) || (i>=5 && j>=5) || (i<=1 && j>=5) || i>=5 && j<=1 ){
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
        }

        System.out.println("Tabuleiro inicial:");
        tabuleiro.mostrar();

        for(int i = 0; i < commands.length; i++){

            command = commands[i];
            init_col = command.charAt(0);
            init_row = command.charAt(1);
        
            end_col= command.charAt(3);
            end_row = command.charAt(4);

            System.out.println("Source: " +init_col + init_row + "\nTarget: "+ end_col + end_row);
        
            tabuleiro.connectPieces(init_col, init_row, end_col, end_row);
        
        }
    }       
}

