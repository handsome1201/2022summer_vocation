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
            long mid = (left + right) / 2; //������ ����
            long sum = 0; // ��� ���� ���� ��
            for (int result : money) {
                if (result >= mid) sum += mid; //����� ���� �� �� �ִ� ����
                else sum += result; //������ ������ ���� �ִ� ���� ��
            }
            if (sum > max) { // ����� ���� ���� ���� ��� -> ������  �ٿ�����.
                right = mid - 1;
            } else { // ����� ���ݺ��� ���� ��� -> ������ ������ �� �ְ��� ����� ���� ã�´�.
                left = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        System.out.println(answer);
        
	}
}
