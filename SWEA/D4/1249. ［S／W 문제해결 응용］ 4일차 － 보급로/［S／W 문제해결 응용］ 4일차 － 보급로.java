import java.util.*;
import java.io.*;

class Solution
{
    private static int n;
    private static final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
    private static int[][] board;
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            n = Integer.parseInt(br.readLine());
            
            board = new int[n][n];
            for(int i=0 ; i<n ; i++){
                String input = br.readLine();
                
                for(int j=0 ; j<n ; j++){
                    board[i][j] = input.charAt(j) - '0';
                }
            }

            answer.append("#").append(test_case).append(" ");
            answer.append(bfs()).append("\n");
		}
        
        System.out.println(answer); 
        
        br.close();
	}
    
    private static int bfs(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        int[][] dp = new int[n][n];
        
        for(int i=0 ; i<n ; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        // y, x, time
        pq.add(new int[]{0, 0, 0});
        dp[0][0] = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            
            int y = cur[0], x = cur[1], time = cur[2];
            
            if(dp[y][x] < time)
                continue;
            
            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];
                
                if(0 > ny || ny >= n || 0 > nx || nx >= n || dp[ny][nx] <= time + board[ny][nx])
                    continue;
                
                dp[ny][nx] = time + board[ny][nx];
                
                if(ny == n - 1 && nx == n - 1)
                    continue;
                
                pq.add(new int[]{ny, nx, time + board[ny][nx]});
                
            }
        }
        
        return dp[n - 1][n - 1];
    }
}