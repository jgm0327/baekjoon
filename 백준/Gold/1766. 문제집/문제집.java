import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] pre;
    private static int n, m;
    private static Queue<Integer> pq;
    private static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        list = new ArrayList[n + 1];
        for(int i=0 ; i<=n ; i++){
            list[i] = new ArrayList<>();
        }

        pre = new int[n + 1];
        for(int i=0 ; i<m ; i++){
            tokenizer = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(tokenizer.nextToken());
            int des = Integer.parseInt(tokenizer.nextToken());

            pre[des]++;
            list[sour].add(des);
        }

        pq = new PriorityQueue<>();
        for(int i=1 ; i<=n ; i++){
            if(pre[i] != 0)continue;

            pq.add(i);
        }

        topologicalSort();
    }

    private static void topologicalSort(){
        StringBuilder answer = new StringBuilder();

        while(!pq.isEmpty()){
            int sour = pq.poll();
            answer.append(sour).append(" ");

            for(int des : list[sour]){
                pre[des]--;

                if(pre[des] != 0)continue;

                pq.add(des);
            }
        }

        System.out.println(answer);
    }
}