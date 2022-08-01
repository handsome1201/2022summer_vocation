import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class a_0801 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		bag[] lectures = new bag[n];

		for(int i=0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());

			lectures[i] = new bag(weight,price);
		}
		Arrays.sort(lectures);

		int[] bagweight = new int[k];
		for(int i=0;i<k;i++) {
			bagweight[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(bagweight);

		long result = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

		for (int i = 0, j = 0; i < k; i++) {    
			while (j < n && lectures[j].weight <= bagweight[i]) {
				pq.offer(lectures[j++].price);
			}

			if (!pq.isEmpty()) {
				result += pq.poll();
			}
		}

		System.out.println(result);


	}
	static class bag implements Comparable<bag>{
		int weight;
		int price;

		public bag(int weight, int price) {
			this.weight=weight;
			this.price = price;
		}
		@Override
		public int compareTo(bag o) {
			if (o.weight == weight) {
				return price - o.price;
			}

			return weight - o.weight;
		}
	}
}