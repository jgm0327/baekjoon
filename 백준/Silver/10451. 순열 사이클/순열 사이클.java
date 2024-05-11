import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    private static int n;
    private static int[] graph;

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
        graph = new int[n + 1];

        for(int sour=1 ; sour<=n ; sour++){
            int des = Integer.parseInt(tokenizer.nextToken());
            graph[sour] = des;
        }
    }

    private static int solution(){
        int ret = 0;

        boolean[] v = new boolean[n + 1];

        for(int i=1 ; i<=n ; i++){

            if(v[i])continue;

            dfs(i, v);

            ret++;
        }

        return ret;
    }

    private static void dfs(int sour, boolean[] v){
        int des = graph[sour];

        v[sour] = true;

        if(v[des]){
            return;
        }

        dfs(des, v);
    }
}