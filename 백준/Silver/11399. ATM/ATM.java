import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0 ; i<n ; i++)arr[i] = Integer.parseInt(str[i]);
		Arrays.sort(arr);
		int answer = 0, temp = 0;
		for(int i=0 ; i<n ; i++) {
			temp += arr[i];
			answer += temp;
		}
		System.out.println(answer);
		br.close();
	}
}
