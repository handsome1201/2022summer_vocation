import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class a_0727_new {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Map<String, Double> map = new HashMap<>();

		for(int i=0;i<n;i++) {
			String line =br.readLine();
			int length = line.length();
			String[] word = new String[length];
			for(int j=0;j<length;j++) {
				word=line.split("");
			}
			for(int j=0;j<length;j++) {
				if(map.containsKey(word[j])) {
					map.put(word[j], map.get(word[j]) +Math.pow(10, word.length-1-j));
				}
				else {
					map.put(word[j], Math.pow(10, length-1-j));
				}
			}	
		}
		List<String> keySet = new ArrayList<>(map.keySet());

		// Value 값으로 오름차순 정렬
		keySet.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return map.get(o1).compareTo(map.get(o2));
			}
		});
		double result=0;
		double[] a = new double[map.size()];
		
		
		Double num = 10.0-(double)map.size();
		for (String key : keySet) {
			result += map.get(key)*num;
			num++;
		}
		System.out.println((int)result);
	}
}
