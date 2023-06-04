import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder path = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int start, target;
		start = Integer.parseInt(input[0]);
		target = Integer.parseInt(input[1]);
		
		parents = new int[100001];
		for(int i=0 ; i<=100000 ; i++) {
			parents[i] = i;
		}
		
		int answer = bfs(start, target);
		int idx = target;
		ArrayDeque<Integer> stk = new ArrayDeque<>();
		
		while(idx != start) {
			stk.push(idx);
			idx = parents[idx];
		}
		
		path.append(start + " ");
		while(!stk.isEmpty()) {
			path.append(stk.poll());
			path.append(" ");
		}
		
		System.out.println(answer);
		System.out.println(path.toString());
		
		br.close();
	}
	
	private static int bfs(int start, int target) {
		if(start == target)return 0;
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {start, 0});
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int num = cur[0], cnt = cur[1];
			for(int i=0 ; i<3 ; i++) {
				int next;
				if(i == 0)next = num + 1;
				else if(i == 1)next = num - 1;
				else next = 2 * num;
				
				if(0 > next || next > 100000)continue;
				
				if(parents[next] == next) {
					parents[next] = num;
					if(next == target)return cnt + 1;
					que.add(new int[] {next, cnt + 1});
				}
			}
		}
		
		return -1;
	}
	
}
