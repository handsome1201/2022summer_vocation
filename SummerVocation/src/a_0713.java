import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class a_0713 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line=br.readLine().split(" ");
		int[] blue = new int[2];

		for(int i=0;i<2;i++) {
			blue[i]=Integer.parseInt(line[i]);
		}

		String[] length = br.readLine().split(" ");
		int[] collect = new int[blue[0]];
		int start = 0;
		for(int i=0;i<blue[0];i++) {
			collect[i]=Integer.parseInt(length[i]);
			if(start<collect[i]) {
				start=collect[i];
			}
		}

		

		
		int end=0;
		for(int i=0;i<collect.length;i++) {
			end+=collect[i];
		}

		while(start<=end) {
			int count=0;
			int plus=0;
			int mid = (start + end)/2;
			for(int j=0;j<collect.length;j++) {
				if(mid<(plus+collect[j])) {
					plus=0;
					count++;
				}

				plus+=collect[j];

			}
			if(plus!=0) {
				count++;
			}
			if(count>blue[1]) {
				start=mid+1;
			}
			else {
				end=mid-1;
			}
		}
		System.out.println(start);


	}

}
