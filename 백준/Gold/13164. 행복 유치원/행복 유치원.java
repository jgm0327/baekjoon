import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        int[] heights = new int[n];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){
            heights[i] = Integer.parseInt(tokenizer.nextToken());
        }

        // 2 2 1 4
        // 1(2, 3) 2(0, 1) 2(1, 2) 4(3, 4)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0 ; i<n - 1; i++)
            pq.add(heights[i + 1] - heights[i]);
        int cnt = 0, total = 0, answer = 0;
        for(int i=0 ; i<n-k ; i++){
            answer += pq.poll();
        }

        System.out.println(answer);
        br.close();
    }
}