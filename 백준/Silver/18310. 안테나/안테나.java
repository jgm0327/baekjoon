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
		
		System.out.println(arr[(n-1) / 2]);
		
		br.close();
	}
}
