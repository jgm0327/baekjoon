import java.io.*;
import java.util.*;

class Main {
    private static int n, k;
    private static ArrayDeque<int[]> que;
    private static Set<Integer> visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(br.readLine());
        visit = new HashSet<>();
        que = new ArrayDeque<>();
        
        for(int i=0 ; i<n ; i++){
            int num = Integer.parseInt(tokenizer.nextToken());
            visit.add(num);
            que.add(new int[]{num, 0});
        }

        bw.write(bfs()+"");
        bw.close();
    }

    private static long bfs(){
        final int[] dx = {-1, 1};

        int count = 0;
        long total = 0;

        while(!que.isEmpty()){
            int[] cur = que.poll();

            int x = cur[0], dist = cur[1];
            for(int i=0 ; i<2 ; i++){
                int nextX = x + dx[i];

                if(visit.contains(nextX))
                    continue;

                count++;
                visit.add(nextX);
                total += (dist + 1);

                if(count == k)return total;

                que.add(new int[]{nextX, dist + 1});
            }
        }

        return total;
    }
}