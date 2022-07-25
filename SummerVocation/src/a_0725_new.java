import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class find {
	int x;
	int y;
	int count;
	int wall; //���� �νø鼭 �Դ��� �ƴ���. 0�̸� �ƴϰ� 1�̸� ���� �νø鼭 �Դٴ� ���� �ǹ��Ѵ�.

	public find(int x, int y, int count, int wall) {
		this.x = x;
		this.y = y;
		this.count = count;
		this.wall = wall;
	}
}


public class a_0725_new {
	static int[][] a;
	static boolean[][][] visited;
	static int m,n;
	static int[] dx = {1, 0 , -1, 0};       // �����¿� ����� x��ǥ
	static int[] dy = {0, 1, 0, -1};        // �����¿� ����� y��ǥ
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());

		a=new int[n][m];
		visited=new boolean[2][n][m];
		String[] st = new String[m];
		for(int i=0;i<n;i++) {
			st = br.readLine().split("");
			for(int j=0;j<st.length;j++) {
				a[i][j]=Integer.parseInt(st[j]);
			}
		}
		
		System.out.println(bfs(0,0));




	}
	static int bfs(int x, int y) {
		Queue<find> q = new LinkedList<>();
		q.add(new find(x, y, 1, 0));
		visited[0][x][y] = true; //0�� ���� �ν��� �ʰ� �湮�� ����� �湮 ����
		visited[1][x][y] = true; //1�� ���� �νø鼭 �湮�� ����� �湮 ����e;

		while(!q.isEmpty()) {
			find current = q.poll();

			if(current.x==n-1 && current.y == m-1) {
				return current.count;
			}

			for(int i=0;i<4;i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if(a[nx][ny]==0) {
						if (visited[current.wall][nx][ny] == false) { //������� �� ���(���� �ν����� �ƴ���)���� �湮�� ���� ���ٸ� �湮�Ѵ�.
							q.add(new find(nx, ny, current.count + 1, current.wall));
							visited[current.wall][nx][ny] = true;
						}
					}
					else{
						if (current.wall==0 && visited[1][nx][ny] == false) { //������� �� ���(���� �ν����� �ƴ���)���� �湮�� ���� ���ٸ� �湮�Ѵ�.
							q.add(new find(nx, ny, current.count + 1, 1));
							visited[1][nx][ny] = true;
						}
					}
				}
			}



		}
		return -1;
	}
}
