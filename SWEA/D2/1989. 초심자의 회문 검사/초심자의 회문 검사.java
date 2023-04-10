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
			String str = br.readLine();
			int len = str.length();
			int half = len % 2 == 0 ? len / 2 : (len / 2) + 1;
			StringBuilder sb = new StringBuilder((str.substring(half, len)));
			if(str.substring(0, len / 2).equals(sb.reverse().toString()))
				answer = 1;
			
			bw.write(String.format("#%d %d\n", t, answer));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
