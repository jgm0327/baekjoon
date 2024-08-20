import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] problems = new int[n][2];

        for(int i=0 ; i<n ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            int deadLine = Integer.parseInt(tokenizer.nextToken());
            int count = Integer.parseInt(tokenizer.nextToken());

            problems[i] = new int[]{deadLine, count};
        }

        Arrays.sort(problems, (o1, o2) -> {
            if(o1[0] != o2[0])return o1[0] - o2[0];
            return o2[1] - o1[1];
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
    
        int answer = 0;
        for(int[] problem : problems){
            int deadLine = problem[0], count = problem[1];
            
            while(pq.size() >= deadLine && pq.peek()[1] < count){
                answer -= pq.poll()[1];
            }

            if(pq.size() == deadLine)continue;

            answer += count;
            pq.add(problem);
        }

        System.out.println(answer);

        br.close();
    }
}