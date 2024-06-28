import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> numbers = new HashMap<>();

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        while(tokenizer.hasMoreTokens()){
            int number = Integer.parseInt(tokenizer.nextToken());
            numbers.put(number, numbers.getOrDefault(number, 0) + 1);
        }

        int answer = 0;

        for(int i=1 ; i<=999 ; i++){
            if(!numbers.containsKey(i))
                continue;

            numbers.put(i, numbers.get(i) - 1);
            for(int j=1 ; j<=999 ; j++){
                if(!numbers.containsKey(j) || numbers.get(j) == 0)
                    continue;

                answer = Math.max(answer, digitSum(i * j));
            }
            numbers.put(i, numbers.get(i) +1);
        }

        System.out.println(answer);
    }

    private static int digitSum(int number){
        int ret = 0;

        while(number > 0){
            ret += number % 10;
            number /= 10;
        }

        return ret;
    }
}