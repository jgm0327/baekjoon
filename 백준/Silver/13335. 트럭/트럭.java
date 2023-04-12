import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, w, l;
		
		String[] size = br.readLine().split(" ");
		n = Integer.parseInt(size[0]);
		w = Integer.parseInt(size[1]);
		l = Integer.parseInt(size[2]);
		
		int[] trucks = new int[n];
		int idx = 0;
		for(String truck : br.readLine().split(" ")) {
			trucks[idx++] = Integer.parseInt(truck);
		}
		
		Queue<Integer> bridge = new LinkedList<>();
		for(int i=0 ; i<w ; i++)bridge.add(0);
		int total = 0, time = 0;
		
		idx = 0;
		while(!bridge.isEmpty()) {
			time++;
			total -= bridge.poll();
			if(idx < n && total + trucks[idx] <= l) {
				bridge.add(trucks[idx]);
				total += trucks[idx];
				idx++;
			}else{
				bridge.add(0);
			}
			if(total == 0)break;
		}
		
		System.out.println(time);
		br.close();
	}
	
}
