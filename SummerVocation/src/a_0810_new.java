import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a_0810_new {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] firstword = br.readLine().split("");
		String[] secondword = br.readLine().split("");

		
		int[][] count = new int[firstword.length+1][secondword.length+1];
		for(int i=0;i<1;i++) {
			for(int j=0;j<1;j++) {
				count[i][j]=0;
			}
		}
		for(int i=1;i<=firstword.length;i++) {
			for(int j=1;j<=secondword.length;j++) {
				if(firstword[i-1].equals(secondword[j-1])) {
					count[i][j]=count[i-1][j-1]+1;
				}
				else {
					count[i][j]=Math.max(count[i-1][j], count[i][j-1]);
				}
				
			}
		}
		System.out.println(count[firstword.length][secondword.length]);
		
	}
}