import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[] pizzaA = new int[n];
        for(int i=0 ; i<n ; i++){
            pizzaA[i] = Integer.parseInt(br.readLine());
        }

        int[] pizzaB = new int[m];
        for(int i=0 ; i<m ; i++){
            pizzaB[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> countA = countPizza(pizzaA);
        Map<Integer, Integer> countB = countPizza(pizzaB);

        long answer = 0;
        for(int i=0 ; i<=t ; i++){
            answer += (long)countA.getOrDefault(i, 0) * (long)countB.getOrDefault(t - i, 0);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    private static Map<Integer, Integer> countPizza(final int[] pizza){
        Map<Integer, Integer> count = new HashMap<>();
        int n = pizza.length;

        count.put(0, 1);

        for(int size = 0 ; size<n - 1; size++){

            int total = 0;
            for(int i=0 ; i<=size ; i++){
                total += pizza[i];
            }

            count.put(total, count.getOrDefault(total, 0) + 1);
            
            for(int i=1 ; i<n ; i++){
                total += (pizza[(i + size) % n] - pizza[i - 1]);
                count.put(total, count.getOrDefault(total, 0) + 1);
            }
        }

        int total = 0;
        for(int i=0 ; i<n ; i++)total += pizza[i];

        count.put(total, count.getOrDefault(total, 0) + 1);
        return count;
    }

}