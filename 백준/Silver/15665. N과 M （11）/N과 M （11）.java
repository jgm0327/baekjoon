import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
	static int n, m;
	static List<Integer> list;
	static Map<String, Boolean> map;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] arr = br.readLine().split(" ");
			n = Integer.parseInt(arr[0]);
			m = Integer.parseInt(arr[1]);
			list = new ArrayList<>();
			map = new HashMap<>();
			
			String[] str = br.readLine().split(" ");
			for(String s : str) list.add(Integer.parseInt(s));
			Collections.sort(list);
			back(0, new LinkedList<Integer>());
			br.close();
			bw.close();
		}catch(IOException e) {
			
		}
	}
	
	private static void back(int depth, LinkedList<Integer> path) {
		if(depth == m) {
			try {
				StringBuilder str = new StringBuilder();
				for(int p : path) str.append(p + " ");
				if(map.containsKey(str.toString()))return;
				map.put(str.toString(), true);
				bw.write(str.toString() + "\n");
			}catch(IOException e) {
			}
			return;
		}
		
		for(int i=0 ; i<n ; i++) {
			path.add(list.get(i));
			back(depth+1, path);
			path.pollLast();		
		}
	}
}
