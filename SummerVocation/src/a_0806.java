import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Go implements Comparable<Go>{
	int x, y,height;

	Go(int x, int y,int height){
		this.x = x;
		this.y = y;
		this.height = height;
	}
	@Override
	public int compareTo(Go o) {
		return o.height - this.height;
	}
}
public class a_0806 {
	static int N, M;
	static int[][] board;
	static boolean[][] visit;
	static int[][] count;
	static int[] dx = { 1, -1, 0, 0 };       // 상하좌우 계산할 x좌표
	static int[] dy = { 0, 0, -1, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		board = new int[N][M];
		count = new int[N][M];
		visit = new boolean[N][M];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		for(int i=0; i<N; i++) {
			for(int j=0;j<M;j++) {
				System.out.print(count[i][j]);
			}
			System.out.println();
		}
		System.out.println(count[N-1][M-1]);

	}
	static void bfs() {
		PriorityQueue<Go> q = new PriorityQueue<>();
		q.add(new Go(0,0,board[0][0])); //시작 위치를 q에 넣어줌
		count[0][0] = 1;
		int xx,yy;
		while(!q.isEmpty()) {
			Go lo = q.poll();
			for(int i=0;i<4;i++) {
				xx= lo.x + dx[i];
				yy= lo.y + dy[i];
				if(yy>=N || yy<0 || xx>=M || xx < 0) {
					continue;
				}
				if(board[lo.y][lo.x] <= board[yy][xx])
					continue;
				count[yy][xx] += count[lo.y][lo.x];
				if(visit[yy][xx])
					continue;

				visit[yy][xx] = true;
				q.offer(new Go(xx, yy, board[yy][xx]));
			}

		}
	}
}
