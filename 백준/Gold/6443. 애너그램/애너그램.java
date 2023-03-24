import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static boolean[] visit;
	private static char[] chs;
	private static Map<String, Boolean> map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			String str = br.readLine();
			int len = str.length();
			chs = new char[len];
			for(int i=0 ; i<len  ;i++)chs[i] = str.charAt(i);
			Arrays.sort(chs);
			map = new HashMap<>();
			visit = new boolean[len];
			back(0, len, new StringBuilder());
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void back(int depth, int len, StringBuilder sb) throws IOException{
		if(depth == len) {
			bw.write(sb.toString() + "\n");
			return;
		}
		
		for(int i=0 ; i<len ; i++) {
			if(!visit[i]) {
				visit[i] = true;
				sb.append(chs[i]);
				if(!map.containsKey(sb.toString())) {
					map.put(sb.toString(), true);
					back(depth+1, len, sb);
				}
				sb.delete(depth, depth+1);
				visit[i] = false;
			}
		}
	}
}
