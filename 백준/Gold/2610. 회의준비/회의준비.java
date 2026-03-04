import java.util.*;
import java.io.*;

class Main {
    static int[] parents;
    static int n;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parents = new int[n + 1];
        for(int i=1; i<=n ; i++)
            parents[i] = i;

        int[][] distances = new int[n + 1][n + 1];
        for(int i=1; i<=n ; i++){
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }

        while(m-- > 0){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            union(a, b);
            distances[a][b] = distances[b][a] = 1;
        }

        for(int k=1 ; k<=n ; k++){
            for(int i=1 ; i<=n ; i++){
                for(int j=1 ; j<=n ; j++){
                    if(distances[i][k] == Integer.MAX_VALUE || distances[k][j] == Integer.MAX_VALUE 
                        || distances[i][k] + distances[k][j] >= distances[i][j] || i==j)
                        continue;

                    distances[i][j] = distances[i][k] + distances[k][j];
                }
            }
        }

        Map<Integer, Integer> min = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();

        for(int i=1 ; i<=n ; i++){
            min.put(findParent(i), Integer.MAX_VALUE);
        }

        for(int i=1; i<=n ; i++){
            int pi = findParent(i);

            int max = 0;
            for(int j=1 ; j<=n ; j++){
                if(distances[i][j] == Integer.MAX_VALUE)
                    continue;

                max = Math.max(max, distances[i][j]);
            }

            if(min.get(pi) > max){
                min.replace(pi, max);
                first.put(pi, i);
            }
        }

        int[] arr = new int[first.size()];
        int idx = 0;
        for(int key : first.keySet()){
            arr[idx++] = first.get(key);
        }
        Arrays.sort(arr);
        
        StringBuilder answer = new StringBuilder();
        answer.append(idx).append("\n");
        for(int num : arr){
            answer.append(num).append("\n");
        }

        System.out.print(answer);

        br.close();
    }

    static int findParent(int x){
        if(x == parents[x])
            return x;

        return parents[x] = findParent(parents[x]);
    }

    static void union(int x, int y){
        int px = findParent(x), py = findParent(y);

        if(px == py)
            return;

        parents[px] = py;
    }
}