import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static long n, m;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			String[] values = br.readLine().split(" ");
			n = Long.parseLong(values[0]);
			m = Long.parseLong(values[1]);
			bw.write(LCM() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static long LCM() {
		long x = Math.max(n, m), y = Math.min(n, m);
		return (x * y) / GCD(n, m);
	}
	
	private static long GCD(long x, long y) {
		if(x % y == 0)return y;
		return GCD(y, x % y);
	}
}
