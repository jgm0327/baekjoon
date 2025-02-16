import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static List<Integer>[] tree;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        for(int i=0 ; i<=n ; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=0 ; i<n - 1 ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            int sour = Integer.parseInt(tokenizer.nextToken());
            int des = Integer.parseInt(tokenizer.nextToken());

            tree[sour].add(des);
            tree[des].add(sour);
        }

        parent = new int[n + 1];

        dfs(1, new boolean[n + 1]);

        StringBuilder answer = new StringBuilder();
        for(int i=2 ; i<=n ; i++){
            answer.append(parent[i]).append("\n");
        }

        System.out.print(answer);
        br.close();
    }

    static void dfs(int sour, boolean[] visit){
        visit[sour] = true;

        for(int des : tree[sour]){
            if(visit[des])
                continue;
            parent[des] = sour;
            dfs(des, visit);
        }
    }
}