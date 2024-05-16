import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            Map<Integer, Boolean> numbers = new HashMap<>();

            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for(int i=0 ; i<n ; i++){
                numbers.put(Integer.parseInt(tokenizer.nextToken()), true);
            }

            int m = Integer.parseInt(br.readLine());

            tokenizer = new StringTokenizer(br.readLine());
            while(tokenizer.hasMoreTokens()){
                int number = Integer.parseInt(tokenizer.nextToken());
                answer.append(numbers.containsKey(number) ? 1 : 0).append("\n");
            }
        }

        System.out.print(answer);
    }

}