import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t=1 ; t<=T ; t++) {
			StringBuilder answer = new StringBuilder();
			answer.append(String.format("#%d\n", t));
			int n = Integer.parseInt(br.readLine());
			int[][] tri = new int[n+1][n+1];
			tri[0][1] = 1;
			
			for(int i=1 ; i<n ; i++) {
				for(int j=1 ; j<=i+1 ; j++) {
					tri[i][j] += tri[i-1][j-1] + tri[i-1][j];
				}
			}
			
			for(int i=0 ; i<n ; i++) {
				for(int j=1 ; j<=i+1 ; j++) {
					answer.append(tri[i][j]);
					answer.append(" ");
				}
				answer.append("\n");
			}
			bw.write(answer.toString());
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
