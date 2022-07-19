import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node{
	int son;
	int length;
	public Node(int son, int length) {
		this.son = son;
		this.length = length;
	}
}


public class a_0719 {
	static ArrayList<Node> list[];
	static int max = 0;
	static boolean visited[];
	static int max_idx = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		list=new ArrayList[n+1];


		for(int i = 0 ; i < n+1; i++){
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<n-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int mom = Integer.parseInt(st.nextToken());
			int son = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			list[mom].add(new Node(son,length));
			list[son].add(new Node(mom,length));
		}	
		visited[1] = true;
		dfs(1,0);


		visited = new boolean[n+1];
		visited[max_idx] = true;
		dfs(max_idx,0);
		System.out.println(max);
	}

	static void dfs(int a, int b) {
		if(max<b) {
			max=b;
			max_idx=a;
		}
		for(Node next : list[a]){
			if(visited[next.son]) continue;

			visited[next.son] = true;
			dfs(next.son, b + next.length);
		}
	}
}
