import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    private static int[] count, numbers;
    private static int n, minValue, maxValue;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        count = new int[4];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ;i++){
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<4 ; i++){
            count[i] = Integer.parseInt(tokenizer.nextToken());
        }

        minValue = Integer.MAX_VALUE;
        maxValue = Integer.MIN_VALUE;
        backtracking(1, numbers[0]);

        System.out.println(maxValue);
        System.out.println(minValue);
    }

    private static void backtracking(int depth, int total){
        if(depth == n){
            minValue = Math.min(minValue, total);
            maxValue = Math.max(maxValue, total);
            return;
        }

        if(count[0] > 0){
            count[0] -= 1;
            backtracking(depth + 1, total + numbers[depth]);
            count[0] += 1;
        }
        if(count[1] > 0){
            count[1] -= 1;
            backtracking(depth + 1, total - numbers[depth]);
            count[1] += 1;
        }
        if(count[2] > 0){
            count[2] -= 1;
            backtracking(depth + 1, total * numbers[depth]);
            count[2] += 1;
        }
        if(count[3] > 0){
            count[3] -= 1;
            backtracking(depth + 1, total / numbers[depth]);
            count[3] += 1;
        }
    }
}