import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class a_0723 {
	static List<Integer> hs1 = new ArrayList<Integer>();
	static List<Integer> hs2 = new ArrayList<Integer>();
	static int answer=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		answer = Integer.parseInt(br.readLine());
		int first = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int []a = new int[first];
		
		for(int i=0;i<first;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		int second = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int []b = new int[second];
		for(int i=0;i<second;i++) {
			b[i]=Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < first; i++) {
			int sum = 0;
			for (int j = i; j < first; j++) {
				sum += a[j];
				hs1.add(sum);
			}
		}
		for (int i = 0; i < second; i++) {
			int sum = 0;
			for (int j = i; j < second; j++) {
				sum += b[j];
				hs2.add(sum);
			}
		}
		
		Collections.sort(hs1);
		Collections.sort(hs2);
		
		System.out.println(getCount());
	}
	public static long getCount() {
		int start = 0;
		int end = hs2.size() - 1;
		long cnt = 0;
		
		while (start < hs1.size() && end >= 0) {
			long sum = hs1.get(start) + hs2.get(end);

			if (sum == answer) {
				
				int a = hs1.get(start);
				int b = hs2.get(end);
				long aCnt = 0;
				long bCnt = 0;

				while (start < hs1.size() && hs1.get(start) == a) {
					aCnt++;
					start++;
				}
				while (end >= 0 && hs2.get(end) == b) {
					bCnt++;
					end--;
				}

				cnt += aCnt * bCnt;
				
				
				
			}
			else if (sum < answer)
				start++;

			else if (sum > answer)
				end--;
		}
		return cnt;
	}
}
