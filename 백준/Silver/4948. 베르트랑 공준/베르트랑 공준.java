import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
	private static Map<Integer, Boolean> primes;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		primes = new HashMap<>();
		findPrime();
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0)break;
			int answer = 0;
			for(int i = n + 1 ; i <= 2 * n ; i++) {
				if(primes.containsKey(i))answer++;
			}
			bw.write(answer + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void findPrime() {
		Map<Integer, Boolean> isNotPrime = new HashMap<>();
		int size = 246913;
		for(int i=2 ; i<size ; i++) {
			if(isNotPrime.containsKey(i))continue;
			primes.put(i, true);
			for(int j = i + i ; j < size ; j += i) {
				isNotPrime.put(j, true);
			}
		}
	}
}
