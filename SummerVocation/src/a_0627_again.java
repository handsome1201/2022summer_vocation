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

		visited=new boolean[n+1][m+1]; //방문 여부 확인

		Queue<location> q = new LinkedList<>();
		q.offer(new location(1, 1)); //시작 위치를 q에 넣어줌
		
		visited[1][1]=true;
		int[] width= {1,0,-1,0};
		int[] heigth= {0,1,0,-1}; //상하좌우 위치 값 확인 값

		while(!q.isEmpty()) {
			location lo = q.poll(); //q에서 값을 꺼내서 해당 위치 값 확인
			for(int i=0;i<4;i++) {
				int xx = lo.x+width[i]; //좌우 값 확인
				int yy=lo.y+heigth[i]; //상하 값 확인
				if(xx>0 && yy>0 && xx<=m && yy<=n) { //상하좌우 값이 해당 2차원 배열을 넘어서지 않을때(경계면) 
					if(graph[yy][xx]!=0 && !visited[yy][xx]) { //해당 위치의 값이 0이 아니고 방문한 곳이 아니라면
						visited[yy][xx] = true; //방문한걸로 바꿈
						graph[yy][xx]=graph[lo.y][lo.x]+1; //이전위치값에서 1을 더해줌
						q.add(new location(xx, yy));//q에 넣어줌
					}
				}
			}
		}
		System.out.println(graph[n][m]);//맨 마지막 위치 값 출력

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
