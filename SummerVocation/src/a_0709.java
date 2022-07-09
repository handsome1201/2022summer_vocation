import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a_0709 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long n = Integer.parseInt(st.nextToken());
		long m = Integer.parseInt(st.nextToken());

		int count=0;
		long left=0;
		long right= 2000000000;
		if(n==m || ((m*100)/n)==99) {
			System.out.println("-1");
		}
		else {
			while(left<right) {
				long mid=(right+left)/2;
				
				long rate = (100*(m+mid))/(n+mid);
				
				if(rate>((m*100)/n)) {
					right=mid;
				}
				else {
					left=mid+1;
				}
			}
			System.out.println(right);
		}
	}
}