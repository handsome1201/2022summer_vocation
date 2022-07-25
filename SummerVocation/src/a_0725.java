import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a_0725 {
	static int[][] a; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		a=new int[n][n];

		for(int i=0;i<n;i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				a[i][j]=Integer.parseInt(st1.nextToken());
			}
		}

		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(a[i][k]==1 && a[k][j]==1) {
						a[i][j]=1;
					}
				}

			}
		}
		for(int i=0;i<n;i++) {

			for(int j=0;j<n;j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}
