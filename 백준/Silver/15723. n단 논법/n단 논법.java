import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	private static int n, m;
	private static Map<Character, List<Character>> graph;
	private static boolean[] visit;
	private static boolean flag;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new HashMap<>();
		for(int i=0 ; i<26 ; i++) {
			char idx = (char)('a' + i);
			graph.put(idx, new ArrayList<>());
		}
		
		for(int i=0 ; i<n ; i++) {
			String[] str = br.readLine().split(" ");
			char sour = str[0].charAt(0), des = str[2].charAt(0);
			graph.get(sour).add(des);
		}
		
		m = Integer.parseInt(br.readLine());
		for(int i=0 ; i<m ; i++) {
			String[] str = br.readLine().split(" ");
			visit = new boolean[26];
			char sour = str[0].charAt(0), des = str[2].charAt(0);
			flag = false;
			dfs(sour, des);
			System.out.println(flag ? "T" : "F");
		}
		br.close();
	}
	
	private static void dfs(char sour, char target) {
		if(visit[(int)(sour - 'a')] && flag) {
			return;
		}
		visit[(int)(sour - 'a')] = true;
		for(char des : graph.get(sour)) {
			if(!visit[(int)(des - 'a')]) {
				if(des == target || flag) {
					flag = true;
					return;
				}
				dfs(des, target);
			}
		}
	}
	
}
