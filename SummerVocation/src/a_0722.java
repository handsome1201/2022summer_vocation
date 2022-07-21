import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class a_0722 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] length = new int[n];
		int[] count = new int[m];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			length[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<n;i++) {
			if(i%2!=0) {
				for(int j=m-length[i];j<m;j++) {
					count[j]++;
				}
			}
			else { 
				for(int j=0;j<length[i];j++) {
					count[j]++;
				}
			}
		}
		Arrays.sort(count);
		int min=count[0];
		int samenum=1;
		
		for(int i=1;i<n;i++) {
			if(count[i]!=min) {
				System.out.println(count[0]+" "+samenum);
				System.exit(0);
			}
			else {
				samenum++;
			}
		}
	
	}
}
