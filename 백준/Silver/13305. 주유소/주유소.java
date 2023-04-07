import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), idx = 0;
		int[] distances = new int[n-1], stations = new int[n];
		for(String input : br.readLine().split(" ")) {
			distances[idx++] = Integer.parseInt(input);
		}
		idx = 0;
		for(String input : br.readLine().split(" ")) {
			stations[idx++] = Integer.parseInt(input);
		}
		
		int prev = stations[0], answer = stations[0] * distances[0];
		for(int i=1 ; i<n-1; i++) {
			if(prev * distances[i] > stations[i] * distances[i]) {
				prev = stations[i];
			}
			answer += prev * distances[i];
		}
		System.out.println(answer);
		br.close();
	}
}
