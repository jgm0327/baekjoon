import java.io.*;
import java.util.*;

class Main {
    private static int n;
    private static List<Integer>[] list;
    private static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        tree = new int[n + 1][2];

        for(int i=0 ; i<=n ; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0 ; i<n-1 ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        tree[1] = new int[]{1, 1};
        dfs(1, 1, new boolean[n + 1]);

        StringBuilder answer = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        while(m-- > 0){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());


            answer.append(LCA(a, b)).append("\n");
        }


        
        System.out.print(answer);
        br.close();
    }

    private static int LCA(int a, int b){
        if(tree[a][1] > tree[b][1]){
            return LCA(tree[a][0], b);
        }
        else if(tree[a][1] < tree[b][1]){
            return LCA(a, tree[b][0]);
        }
        else{
            if(a == b)
                return a;
            else
                return LCA(tree[a][0], b);
        }
    }

    private static void dfs(int depth, int parent, boolean[] visit){
        visit[parent] = true;

        for(int child : list[parent]){
            if(visit[child])
                continue;

            tree[child] = new int[]{parent, depth + 1};
            dfs(depth + 1, child, visit);
        }
    }
}