import java.util.Scanner;

class TicTacToe {
    public static void main(String[] args) {
        int arr[][] = new int[3][3];
        int player = 0;               
        int moves = 0;                
        
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = -1;
            }
        }

        Scanner s = new Scanner(System.in);

        while (true) {
            
            printGrid(arr);

            
            System.out.println("Player " + player + ", enter your move (row and column): ");
            int m = s.nextInt();
            int n = s.nextInt();

            
            if (m < 0 || m > 2 || n < 0 || n > 2 || arr[m][n] != -1) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            
            arr[m][n] = player == 0 ? 0 : 1;
            moves++;

            
            if (checkWin(arr, player)) {
                printGrid(arr);
                System.out.println("Player " + player + " wins!");
                break;
            }

            
            if (moves == 9) {
                printGrid(arr);
                System.out.println("It's a draw!");
                break;
            }

            
            player = 1 - player;
        }
        s.close();
    }

    
    public static void printGrid(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == -1) {
                    System.out.print(". ");  
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static boolean checkWin(int[][] arr, int player) {
        int mark = player == 0 ? 0 : 1;

        
        for (int i = 0; i < 3; i++) {
            if ((arr[i][0] == mark && arr[i][1] == mark && arr[i][2] == mark) || 
                (arr[0][i] == mark && arr[1][i] == mark && arr[2][i] == mark))   
            {
                return true;
            }
        }

    
        if ((arr[0][0] == mark && arr[1][1] == mark && arr[2][2] == mark) ||  
            (arr[0][2] == mark && arr[1][1] == mark && arr[2][0] == mark)) {  
            return true;
        }

        return false;
    }
}

