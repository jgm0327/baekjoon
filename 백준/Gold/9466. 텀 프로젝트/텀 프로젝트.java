import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
	public class Main {
		private static int n, cnt;
		private static int[] arr;
		private static boolean[] makeTeam, visit;
		private static BufferedWriter bw;
		
		public static void main(String[] args) throws IOException{
			input();
			bw.flush();
			bw.close();
		}
		
		private static void input() throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int T = Integer.parseInt(br.readLine());
			while(T-- > 0) {
				n = Integer.parseInt(br.readLine());
				arr = new int[n+1];
				makeTeam = new boolean[n+1];
				visit = new boolean[n+1];
				cnt = 0;
				String[] num = br.readLine().split(" ");
				for(int i=1 ; i<=n ; i++) {
					arr[i] = Integer.parseInt(num[i-1]);
					if(arr[i] == i) {
						makeTeam[i] = true;
						cnt++;
					}
				}
				solution();
				bw.write((n-cnt) + "\n");
			}
			br.close();
		}
		
		private static void solution() {
			for(int i=1 ; i<=n ; i++) {
				if(!makeTeam[i]) {
					dfs(0, i);
				}
			}
		}
		
		private static void dfs(int depth ,int sour) {
			if(makeTeam[sour])return;
			if(visit[sour]) {
				cnt++;
				makeTeam[sour] = true;
			}
			visit[sour] = true;
			dfs(depth+1, arr[sour]);
			visit[sour] = false;
			makeTeam[sour] = true;
		}
}
