import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int n;
	private static char[][] map;
	
	public static void main(String[] args) throws IOException{
		init();
		solution();
	}
	
	private static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for(int i=0 ; i<n ; i++) {
			String str = br.readLine();
			for(int j=0 ; j<n ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		br.close();
	}
	
	private static void solution() {
		int hCnt = 0, vCnt = 0;
		
		for(int i=0 ; i<n ; i++) {
			int th = 0, tv = 0;
			for(int j=0 ; j<n ; j++) {
				if(map[i][j] == '.')th++;
				else if(map[i][j] == 'X') {
					if(th >= 2)hCnt++;
					th = 0;
				}
				if(map[j][i] =='.')tv++;
				else if(map[j][i] == 'X') {
					if(tv >= 2)vCnt++;
					tv = 0;
				}
			}
			if(th >= 2)hCnt++;
			if(tv >= 2)vCnt++;
		}
		
		System.out.println(hCnt + " " + vCnt);
	}
}
