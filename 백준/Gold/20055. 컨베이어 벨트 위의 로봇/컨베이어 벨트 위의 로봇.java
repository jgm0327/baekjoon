import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    private static int[][] belt; 
    private static boolean[] robots;
    private static int n, k, zeroCount;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(br.readLine());

        belt = new int[2][n];

        
        for(int j=0 ; j<n ; j++){
            belt[0][j] = Integer.parseInt(tokenizer.nextToken());
        }
        
        for(int j=n-1 ; j>=0 ; j--){
            belt[1][j] = Integer.parseInt(tokenizer.nextToken());
        }
        
        int answer = 0;
        robots = new boolean[n];

        while(zeroCount < k){
            answer++;

            rotationBelt(belt);
            rotationRobot(true);

            rotationRobot(false);

            if(belt[0][0] == 0)
                continue;

            robots[0] = true;
            belt[0][0]--;

            if(belt[0][0] == 0)
                zeroCount++;
        }

        System.out.println(answer);
    }

    private static void rotationBelt(int[][] belt){
        int temp = belt[0][0];

        belt[0][0] = belt[1][0];

        for(int i=0 ; i<n - 1; i++){
            belt[1][i] = belt[1][i + 1];
        }

        belt[1][n - 1] = belt[0][n - 1];
        
        for(int i= n - 1 ; i > 1 ; i--){
            belt[0][i] = belt[0][i - 1];
        }

        belt[0][1] = temp;
    }

    private static void rotationRobot(boolean sameTime){
        for(int x = n - 2 ; x >= 0 ; x--){

            if(!sameTime && (belt[0][x + 1] == 0 || robots[x + 1]) 
            || !robots[x])
                continue;
    
            if(!sameTime)
                belt[0][x + 1]--;

            if(!sameTime && belt[0][x + 1] == 0)
                zeroCount++;

            robots[x] = false;
            robots[x + 1] = true;

            if(x + 1 == n - 1){
                robots[x + 1] = false;
            }
        }
    }
}