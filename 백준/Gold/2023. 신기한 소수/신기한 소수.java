import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    private static int n;
    private static final int[] numbers = {1, 2, 3, 5, 7, 9};
    private static StringBuilder answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        answer = new StringBuilder();
        dfs(0, 0);

        System.out.print(answer);
    }

    private static boolean isPrime(int number){
        while(number > 0){
            if(number == 1)return false;

            for(int i=2 ; i<=Math.sqrt(number) ; i++){
                if(number % i == 0)
                    return false;
            }

            number /= 10;
        }
        return true;
    }

    private static void dfs(int depth, int number){
        if(depth == n){
            answer.append(number).append("\n");
            return;
        }

        for(int num : numbers){
            int temp = number * 10 + num;
            if(!isPrime(temp))continue;

            dfs(depth + 1, temp);
        }
    }

}