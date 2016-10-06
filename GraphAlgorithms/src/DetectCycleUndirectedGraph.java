import java.util.ArrayList;
import java.util.Iterator;


public class DetectCycleUndirectedGraph {

	int V;
	ArrayList<Integer>[] adj;
	public DetectCycleUndirectedGraph(int v) {
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
	public boolean isCycleUtil(int v,boolean visited[],int parent)
	{
		visited[v]=true;
		int i;
		Iterator<Integer> itr=adj[v].iterator();
		while(itr.hasNext())
		{
			i=itr.next();
			if(!visited[i])
			{
				if(isCycleUtil(i, visited, v))
					return true;
			}
			else if(i!=parent)
				return true;
		}
		return false;
	}
	public boolean isCycle()
	{
		boolean visited[]=new boolean[V];
		for(int i=0;i<V;i++)
		{
			if(!visited[i])
				if(isCycleUtil(i,visited,-1))
					return true;
		}
		return false;
	}
	
}
