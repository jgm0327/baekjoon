import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), idx=0;
		long[] drinks = new long[n];
		for(String input : br.readLine().split(" ")) {
			drinks[idx++] = Long.parseLong(input);
		}
		Arrays.sort(drinks);
		double answer = drinks[n-1];
		for(int i=0 ; i<n-1; i++) {
			answer += (double)drinks[i] / 2;
		}
		System.out.println(answer);
		br.close();
	}
}
