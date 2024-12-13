import java.io.*;
import java.util.*;

class Main {
    private static Set<Integer>[] graph;
    private static List<Map<Integer, Boolean>> cases;
    private static int[] count;
    private static boolean[] visit;
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        graph = new HashSet[n + 1];
        for(int i=0 ; i<=n ; i++){
            graph[i] = new HashSet<>();
        }

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        count = new int[n + 1];
        for(int i=1 ; i<=n ; i++){
            count[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for(int sour=1; sour<=n ; sour++){
            tokenizer = new StringTokenizer(br.readLine());

            tokenizer.nextToken();
            while(tokenizer.hasMoreTokens()){
                int des = Integer.parseInt(tokenizer.nextToken());
                graph[sour].add(des);
                graph[des].add(sour);
            }
        }

        
        cases = new ArrayList<>();
        visit = new boolean[n + 1];

        for(int size = 1 ; size<n ; size++)
            findAllCases(1, new boolean[n + 1], size);

        int answer = Integer.MAX_VALUE;
        for(Map<Integer, Boolean> team1 : cases){
            boolean f1 = false, f2 = false;
            int total1 = 0, total2 = 0;

            for(int i=1 ; i<=n ; i++){
                if(f1 && f2)
                    break;

                if(!f1 && team1.containsKey(i)){
                    f1 = true;
                    total1 = bfs(team1, true, i, team1.size());
                }
                else if(!f2 && !team1.containsKey(i)){
                    f2 = true;
                    total2 = bfs(team1, false, i, n - team1.size());
                }
            }
            
            if(total1 == Integer.MAX_VALUE || total2 == Integer.MAX_VALUE)
                continue;

            answer = Math.min(Math.abs(total1 - total2), answer);
        }

        if(answer == Integer.MAX_VALUE)
            answer = -1;

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    private static void findAllCases(int start, boolean[] t1, int size){
        if(size == 0){
            cases.add(new HashMap<>());
            for(int i=1;i<=n ; i++){
                if(t1[i]) cases.get(cases.size() - 1).put(i, true);
            }
            return;
        }

        for(int i=start ; i<=n ; i++){
            if(visit[i])
                continue;
            
            visit[i] = true;
            t1[i] = true;
            findAllCases(i + 1, t1, size - 1);
            t1[i] = false;
            visit[i] = false;
        }
    }

    private static int bfs(Map<Integer, Boolean> team1, boolean isTeam1, int start, int size){
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);

        boolean[] v = new boolean[n + 1];
        v[start] = true;

        int total = 0, cnt = 0;
        while(!que.isEmpty()){
            int sour = que.poll();
            cnt++;
            total += count[sour];

            for(int des : graph[sour]){
                if(isTeam1 != team1.containsKey(des) || v[des])
                    continue;

                que.add(des);
                v[des] = true;
            }
        }

        if(cnt != size)
            return Integer.MAX_VALUE;

        return total;
    }
}
