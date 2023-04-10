import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t=1 ; t<=T ; t++) {
			int answer = 0, idx = 0;
			int[] numbers = new int[10];
			for(String number : br.readLine().split(" ")) {
				numbers[idx++] = Integer.parseInt(number);
			}
			Arrays.sort(numbers);
			for(int i=1 ; i<9 ; i++)answer += numbers[i];
			bw.write(String.format("#%d %d\n", t, Math.round((double)answer/8)));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
