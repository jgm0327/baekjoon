import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	private static int n;
	private static List<SnowMan> snowMans;
	
	static class SnowMan implements Comparable<SnowMan>{
		int snow1, snow2, height;

		public SnowMan(int snow1, int snow2, int height) {
			this.snow1 = snow1;
			this.snow2 = snow2;
			this.height = height;
		}

		@Override
		public int compareTo(SnowMan o) {
			return this.height - o.height;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		snowMans = new ArrayList<>();
		
		String[] str = br.readLine().split(" ");
		for(int i=0 ; i<n ; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		for(int i=0 ; i<n ; i++) {
			for(int j=i+1 ; j<n ; j++) {
				snowMans.add(new SnowMan(i, j, arr[i] + arr[j]));
			}
		}
		Collections.sort(snowMans);
		System.out.println(snowManDiff());
		br.close();
	}
	
	public static long snowManDiff() {
		long answer = Long.MAX_VALUE;
		for(int i=0 ; i<snowMans.size() - 1; i++) {
			SnowMan snowman1 = snowMans.get(i);
			for(int j=i+1 ; j < snowMans.size() ; j++) {
				SnowMan snowman2 = snowMans.get(j);
				if(snowman2.snow1 != snowman1.snow1 && snowman1.snow2 != snowman2.snow2 && 
						snowman2.snow2 != snowman1.snow1 && snowman1.snow2 != snowman2.snow1) {
					answer = Math.min(answer, Math.abs(snowman1.height - snowman2.height));
					break;
				}
			}
		}
		
		return answer;
	}
}
