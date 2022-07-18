import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class a_0718 {

		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			HashSet<Integer> h = new HashSet<Integer>();
			for(int i=0;i<n;i++) {
				int m1 = Integer.parseInt(br.readLine());
				int[] num1 = new int[m1];
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				for(int j=0;j<m1;j++) {
					h.add(Integer.parseInt(st1.nextToken()));
				}
				int m2 = Integer.parseInt(br.readLine());
				int[] num2 = new int[m2];
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for(int j=0;j<m2;j++) {
					if(h.contains(Integer.parseInt(st2.nextToken()))) {
						System.out.println("1");
					}
					else {
						System.out.println("0");
					}
				}	
			}
		}
	}

