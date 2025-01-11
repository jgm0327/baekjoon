import java.io.*;
import java.util.*;

class Main{
    private static int n, m;
    private static int[][] map;
    private static int[][] islands;
    private static PriorityQueue<int[]> pq;
    private static boolean[][] visit;
    private static int[] dy = {0,0,1,-1}, dx = {1,-1,0,0}, parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        map = new int[n][m];
        for(int i=0 ; i<n ; i++){
            tokenizer = new StringTokenizer(br.readLine());

            for(int j=0 ; j<m ; j++){
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int number = 1;
        visit = new boolean[n][m];
        islands = new int[n][m];
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(visit[i][j] || map[i][j] == 0)
                    continue;

                numbering(number, i, j);
                number++;
            }
        }

        pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        parents = new int[number];
        for(int i=0 ; i<number; i++)
            parents[i] = i;

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(islands[i][j] == 0)
                    continue;

                connecting(i, j, islands[i][j]);
            }
        }

        int answer = MST();
        int px = findParent(1);
        for(int i=2 ; i<number ; i++){
            if(px != findParent(i)){
                answer = -1;
                break;
            }
        }

        bw.write(String.valueOf(answer));
		bw.close();
		br.close();
	}

    private static int findParent(int x){
        if(x == parents[x])
            return x;
        return parents[x] = findParent(parents[x]);
    }

    private static void union(int x, int y){
        int px = findParent(x), py = findParent(y);

        if(px == py)
            return;
        
        parents[py] = px;
    }

    private static int MST(){
        int ret = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            int sour = cur[0], des = cur[1], dist = cur[2];
            if(findParent(sour) == findParent(des))
                continue;
                
            union(sour, des);
            ret += dist;
        }

        return ret;
    }

    private static boolean isIn(int y, int x){
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    private static void connecting(int y, int x, int number){
        for(int i=0 ; i<4 ; i++){
            for(int j=1 ; j<Math.max(n, m) ; j++){
                int ny = y + dy[i] * j, nx = x + dx[i] * j;
                
                if(!isIn(ny, nx) || islands[ny][nx] == number)
                    break;
                
                int idx = islands[ny][nx];
                if(idx == 0)
                    continue;
                
                if(j - 1 <= 1)
                    break;

                pq.add(new int[]{number, idx, j - 1});
                break;
            }
        }
    }

    
    private static void numbering(int number, int startY, int startX){
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{startY, startX});

        visit[startY][startX] = true;

        while(!que.isEmpty()){
            int[] cur = que.poll();

            int y = cur[0], x = cur[1];
            islands[y][x] = number;

            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];

                if(!isIn(ny, nx) || visit[ny][nx] || map[ny][nx] == 0)
                    continue;

                visit[ny][nx] = true;
                que.add(new int[]{ny, nx});
            }
        }
    }

}