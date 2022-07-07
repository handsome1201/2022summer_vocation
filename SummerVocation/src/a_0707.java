import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class a_0707 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] line=line=br.readLine().split(" ");
		int[] money = new int[n];

		for(int i=0;i<n;i++) {
			money[i]=Integer.parseInt(line[i]);
		}
		
		Arrays.sort(money);
		
		long max = Integer.parseInt(br.readLine());

		long left = 0;
        long right = money[n-1];
        long answer=0;
        while (left <= right) {
            long mid = (left + right) / 2; //내야할 세금
            long sum = 0; // 모든 지방 세금 합
            for (int result : money) {
                if (result >= mid) sum += mid; //내라는 세금 낼 수 있는 지방
                else sum += result; //못내는 지방은 가진 최대 돈만 냄
            }
            if (sum > max) { // 내라는 세금 보다 많은 경우 -> 세금을  줄여본다.
                right = mid - 1;
            } else { // 내라는 세금보다 적은 경우 -> 세금을 높여서 더 최고의 경우의 수를 찾는다.
                left = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        System.out.println(answer);
        
	}
}
