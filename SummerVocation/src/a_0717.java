import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a_0717 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line=br.readLine().split(" ");
		int[] blue = new int[2];

		for(int i=0;i<2;i++) {
			blue[i]=Integer.parseInt(line[i]);
		}
		int[] money = new int[blue[0]];
		for(int i=0;i<blue[0];i++) {
			money[i] =Integer.parseInt(br.readLine());
		}
		int count=0;
		for(int i=money.length-1;i>=0;i--) {
			count+=blue[1]/money[i];
			blue[1]%=money[i];
		}
		System.out.println(count);
	}
}
