import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());

        int[] prefixA = new int[n + 1];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        Map<Integer, Integer> ACount = new HashMap<>();
        for(int i=0 ; i<n ; i++){
            prefixA[i + 1] += prefixA[i] + Integer.parseInt(tokenizer.nextToken());
        }

        for(int i=0 ; i<=n ; i++){
            for(int j=i+1 ; j<=n ; j++){
                int key = prefixA[j] - prefixA[i];
                ACount.put(key, ACount.getOrDefault(key,0) + 1);
            }
        }

        int m = Integer.parseInt(br.readLine());

        int[] prefixB = new int[m + 1];
        Map<Integer, Integer> BCount = new HashMap<>();

        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<m ; i++){
            prefixB[i + 1] =  prefixB[i] + Integer.parseInt(tokenizer.nextToken());
        }

        for(int i=0 ; i<=m ; i++){
            for(int j=i+1 ; j<=m ; j++){
                int key = prefixB[j] - prefixB[i];
                BCount.put(key, BCount.getOrDefault(key,0) + 1);
            }
        }

        long answer = 0;

        for(int A : ACount.keySet()){
            int B = t - A;
            if(!BCount.containsKey(B))
                continue;

            answer += (long)ACount.get(A) * (long)BCount.get(B);
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
