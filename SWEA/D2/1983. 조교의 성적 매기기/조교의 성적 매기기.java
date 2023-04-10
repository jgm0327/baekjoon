import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	static class Student implements Comparable<Student>{
		public int id;
		public float score;
		
		public Student(int id, float score) {
			this.id = id;
			this.score = score;
		}
		
		@Override
		public int compareTo(Student o) {
			return (int)(o.score - this.score);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		final String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
		
		for(int t=1 ; t<=T ; t++) {
			Queue<Student> pq = new PriorityQueue<>();
			String[] size = br.readLine().split(" ");
			int n = Integer.parseInt(size[0]), m = Integer.parseInt(size[1]);
			for(int i=0 ; i<n ; i++) {
				String[] stk = br.readLine().split(" ");
				float score = (Float.parseFloat(stk[0]) * 0.35f
						+ Float.parseFloat(stk[1]) * 0.45f
						+ Float.parseFloat(stk[2]) * 0.2f );
				pq.add(new Student(i+1, score));
			}
			int cnt = 0, idx = 0, alloc = n / 10;
			while(!pq.isEmpty()) {
				Student stu = pq.poll();
				if(cnt == alloc) {
					idx++;
					cnt = 0;
				}
				cnt++;
				if(stu.id == m) {
					break;
				}
			}
			bw.write(String.format("#%d %s\n", t, grade[idx]));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
