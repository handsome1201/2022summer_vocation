import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class loca{
	int x, y;

	public loca(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
}


public class a_0702 {
	static int[][] node;
	static boolean[][] visited;
	static int count;
	static int w, h, nowX, nowY;
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true)
		{
			//INPUT		
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) break;
			
			node = new int[h][w];
			visited = new boolean[h][w];
			int cnt = 0;
			for(int i=0;i<h;i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++)
				{
					node[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<h;i++)
			{
				for(int j=0;j<w;j++)
				{
					if(!visited[i][j] && node[i][j] == 1)
					{
						bfs(i,j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append('\n');
		}
		System.out.println(sb);
	}
	public static void bfs(int N,int M) {
		Queue<loca> q = new LinkedList<>();
		q.offer(new loca(M,N));
		visited[N][M]=true;

		while(!q.isEmpty()) {
			loca lo1 = q.poll();


			for(int i=0;i<8;i++) {
				int xx = lo1.getX()+dx[i];
				int yy = lo1.getY()+dy[i];

				if(yy>=h || yy<0 || xx>=w || xx < 0) {
					continue;
				}
				if(visited[yy][xx]) {
					continue;
				}
				if(node[yy][xx]==1 && !visited[yy][xx]) {
					visited[yy][xx]=true;
					q.offer(new loca(xx,yy));

				}
			}
		}
	}

}
