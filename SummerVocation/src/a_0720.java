import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a_0720 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		int count=1;
		
		while(m!=n) {
			if(m<n) {
				System.out.println("-1");
				System.exit(0);	
			}
			if(m%2!=0 && m%2!=1) {
				System.out.println("-1");
				System.exit(0);	
			}
			if(m%10==1) {
				count++;
				m/=10;
			}
			else if(m%2==0){
				m/=2;
				count++;
			}
			else {
				System.out.println(-1);
                System.exit(0);
			}
			
		}
		System.out.println(count);

	}



}
