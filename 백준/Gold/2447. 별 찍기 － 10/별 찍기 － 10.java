import java.util.Scanner;

class Main{

    static int[][] board;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        board = new int[n][n];

        star(0, 0, n);

        StringBuilder answer = new StringBuilder();
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                if(board[i][j] == 1)
                    answer.append("*");
                else
                    answer.append(" ");
            }
            answer.append("\n");
        }

        System.out.print(answer);
        sc.close();
	}

    private static void star(int y, int x, int size){
        if(size == 3){
            for(int i=0 ; i<3 ; i++){
                for(int j=0 ; j<3 ; j++){
                    if(i == 1 && j == 1)
                        continue;

                    board[y + i][x + j] = 1;
                }
            }
            return;
        }

        for(int i=0 ; i<3 ; i++){
            for(int j=0 ; j<3 ; j++){
                if(i == 1 && j == 1)
                    continue;

                int div = size / 3;
                star(y + i * div, x + j * div, div);
            }
        }
    }
}