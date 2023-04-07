import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static int n, m, answer;
	private static List<int[]> chickenHouses, houses;
	private static Deque<int[]> open;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		answer = Integer.MAX_VALUE;

		chickenHouses = new ArrayList<>();
		houses = new ArrayList<>();
		open = new ArrayDeque<>();
		
		for(int i=0 ; i<n ; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0 ; j<n ;j++) {
				int data = Integer.parseInt(input[j]);
				if(data == 2)chickenHouses.add(new int[] {i, j});
				else if(data == 1)houses.add(new int[] {i, j});
			}
		}
		closed(0, 0);
		System.out.println(answer);
		br.close();
	}
	
	private static void calcDist() {
		int comp = 0, tmp;
		for(int[] house : houses) {
			int y = house[0], x = house[1];
			tmp = Integer.MAX_VALUE;
			Iterator<int[]> it = open.iterator();
			while(it.hasNext()) {
				int[] cur = it.next();
				int cy = cur[0], cx = cur[1];
				tmp = Math.min(tmp, (Math.abs(y - cy) + Math.abs(x - cx)));
			}
			comp += tmp;
		}
		
		answer = Math.min(comp, answer);
	}
	
	private static void closed(int depth, int start) {
		if(depth == m) {
			return;
		}
		for(int i=start ; i<chickenHouses.size() ; i++) {
			open.add(chickenHouses.get(i));
			calcDist();
			closed(depth + 1, i + 1);
			open.pollLast();
		}
	}
}
