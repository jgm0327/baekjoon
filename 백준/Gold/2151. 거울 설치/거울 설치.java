import java.io.*;
import java.util.*;

class Main {

    private static char[][] room;
    private static int n;
    private static final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
    private static boolean[][][][] visit;
    private static List<int[]>[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        room = new char[n][n];
        graph = new ArrayList[n][n];
        int[] start = {-1, -1};
        int[] end = {-1, -1};

        visit = new boolean[n][n][n][n];
        for(int i=0 ; i<n ; i++){
            String input = br.readLine();

            for(int j=0 ; j<n ; j++){
                graph[i][j] = new ArrayList<>();

                room[i][j] = input.charAt(j);

                if(room[i][j] != '#')
                    continue;
                
                if(start[0] == -1)
                    start = new int[]{i, j};
                else
                    end = new int[]{i, j};
            }
        }
        
        makeGraph(start, end);
        bw.write(String.valueOf(dijkstra(start, end) - 1));
        bw.close();
        br.close();
    }

    private static int dijkstra(int[] start, int[] end){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.add(new int[]{start[0], start[1], 0});

        int[][] costs = new int[n][n];
        for(int i=0 ; i<n ; i++)
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        costs[start[0]][start[1]] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            int y = cur[0], x = cur[1], dist = cur[2];
            if(costs[y][x] > dist)
                continue;

            for(int[] des : graph[y][x]){
                int ny = des[0], nx = des[1];

                if(dist + 1 > costs[ny][nx])
                    continue;

                costs[ny][nx] = dist + 1;
                if(end[0] == ny && end[1] == nx)
                    continue;

                pq.add(new int[]{ny, nx, dist + 1});
            }
        }

        return costs[end[0]][end[1]] == Integer.MAX_VALUE ? 1 : costs[end[0]][end[1]];
    }

    private static void makeGraph(int[] start, int[] end){
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{start[0], start[1], -1});

        for(int i=0 ; i<4;  i++){
            for(int j=0 ; j<n ; j++){
                int ny = start[0] + dy[i] * j, nx = start[1] + dx[i] * j;

                if(!isIn(ny, nx) || room[ny][nx] == '*')
                    break;

                if(room[ny][nx] == '!'){
                    que.add(new int[]{ny, nx, i});
                    visit[start[0]][start[1]][ny][nx] = true;
                    graph[start[0]][start[1]].add(new int[]{ny, nx});
                }
            }
        }

        while(!que.isEmpty()){
            int[] cur = que.poll();

            int y = cur[0], x = cur[1], d = cur[2];

            reflectionPoint(que, y, x, d);
        }
    }

    private static void reflectionPoint(Queue<int[]> que, int y, int x, int dir){
        int start = (dir / 2) * 2 + 2;

        for(int i=start ; i<start + 2 ; i++){
            for(int j=1 ; j<n ; j++){
                int ny = y + dy[i % 4] * j, nx = x + dx[i % 4] * j;

                if(!isIn(ny, nx) || room[ny][nx] == '*' || visit[y][x][ny][nx])
                    break;

                if(room[ny][nx] == '!' || room[ny][nx] == '#'){
                    graph[y][x].add(new int[]{ny, nx});
                    visit[y][x][ny][nx] = true;
                    que.add(new int[]{ny, nx, i});
                }
            }
        }
    }

    private static boolean isIn(int y, int x){
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}