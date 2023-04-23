import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int n;
	private static long[] arr;
	
	public static void main(String[] args) throws IOException{
		init();
		solution();
	}
	
	private static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new long[n];
		
		int idx = 0;
		for(int i=0 ; i<n ; i++) {
			arr[idx++] = Long.parseLong(br.readLine());
		}
		
		br.close();
	}
	
	private static void solution() {
		long answer = 0;
		Arrays.sort(arr);
		for(int i=0 ; i<n ; i++) {
			answer += Math.abs(arr[i] - (i + 1));
		}
		System.out.println(answer);
	}
}
