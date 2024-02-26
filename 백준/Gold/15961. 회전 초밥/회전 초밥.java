import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	private static int n, d, k, c, answer;
	private static int[] sushi;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] init = br.readLine().split(" ");
		n = Integer.parseInt(init[0]);
		d = Integer.parseInt(init[1]);
		k = Integer.parseInt(init[2]);
		c = Integer.parseInt(init[3]);
		
		sushi = new int[n];
		for(int i=0 ; i<n ; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		solution();
		
		System.out.println(answer);
		br.close();
	}
	
	private static void solution() {
		Map<Integer, Integer> isIn = new HashMap<>();
		answer = 0;
		
		int cnt = 0;
		for(int i=0; i<k ; i++) {
			cnt += setMap(isIn, sushi[i], 1);
		}
		
		int start = 0, end = k;
		while(end < n + k) {
			cnt += setMap(isIn, sushi[start], -1);
			cnt += setMap(isIn, sushi[end % n], 1);
			answer = Math.max(answer, isIn.containsKey(c) ? cnt : cnt + 1);
			start++;
			end++;
		}
	}
	
	private static int setMap(Map<Integer, Integer> map, int target, int plus) {
		int cnt = 0;
		if(map.containsKey(target))map.replace(target, map.get(target) + plus);
		else if(plus > 0){
			map.put(target, 1);
			cnt = plus;
		}
		if(map.containsKey(target) && map.get(target) == 0) {
			map.remove(target);
			cnt = plus;
		}
		return cnt;
	}
	
}
