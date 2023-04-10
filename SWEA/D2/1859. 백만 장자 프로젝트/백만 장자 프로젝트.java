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
			int n = Integer.parseInt(br.readLine()), idx = 0;
			long answer = 0;
			int[] arr = new int[n];
			for(String num : br.readLine().split(" ")) {
				arr[idx++] = Integer.parseInt(num);
			}
			
			int comp = arr[n-1];
			for(int i=n-2 ; i>=0 ; i--) {
				if(comp > arr[i])answer += (comp - arr[i]);
				else comp = arr[i];
			}
			bw.write(String.format("#%d %d\n", t, answer));
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
}
