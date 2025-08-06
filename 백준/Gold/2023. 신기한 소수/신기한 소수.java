import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        answer = new StringBuilder();

        dfs(n, new StringBuilder());

        System.out.print(answer);

        br.close();
    }

    static void dfs(int depth, StringBuilder path) {
        if (depth == 0) {
            answer.append(path).append("\n");
            return;
        }

        for (int i = 0; i < 9; i++) {
            char number = (char)('1' + i);

            path.append(number);
            if(isPrime(Integer.parseInt(path.toString())))
                dfs(depth - 1, path);

            path.deleteCharAt(path.length() - 1);
        }
    }

    static boolean isPrime(int number) {
        if(number == 1)
            return false;
            
        for(int i=2 ; i<=Math.sqrt(number) ; i++){
            if(number % i == 0)
                return false;
        }

        return true;
    }
}