import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int n;
	private static long answer = 1000000001;
	private static Integer[][] ingredients;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ingredients = new Integer[n][2];
		for(int i=0 ; i<n ; i++) {
			String[] input = br.readLine().split(" ");
			ingredients[i][0] = Integer.parseInt(input[0]);
			ingredients[i][1] = Integer.parseInt(input[1]);
		}
		back(0, 0, 1, 0);
		System.out.println(answer);
		br.close();
	}
	
	private static void back(int depth, int start, int sour, int bitter) {
		if(depth == n) return;
		for(int i=start ; i<n ; i++) {
			int ts = sour * ingredients[i][0], tb = bitter + ingredients[i][1];
			answer = Math.min(answer, Math.abs(ts-tb));
			back(depth+1, i+1, sour * ingredients[i][0], bitter + ingredients[i][1]);
		}
	}
}
