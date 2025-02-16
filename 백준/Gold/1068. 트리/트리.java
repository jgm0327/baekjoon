import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static List<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n];
        for(int i=0 ; i<n ; i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int root = 0;
        for(int i=0 ;i<n ; i++){
            int parent = Integer.parseInt(tokenizer.nextToken());
            if(parent == -1){
                root = i;
                continue;
            }

            tree[parent].add(i);
        }

        int removeNode = Integer.parseInt(br.readLine());

        System.out.println(dfs(removeNode, root));
        
        br.close();
    }

    static int dfs(int removeNode, int parent){
        if(removeNode == parent)
            return 0;

        int leafNode = 1;
        int ret = 0;

        for(int child : tree[parent]){
            if(removeNode == child)
                continue;

            leafNode = 0;
            ret += dfs(removeNode, child);
        }

        return leafNode + ret;
    }
}