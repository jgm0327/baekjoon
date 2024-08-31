import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());

        int m = Integer.parseInt(br.readLine());

        int[][] delivery = new int[m][3];

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            int count = Integer.parseInt(tokenizer.nextToken());

            delivery[i] = new int[] { from, to, count };
        }

        Arrays.sort(delivery, (o1, o2) -> {
            if (o1[1] != o2[1])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
            
        });

        int answer = 0;
        int[] villageCount = new int[n + 1];
        Arrays.fill(villageCount, c);

        for(int[] d : delivery){
            int from = d[0], to = d[1], count = d[2];
            
            int maxCount = Integer.MAX_VALUE;
            for(int num = from ; num < to ; num++){
                maxCount = Math.min(maxCount, villageCount[num]);
            }

            if(count > maxCount)count = maxCount;
            
            answer += count;
            for(int num = from ; num < to ; num++){
                villageCount[num] -= count;
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}