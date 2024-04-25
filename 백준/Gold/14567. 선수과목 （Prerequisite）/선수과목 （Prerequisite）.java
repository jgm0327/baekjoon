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
    private static List<Integer>[] graph;
    private static int[] pre, answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        graph = new ArrayList[n + 1];
        for(int i=0 ; i<=n ; i++){
            graph[i] = new ArrayList<>();
        }

        pre = new int[n + 1];
        while(m-- > 0){
            stk = new StringTokenizer(br.readLine());
            
            int sour = Integer.parseInt(stk.nextToken());
            int des = Integer.parseInt(stk.nextToken());

            graph[sour].add(des);
            pre[des]++;
        }

        Queue<Integer> que = new LinkedList<>();
        answer = new int[n + 1];
        for(int i=1 ; i<=n ; i++){
            if(pre[i] > 0)continue;
            que.add(i);
            answer[i] = 1;
        }

        topologicalSort(que);

        StringBuilder sb = new StringBuilder();
        for(int i=1 ; i<=n ; i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void topologicalSort(Queue<Integer> que){
        while(!que.isEmpty()){
            int sour = que.poll();

            for(int des : graph[sour]){
                pre[des]--;

                if(pre[des] != 0)continue;
                answer[des] = answer[sour] + 1;
                que.add(des);
            }
        }
    }
}