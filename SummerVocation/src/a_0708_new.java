import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class team {
	int x, y;
	team(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class a_0708_new {
	static int N, M;
	static String[][] board;
	static boolean[][] visit;
	static Queue<team> q;
	static ArrayList<Integer> count = new ArrayList<>();
	static ArrayList<Integer> count1 = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new String[M][N];
		visit = new boolean[M][N];
		q = new LinkedList<team>();
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			board[i] = str.split("");
		}


		int w = 0;
		int b = 0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(board[i][j].equals("W") && !visit[i][j]) {
					wbfs(j,i);
				}
				else if(board[i][j].equals("B") && !visit[i][j]){
					bbfs(j,i);
				}
			}
		}
		int w1=0;
		for(int i =0; i<count.size();i++) { // 각 단지의 집 수를 출력
			w1+=Math.pow(count.get(i), 2);
		}
		int b1=0;
		for(int i =0; i<count1.size();i++) { // 각 단지의 집 수를 출력
			b1+=Math.pow(count1.get(i), 2);
		}

		System.out.println(w1+" "+b1);

	}
	static void wbfs(int x, int y) {
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		int cnt = 0;

		q.offer(new team(x, y));
		visit[y][x] = true;
		while(!q.isEmpty()) {
			team t = q.poll();
			cnt++;
			for(int i=0; i<4; i++) {
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(board[ny][nx].equals("W") && !visit[ny][nx]) {
						q.offer(new team(nx, ny));

						visit[ny][nx] = true;
					}
				}
			}
		}
		count.add(cnt);


	}


	static void bbfs(int x, int y) {
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		int cnt1 = 0;

		q.offer(new team(x, y));
		visit[y][x] = true;
		while(!q.isEmpty()) {
			team t = q.poll();
			cnt1++;
			for(int i=0; i<4; i++) {
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(board[ny][nx].equals("B") && !visit[ny][nx]) {
						q.offer(new team(nx, ny));

						visit[ny][nx] = true;
					}
				}
			}
		}
		count1.add(cnt1);


	}
}