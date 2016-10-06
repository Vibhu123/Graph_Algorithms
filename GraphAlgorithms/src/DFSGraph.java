import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;


public class DFSGraph {

	int V;
	LinkedList<Integer>[] adj;
	DFSGraph(int v)
	{
		V=v;
		adj=new LinkedList[V];
		for(int i=0;i<V;i++)
		{
			adj[i]=new LinkedList<Integer>();
		}
	}
	public void addEdge(int v,int w)
	{
		adj[v].add(w);
	}
	public void DFSUtil(int v,boolean visited[])
	{
		System.out.println("Visiting "+v);
		visited[v]=true;
		
			ListIterator<Integer> itr=adj[v].listIterator();
			while(itr.hasNext())
			{
				int w=itr.next();
				if(!visited[w])
					DFSUtil(w,visited);
			}
		
	}
	public void DFSStack(int v)
	{
		boolean visited[]=new boolean[V];
		Stack<Integer> s1=new Stack<Integer>();
		s1.push(v);
		visited[v]=true;
		while(!s1.isEmpty())
		{
			int item=s1.pop();
			System.out.println("Visiting "+item);
			Iterator<Integer> itr=adj[item].iterator();
			while(itr.hasNext())
			{
				int elem=itr.next();
				if(!visited[elem])
				{
					visited[elem]=true;
					s1.push(elem);
				}
				
			}
		}
	}
	public void DFS(int v)
	{
		boolean visited[]=new boolean[V];
		DFSUtil(2,visited);
	}
	public void DFS()
	{
		boolean[] visited=new boolean[V];
		//for a disconnected graph visit all the vertices
		for(int i=0;i<V;i++)
		{
			if(!visited[i])
				DFSUtil(i,visited);
		}
	}
	public static void main(String[] args)
	{
		DFSGraph dfs=new DFSGraph(5);
		dfs.addEdge(1, 0);
		dfs.addEdge(0, 2);
		dfs.addEdge(2, 1);
		dfs.addEdge(0, 3);
		dfs.addEdge(3, 4);
		dfs.addEdge(4, 0);
		dfs.DFSStack(0);
	}
	
	
}
