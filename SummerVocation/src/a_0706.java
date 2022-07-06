import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class locatio{
	int x, y;

	public locatio(int x,int y) {
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
public class a_0706 {
	static int n,m,k,count;
	static int[][] node;
	static int[] dx = {1, 0 , -1, 0};       // ªÛ«œ¡¬øÏ ∞ËªÍ«“ x¡¬«•
	static int[] dy = {0, 1, 0, -1};        // ªÛ«œ¡¬øÏ ∞ËªÍ«“ y¡¬«•
	static ArrayList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line =br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		node = new int[m][n];

		for(int t=0;t<k;t++) {
			line =br.readLine();
			st = new StringTokenizer(line);
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for(int i=y1;i<y2;i++) {
				for(int j=x1;j<x2;j++) {
					node[i][j]=1;
				}
			}
		}
		
		list = new ArrayList<Integer>();
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(node[i][j]==0) {
					count=0;
					dfs(j,i);
					list.add(count);
				}
			}
		}

		System.out.println(list.size());
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	static void dfs(int x,int y) {
		node[y][x]=1;
		count++;
		
		for(int i=0;i<4;i++) {
			int xx=x+dx[i];
			int yy= y+dy[i];
			
			if(xx<0 || yy<0 || xx>=n || yy>=m) {
				continue;
			}
			if(node[yy][xx]==0) {
				dfs(xx,yy);
			}
		}
	}
}
