import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] problems = new int[n][2];

        for(int i=0 ; i<n ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            int deadLine = Integer.parseInt(tokenizer.nextToken());
            int count = Integer.parseInt(tokenizer.nextToken());

            problems[i] = new int[]{deadLine, count};
        }

        Arrays.sort(problems, (o1, o2) -> {
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            return o2[1] - o1[1];
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> 
        {
            if(o1[1] != o2[1])return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        
        for(int[] problem : problems){
            int deadLine = problem[0], count = problem[1];

            if(pq.size() >= deadLine){
                if(pq.peek()[1] >= count)
                    continue;

                pq.poll();
            }

            pq.add(problem);
        }

        int answer = 0;
        while(!pq.isEmpty()){
            answer += pq.poll()[1];
        }

        bw.write(String.valueOf(answer));

        /**
         * 3
         * 3 9
         * 3 4
         * 1 1
         * 
         * (1, 1), (3, 9), (3, 4)
         * 
         * 
         * 4
         * 1 1
         * 2 1
         * 3 10
         * 3 10
         * 
         * (1, 1), (3, 10), (3, 10)
         * 
         * 4
         * 1 50
         * 2 1
         * 3 60
         * 3 70
         * 
         * (1, 50), (3, 60), (4, 70)
         */

        bw.flush();
        bw.close();

        br.close();
    }
}