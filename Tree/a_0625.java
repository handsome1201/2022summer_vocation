package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class a_0625 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String basket=br.readLine();
		StringTokenizer st=new StringTokenizer(basket);

		int n =Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());

		int[] basket1 = new int[m];
		HashSet<Integer> owned = new HashSet<>();
		for(int i=0;i<m;i++) {
			String number = br.readLine();
			basket1[i] = Integer.parseInt(number);
			int blockedNum = 0;
			for(int tmp=basket1[i];tmp>=2;tmp/=2) {
				if(owned.contains(tmp)) {
					blockedNum=tmp;			
				}
			}
			System.out.println(blockedNum);
			if(blockedNum==0) {
				owned.add(basket1[i]);
			}
		}
	}





}
