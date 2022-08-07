import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class a_0807 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken()); 
		
		int[] six_pack = new int[m];
		int[] one_pack = new int[m];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			six_pack[i]=Integer.parseInt(st.nextToken());
			one_pack[i]=Integer.parseInt(st.nextToken());
			
		}
		Arrays.sort(six_pack);
		Arrays.sort(one_pack);
		
		int pack_count=n/6;
		int one_count=n%6;
		int stop=0;
		for(int i=1;i<=6;i++) {
			if(six_pack[0]<=one_pack[0]*i) {
				stop=i;
				break;
			}
		}
		if(six_pack[0]>one_pack[0]*6) {
			System.out.println(one_pack[0]*n);
		}
		else if(stop<=one_count) {
			System.out.println(six_pack[0]*(pack_count+1));
		}
		else {
			System.out.println(six_pack[0]*pack_count+one_pack[0]*one_count);
		}
		
	}
}

