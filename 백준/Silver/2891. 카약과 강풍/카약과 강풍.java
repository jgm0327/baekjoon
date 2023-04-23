import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int n, s;
	private static int[] status;
	
	public static void main(String[] args) throws IOException{
		init();
		solution();
	}
	
	private static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		n = Integer.parseInt(size[0]);
		s = Integer.parseInt(size[1]);
		
		status = new int[n+2];
		
		for(String v : br.readLine().split(" ")) {
			status[Integer.parseInt(v)] += -1;
		}
		
		for(String v : br.readLine().split(" ")) {
			status[Integer.parseInt(v)] += 1;
		}
		
		br.close();
	}
	
	private static void solution() {
		int answer = 0;
		for(int i=1 ; i<=n ; i++) {
			if(status[i] == -1) {
				if(status[i-1] == 1) {
					status[i-1] = 0;
				}else if(status[i+1] == 1) {
					status[i+1] = 0;
				}else {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
