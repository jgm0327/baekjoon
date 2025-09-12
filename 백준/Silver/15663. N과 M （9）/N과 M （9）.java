import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(arr);

        StringBuilder answer = new StringBuilder();
        dfs(0, m, new int[m], answer, new boolean[n]);

        System.out.print(answer);

        br.close();
    }

    static void dfs(int idx, int m, int[] path, StringBuilder answer, boolean[] visit){
        if(m == 0){
            for(int num : path){
                answer.append(num).append(" ");
            }
            answer.append("\n");
            return;
        }

        for(int i=0 ; i<arr.length ; i++){
            if(visit[i] || path[idx] == arr[i])
                continue;

            path[idx] = arr[i];
            visit[i] = true;
            dfs(idx + 1, m - 1, path, answer, visit);
            visit[i] = false;
        }
        
        path[idx] = 0;
    }
}
