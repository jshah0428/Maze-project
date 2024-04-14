import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;


public class Main{

    static char [][] matrix = makemaze();

    public static boolean solvemaze(int rowc, int columnc) {
       return solvemaze( rowc, columnc, true);
   }

    public static boolean solvemaze(int rowc,int columnc, boolean isStart){

            if (rowc<0 || rowc>= matrix.length||columnc<0 || columnc>=matrix[0].length){
                return false;
            }    
            if (matrix[rowc][columnc] == '-'){
                
                return true;
            }
            if (matrix[rowc][columnc] != ' ' && !isStart){ 
                return false;

            }



            
            matrix[rowc][columnc]= '.';
            boolean up = solvemaze(rowc-1,columnc, false);
            boolean down = solvemaze(rowc+1,columnc, false);
            boolean left = solvemaze(rowc,columnc-1, false);
            boolean right = solvemaze(rowc,columnc+1, false);

            if (up || down ||left||right){
                matrix[rowc][columnc] = '+';
                return true;
            }
            
            
            return false;

    }

 


    public static void main(String[] args) {
        int rowcounter = 0;
        int columncounter = 0;
        

        for(int i = 0; i < matrix.length; ++i){
            for (int j = 0; j<matrix[i].length;++j){
                if (matrix[i][j]=='+'){
                rowcounter = i;
                columncounter= j;
                
            }
                         
            
        }
    }
   
    

    if (solvemaze(rowcounter, columncounter)){
        System.out.println("solution found");
        for(int i = 0; i < matrix.length; ++i){
            for (int j = 0; j<matrix[i].length;++j){     
                System.out.print(matrix[i][j]);
            }
            System.out.println();

        }

    }
    else{
        System.out.println("no solution found");
    }

    }


    public static char[][] makemaze(){

       
        ArrayList<char[]> list = new ArrayList<char[]>(); 
        File in = new File("maze.txt");
        //System.out.println(in.getAbsolutePath());
        try(Scanner scan = new Scanner(in)){
            scan.nextLine();
                while (scan.hasNext()){
                    list.add(scan.nextLine().toCharArray());

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        char [][] matrix = new char [list.size()][];

        for (int i = 0; i<matrix.length; i++){
            matrix[i] = list.get(i);
        }

        return matrix;



        }

    
}
