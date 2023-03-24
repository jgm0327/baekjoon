import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i=0 ; i<n ; i++)arr[i] = Integer.parseInt(stk.nextToken());
		
		Arrays.sort(arr);
		
		if(n % 2 == 1)System.out.println(arr[n/2]);
		else {
			int v1 = arr[(n/2) - 1], v2 = arr[n/2];
			int tmp1 = 0, tmp2 = 0;
			for(int i=0 ; i<n ; i++) {
				tmp1 += Math.abs(arr[i] - v1);
				tmp2 += Math.abs(arr[i] - v2);
			}
			System.out.println(tmp1 <= tmp2 ? v1 : v2);
		}
		br.close();
	}
}
