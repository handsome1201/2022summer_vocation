import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class No{
	int son;
	int length;
	public No(int son, int length) {
		this.son = son;
		this.length = length;
	}
}

public class a_0719_new {
	static ArrayList<No> li[];
	static int max = 0;
	static boolean visited[];
	static int max_idx = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		visited = new boolean[n+1];
		li=new ArrayList[n+1];
		for(int i = 0 ; i < n+1; i++){
			li[i] = new ArrayList<>();
		}
		for(int i=0;i<n-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int mom = Integer.parseInt(st.nextToken());
			int son = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			li[mom].add(new No(son,length));
			li[son].add(new No(mom,length));
		}

		visited[1] = true;
		dfs(1,0);

		visited = new boolean[n+1];
		visited[max_idx] = true;
		dfs(max_idx,0);
		System.out.println(max);
	}
	static void dfs(int a,int b) {
		if(max<b) {
			max=b;
			max_idx=a;
		}


		for(No node : li[a]){

			if(visited[node.son]) {
				continue;
			}
			else {
				visited[node.son]=true;
				dfs(node.son,b+node.length);
			}
		}
	}
}
