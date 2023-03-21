import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n, m;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] arr = br.readLine().split(" ");
			n = Integer.parseInt(arr[0]);
			m = Integer.parseInt(arr[1]);
			back(0, 1, new StringBuilder());
			br.close();
			bw.close();
		}catch(IOException e) {
			
		}
	}
	
	private static void back(int depth, int start, StringBuilder str) {
		if(depth == m) {
			try {
				bw.write(str.toString() + "\n");
			}catch(IOException e) {
			}
			return;
		}
		
		for(int i=start ; i<=n ; i++) {
			str.append(i + " ");
			back(depth+1, i + 1, str);
			str.delete(2*depth, 2*depth + 2);
		}
	}
}
