import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> lower = new PriorityQueue<Integer>();
		Queue<Integer> higher = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
		
		for(int i=0 ; i<n ; i++) {
			int data = Integer.parseInt(br.readLine());
			if(higher.size() == lower.size()) higher.add(data);
			else lower.add(data);
			
			if(!lower.isEmpty() && !higher.isEmpty() && lower.peek() < higher.peek()) {
				int tmp = lower.poll();
				lower.add(higher.poll());
				higher.add(tmp);
			}
			bw.write(higher.peek().toString() + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	
}
