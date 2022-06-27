import java.util.*;
import java.io.*;

public class a_0627_again {
	static int[][] graph;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();

		StringTokenizer st = new StringTokenizer(line);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		graph=new int[n+1][m+1];

		for(int i=1;i<=n;i++) {
			String[] num = br.readLine().split("");
			for(int j=1;j<=m;j++) {
				graph[i][j]=Integer.parseInt(num[j-1]);
			}
		}

		visited=new boolean[n+1][m+1]; //�湮 ���� Ȯ��

		Queue<location> q = new LinkedList<>();
		q.offer(new location(1, 1)); //���� ��ġ�� q�� �־���
		
		visited[1][1]=true;
		int[] width= {1,0,-1,0};
		int[] heigth= {0,1,0,-1}; //�����¿� ��ġ �� Ȯ�� ��

		while(!q.isEmpty()) {
			location lo = q.poll(); //q���� ���� ������ �ش� ��ġ �� Ȯ��
			for(int i=0;i<4;i++) {
				int xx = lo.x+width[i]; //�¿� �� Ȯ��
				int yy=lo.y+heigth[i]; //���� �� Ȯ��
				if(xx>0 && yy>0 && xx<=m && yy<=n) { //�����¿� ���� �ش� 2���� �迭�� �Ѿ�� ������(����) 
					if(graph[yy][xx]!=0 && !visited[yy][xx]) { //�ش� ��ġ�� ���� 0�� �ƴϰ� �湮�� ���� �ƴ϶��
						visited[yy][xx] = true; //�湮�Ѱɷ� �ٲ�
						graph[yy][xx]=graph[lo.y][lo.x]+1; //������ġ������ 1�� ������
						q.add(new location(xx, yy));//q�� �־���
					}
				}
			}
		}
		System.out.println(graph[n][m]);//�� ������ ��ġ �� ���

	}
}
class location{
	int x;
	int y;

	public location(int x,int y){
		this.x=x;
		this.y=y;
	}
	public int getX(int x) {
		return x;
	}
	public int getY(int y) {
		return x;
	}
	public int setX(int x) {
		return x;
	}
	public int setY(int y) {
		return y;
	}

}
