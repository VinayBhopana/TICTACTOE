import java.util.Scanner;

class tictactoe{
    
    
    public static String board[][] = {{"00","01","02"} , {"10","11","12"} , {"20","21","22"}};
    public static  int playercount = 0;
    public static void print(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" | ");
            }  
            System.out.println();      
        }
    }
      
    public static void msg(Scanner scanner){
        int x = 0;
        int y =0;
        System.out.println(playercount%2==0?"X's Turn" : "O's Turn");
        System.out.print("Enter X(0,1,2) : ");
        x = scanner.nextInt();
        System.out.print("Enter Y(0,1,2) : ");
        y = scanner.nextInt();
        System.out.println(insert(x,y,playercount%2==0?"X" : "O"));

        
    }
    public static String insert(int x,int y , String name){
        if((x<3&&x>=0)&&(y<3&&y>=0)){
            if(!board[x][y].equals("X")&&!board[x][y].equals("O")){
                board[x][y] = name;
                print();
                playercount++;
                if(check()){
                    System.out.println(name+" wins");
                    System.exit(0);
                }else if(playercount==9){
                    System.out.println("Its a draw");
                    System.exit(0);
                }
                return "Inserted";
                

            }else{return "Already Occupied";}

        }
        return "Unexpected Place";

    }
    
    public static boolean check(){
        for(int i=0;i<3;i++){
            if(board[i][0].equals(board[i][1])&&board[i][1].equals(board[i][2])&&!board[i][0].equals("")){
                return true;
            }
        }
        for(int i=0;i<3;i++){
            if(board[0][i].equals(board[1][i])&&board[1][i].equals(board[2][i])&&!board[i][0].equals("")){
                return true;
            }
        }
        
        if(board[0][0].equals(board[1][1])&&board[1][1].equals(board[2][2])&&!board[0][0].equals("")){
                return true;
        }

        if(board[0][2].equals(board[1][1])&&board[1][1].equals(board[2][0])&&!board[0][2].equals("")){
            return true;
        }

        return false;

        
    }


        
        
    
    
    public static void main(String[] args) {
        System.out.println("Each position of the board is made up either 0,1,2\nTo insert X or O you need to type a combination of the three numbers\n\n   TICTACTOE");
        Scanner scanner = new Scanner(System.in);
        print();
        while(true){
            msg(scanner);
        }
        
       
        
        

        
    }
}
