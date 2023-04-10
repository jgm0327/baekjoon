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
			int answer = 0;
			int n = Integer.parseInt(br.readLine());
			for(int i=1; i <=n ; i++) {
				if(i % 2 == 0)answer -= i;
				else answer += i;
			}
			bw.write(String.format("#%d %d\n", t, answer));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
