import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static int n, m;
	static List<Integer> list;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] arr = br.readLine().split(" ");
			n = Integer.parseInt(arr[0]);
			m = Integer.parseInt(arr[1]);
			list = new ArrayList<>();
			String[] str = br.readLine().split(" ");
			for(String s : str) list.add(Integer.parseInt(s));
			Collections.sort(list);
			back(0, 0, new LinkedList<Integer>());
			br.close();
			bw.close();
		}catch(IOException e) {
			
		}
	}
	
	private static void back(int depth, int start, LinkedList<Integer> path) {
		if(depth == m) {
			try {
				StringBuilder str = new StringBuilder();
				for(int p : path) str.append(p + " ");
				bw.write(str.toString() + "\n");
			}catch(IOException e) {
			}
			return;
		}
		
		for(int i=start ; i<n ; i++) {
			path.add(list.get(i));
			back(depth+1, i + 1, path);
			path.pollLast();
				
		}
	}
}
