import java.util.Scanner;

class Main{

    static int n, size, blank;
    static int[] visit;
    static int[][] board;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        size = n * 2;

        board = new int[n][size];
        visit = new int[n];

        StringBuilder answer = new StringBuilder();

        blank = n;
        triangle(0, 0, n);

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<size ; j++){
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

    private static boolean isIn(int y, int x){
        return 0 <= y && y < n && 0 <= x && x < size;
    }

    private static void triangle(int y, int x, int size){
        if(size == 3){
            if(visit[y] == 0){
                visit[y] = blank;
                blank -= 3;
            }

            for(int i=0 ; i<3 ; i++){
                for(int k=0 ; k < 2*i + 1 ; k++){
                    int ny = y + i, nx = x + k + visit[y] - i - 1;

                    if((i == 1 && k == 1) || !isIn(ny, nx))
                        continue;

                    board[ny][nx] = 1;
                }
            }

            return;
        }

        for(int i=0 ; i<2 ; i++){
            for(int k=0 ; k<2*i + 1 ; k++){
                int ny = y + (i * size / 2), nx = x + (k * size / 2);
                if(k == 1 || !isIn(ny, nx))
                    continue;

                triangle(ny, nx, size / 2);
            }
        }
    }

}