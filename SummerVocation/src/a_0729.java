import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class a_0729 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		lecture[] lectures = new lecture[n];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for(int i=0;i<n;i++) {
			String[] clas = br.readLine().split(" ");
			int s = Integer.parseInt(clas[0]);
			int e = Integer.parseInt(clas[1]);

			lectures[i] = new lecture(s,e);
		}
		Arrays.sort(lectures);

		pq.add(lectures[0].e);

		for(int i=1;i<n;i++) {

			if (lectures[i].s >= pq.peek()) {
				pq.poll();
			}
			pq.offer(lectures[i].e);
		}
		System.out.println(pq.size());
	}
	static class lecture implements Comparable<lecture> {
		int s;
		int e;

		public lecture(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(lecture o) {
			if (s == o.s)
				return e - o.e;

			return s - o.s;
		}
	}
}
