import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

	public class Main {
		private static int T;
		private static String[] answer;
		
		public static void main(String[] args) throws IOException{
			init();
		}
		
		private static void init() throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			T = Integer.parseInt(br.readLine());
			while(T-- > 0) {
				String[] values = br.readLine().split(" ");
				int start = Integer.parseInt(values[0]), target = Integer.parseInt(values[1]);
				answer = new String[10003];
				for(int i=0 ; i<=10002 ; i++)answer[i] = new String();
				bw.write(bfs(start, target) + "\n");
			}
			bw.flush();
			bw.close();
			br.close();
		}
		
		private static String bfs(int start, int target) {
			Queue<Integer> que = new LinkedList<>();
			que.add(start);
			boolean[] visit = new boolean[10003];
			visit[start] = true;
			
			while(!que.isEmpty()) {
				int cur = que.poll();
				int d = (cur * 2) % 10000, s = (cur == 0) ? 9999 : cur - 1, 
						l = (cur % 1000) * 10 + cur / 1000,
						r = (cur % 10) * 1000 + cur / 10;
				
				int[] arr = new int[] {d, s, l, r};
				char[] opt = new char[] {'D', 'S', 'L', 'R'};
				for(int i=0 ; i<4 ; i++) {
					if(!visit[arr[i]]) {
						answer[arr[i]] = answer[cur] + opt[i];
						if(target == arr[i])return answer[arr[i]];
						que.add(arr[i]);
						visit[arr[i]] = true;
					}
				}
			}
			return "";
		}
}
