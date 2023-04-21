import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	private static int n, k, answer = 0;
	private static int[] arr;
	private static int[] count;
	
	public static void main(String[] args) throws IOException{
		init();
		solution();
		System.out.println(answer);
	}
	
	private static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		count = new int[100001];
		String[] size = br.readLine().split(" ");
		n = Integer.parseInt(size[0]);
		k = Integer.parseInt(size[1]);
		
		arr = new int[n];
		int idx = 0;
		for(String v : br.readLine().split(" ")) {
			arr[idx++] = Integer.parseInt(v);
		}
		
		br.close();
	}
	
	private static void solution() {
		int start = 0, end = 0;
		while(start <= end && end < n) {
			if(count[arr[end]] + 1 <= k) {
				count[arr[end]]++;
				end++;
			}else {
				count[arr[start]]--;
				start++;
			}
			answer = Math.max(answer, end - start);
		}
	}
}
