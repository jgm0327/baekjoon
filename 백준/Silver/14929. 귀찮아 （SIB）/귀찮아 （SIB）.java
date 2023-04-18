import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), idx = 0;
		long[] arr = new long[n];
		
		for(String v : br.readLine().split(" ")) {
			arr[idx++] = Long.parseLong(v);
		}
		
		long total = 0;
		for(int i=0 ; i<n ; i++) {
			total += arr[i];
		}
		
		long answer = 0;
		for(int i=0 ; i<n ; i++) {
			total -= arr[i];
			answer += total * arr[i];
		}
		
		System.out.println(answer);
		br.close();
	}
	
	
}
