import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	private static int n, m, answer;
	private static int[][] graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t=1 ; t<=T ; t++) {
			answer = 0;
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			m = Integer.parseInt(str[1]);
			
			graph = new int[n][n];
			for(int i=0 ; i<n ; i++) {
				String[] input = br.readLine().split(" "); 
				for(int j=0 ; j<n ; j++) {
					graph[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			for(int i=0 ; i<=n-m ; i++) {
				for(int j=0 ; j<=n-m ; j++) {
					killFlies(i, j);
				}
			}
			bw.write(String.format("#%d %d\n", t, answer));
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void killFlies(int y, int x) {
		int ret = 0;
		for(int i = y ; i<y + m ; i ++) {
			for(int j=x ; j<x+m ; j++) {
				ret += graph[i][j];
			}
		}
		answer = Math.max(answer, ret);
	}
}
