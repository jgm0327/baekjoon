import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	private static int[] arr, oper;
	
	public static void main(String[] args) throws IOException{
		insert();
		recur(1, arr[0]);
		System.out.println(max + "\n" + min);
	}
	
	private static void insert() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		oper = new int[4];
		arr = new int[n];
		
		int idx = 0;
		for(String v : br.readLine().split(" ")) {
			arr[idx++] = Integer.parseInt(v);
		}
		
		idx = 0;
		for(String v : br.readLine().split(" ")) {
			oper[idx++] = Integer.parseInt(v);
		}
		br.close();
	}
	
	private static void recur(int depth, int num) {
		if(depth == n) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		if(oper[0] > 0) {
			oper[0]--;
			recur(depth+1, num + arr[depth]);
			oper[0]++;
		}
		if(oper[1] > 0) {
			oper[1]--;
			recur(depth+1, num - arr[depth]);
			oper[1]++;
		}
		if(oper[2] > 0) {
			oper[2]--;
			recur(depth+1, num * arr[depth]);
			oper[2]++;
		}
		
		if(oper[3] > 0) {
			oper[3]--;
			recur(depth+1, num / arr[depth]);
			oper[3]++;
		}
	}
	
}
