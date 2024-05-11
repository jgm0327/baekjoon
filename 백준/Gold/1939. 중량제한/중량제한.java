import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{

    private static int n;
    private static List<int[]>[] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        graph = new ArrayList[n + 1];
        for(int i=0 ; i<=n ; i++){
            graph[i] = new ArrayList<>();
        }

        int right = 0;

        while(m-- > 0){
            tokenizer = new StringTokenizer(br.readLine());
            
            int sour = Integer.parseInt(tokenizer.nextToken());
            int des = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            graph[sour].add(new int[]{des, weight});
            graph[des].add(new int[]{sour, weight});

            right = Math.max(right, weight);
        }

        tokenizer = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(tokenizer.nextToken());
        int end = Integer.parseInt(tokenizer.nextToken());

        int left = 0; 

        int answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;

            if(bfs(start, end, mid)){
                left = mid + 1;
                answer=Math.max(answer, mid);
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean bfs(int start, int end, int limit){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        boolean[] visit = new boolean[n + 1];
        visit[start] = true;

        while(!que.isEmpty()){
            int sour = que.poll();

            for(int[] next : graph[sour]){
                int des = next[0], weight = next[1];

                if(weight < limit || visit[des])continue;
                if(des == end)return true;

                visit[des] = true;
                que.add(des);
            }
        }

        return false;
    }
}