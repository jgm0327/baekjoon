import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int n;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			n = Integer.parseInt(br.readLine());
			Integer[] input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
			int min = 1000000, max = -1000000;
			for(int i=0 ; i<n ; i++) {
				min = min > input[i] ? input[i] : min;
				max = max < input[i] ? input[i] : max;
			}
			System.out.println(min + " " + max);
			br.close();
		}catch(IOException e) {
			
		}
	}
}
