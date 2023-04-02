import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Main {
	
	static class Problem implements Comparable<Problem>{
		int rank, number;
		public Problem(int number, int rank) {
			this.rank = rank;
			this.number = number;
		}

		@Override
		public int compareTo(Problem o) {
			if(o.rank == this.rank)return this.number - o.number;
			return this.rank - o.rank;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		TreeSet<Problem> ts = new TreeSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		while(n-- > 0) {
			String[] str = br.readLine().split(" ");
			int number = Integer.parseInt(str[0]), rank = Integer.parseInt(str[1]);
			ts.add(new Problem(number, rank));
			map.put(number, rank);
		}
		
		int m = Integer.parseInt(br.readLine());
		while(m-- > 0) {
			String[] str = br.readLine().split(" ");
			if(str[0].equals("add")) {
				int number = Integer.parseInt(str[1]), rank = Integer.parseInt(str[2]);
				ts.add(new Problem(number, rank));
				map.put(number, rank);
			}else if(str[0].equals("solved")) {
				int number = Integer.parseInt(str[1]);
				int rank = map.remove(number);
				ts.remove(new Problem(number, rank));
			}else if(str[0].equals("recommend")) {
				int opt = Integer.parseInt(str[1]);
				if(opt == 1)bw.write(ts.last().number + "\n");
				else bw.write(ts.first().number + "\n");
			}
		}
		bw.close();
		br.close();
	}
}
