import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{

    private static int n;
    private static int[] parents, graph;
    private static boolean flag;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());

            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            init(tokenizer);
            
            answer.append(solution()).append("\n");
        }

        System.out.print(answer);
    }

    private static void init(StringTokenizer tokenizer){
        parents = new int[n + 1];
            
        graph = new int[n + 1];
            
        for(int i=0 ; i<=n ; i++){
            parents[i] = i;
        }

        for(int sour=1 ; sour<=n ; sour++){
            int des = Integer.parseInt(tokenizer.nextToken());
            graph[sour] = des;
        }
    }

    private static int solution(){
        int ret = 0;

        boolean[] v = new boolean[n + 1];
        Map<Integer, Boolean> visit = new HashMap<>();

        for(int i=1 ; i<=n ; i++){
            flag = false;

            if(v[i] || visit.containsKey(findParent(i)))continue;
            dfs(i, v, visit);

            if(!flag)continue;
            ret++;
        }

        return ret;
    }

    private static void dfs(int sour, boolean[] v, Map<Integer, Boolean> visit){
        int des = graph[sour];

        if(v[sour] || findParent(sour) == findParent(des)){
            if(findParent(sour) == findParent(des)){
                visit.put(findParent(sour), true);
                flag = true;
            }
            return;
        }

        v[sour] = true;
        union(sour, des);
        dfs(des, v, visit);
    }

    private static int findParent(int x){
        if(parents[x] == x)return x;
        return parents[x] = findParent(parents[x]);
    }

    private static void union(int x, int y){
        int px = findParent(x), py = findParent(y);

        if(py == px)return;

        parents[py] = px;
    }

}