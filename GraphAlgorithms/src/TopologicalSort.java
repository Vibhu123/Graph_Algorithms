import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;


public class TopologicalSort {
	
	int V;
	ArrayList<Integer>[] adj;
	public TopologicalSort(int v) {
		// TODO Auto-generated constructor stub
		this.V=v;
		adj=new ArrayList[V];
		for(int i=0;i<V;i++)
		{
			adj[i]=new ArrayList<Integer>();
		}
	}
	public void addEdge(int v,int w)
	{
		adj[v].add(w);
	}
	public void topologicalSortUtil(int v,boolean visited[],Stack<Integer> s)
	{
		visited[v]=true;
		Iterator<Integer> itr=adj[v].iterator();
		while(itr.hasNext())
		{
			int w=itr.next();
			if(!visited[w])
				topologicalSortUtil(w, visited, s);
		}
		s.push(v);
	}
	public void topologicalSort()
	{
		Stack<Integer> s1=new Stack<Integer>();
		boolean visited[]=new boolean[V];
		for(int i=0;i<V;i++)
		{
			if(!visited[i])
				topologicalSortUtil(i,visited,s1);
		}
		while(!s1.isEmpty())
		{
			System.out.println(s1.pop());
		}
	}
	public static void main(String[] args)
	{
		TopologicalSort t1=new TopologicalSort(6);
		t1.addEdge(5, 2);
		t1.addEdge(5, 0);
		t1.addEdge(4, 0);
		t1.addEdge(4, 1);
		t1.addEdge(2, 3);
		t1.addEdge(3, 1);
		
		t1.topologicalSort();
	}
	
}
