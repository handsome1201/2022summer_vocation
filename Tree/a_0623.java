package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class a_0623{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String basket=br.readLine();
		StringTokenizer st=new StringTokenizer(basket);

		int n =Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		String[] word = new String[5];

		String[] compareword = new String[10];
		for(int i=0;i<5;i++){   
			word[i]=br.readLine();
		}
		for(int i=0;i<m;i++){   
			compareword[i]=br.readLine();
		}

	

		int count=0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<5;j++) {
				if(compareword[i].equals(word[j].substring(0,compareword[i].length()))) {
					count++;
				
					break;
				}       	
			}
		}
		System.out.println(count);






	}

}

