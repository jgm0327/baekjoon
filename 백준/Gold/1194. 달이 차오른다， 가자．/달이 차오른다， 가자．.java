import java.io.*;
import java.util.*;

class Main{
    private static char[][] board;
    private static int n, m;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        board = new char[n][m];

        int[] start = new int[2];
        for(int i=0 ; i<n ; i++){
            String str = br.readLine();

            for(int j=0 ; j<m ; j++){
                board[i][j] = str.charAt(j);
                if(board[i][j] == '0') start = new int[]{i, j};
            }
        }

        bw.write(String.valueOf(bfs(start)));
		bw.close();
		br.close();
	}

    private static int bfs(int[] start){
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{start[0], start[1], 0, 0});

        boolean[][][] visit = new boolean[n][m][65];
        visit[start[0]][start[1]][0] = true;

        int[] dy = {0, 0, 1, -1}, dx = {-1, 1, 0, 0};

        while(!que.isEmpty()){
            int[] cur = que.poll();

            int y = cur[0], x = cur[1], dist = cur[2], key = cur[3];

            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i], nextKey = key;

                if(0 > ny || ny >= n || 0 > nx || nx >= m || visit[ny][nx][nextKey] || board[ny][nx] == '#')
                    continue;

                char ch = board[ny][nx];
                if('A' <= ch && ch <= 'F' && (key & (1 << (ch - 'A'))) == 0)
                    continue;
                
                if('a' <= ch && ch <= 'f'){
                    nextKey |= (1 << (ch - 'a'));
                }

                if(ch == '1')
                    return dist + 1;
                
                que.add(new int[]{ny, nx, dist + 1, nextKey});
                visit[ny][nx][nextKey] = true;
            }
        }

        return -1;
    }

}