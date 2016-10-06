import java.util.ArrayList;
import java.util.Iterator;


public class DetectCycle {
	
	int V;
	ArrayList<Integer>[] adj;
	
	public DetectCycle(int V)
	{
		this.V=V;
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
	public boolean isCycle(int v,boolean visited[],boolean recStack[])
	{
		if(visited[v]==false)
		{
			visited[v]=true;
			recStack[v]=true;
			Iterator<Integer> itr=adj[v].iterator();
			while(itr.hasNext())
			{
				int w=itr.next();
				if(!visited[w]&&isCycle(w, visited, recStack))
					return true;
				else if(recStack[w])
					return true;
			}
		}
		recStack[v]=false;
		return false;
	}
	public boolean isCyclic()
	{
		boolean visited[]=new boolean[V];
		boolean recStack[]=new boolean[V];
		for(int i=0;i<V;i++)
		{
			if(isCycle(i, visited, recStack))
				return true;
		}
		return false;
	}
	public static void main(String[] args)
	{
		DetectCycle dc=new DetectCycle(4);
		dc.addEdge(0, 1);
		dc.addEdge(0, 2);
		dc.addEdge(1, 2);
		dc.addEdge(2, 0);
		dc.addEdge(2, 3);
		dc.addEdge(3, 3);
		
		if(dc.isCyclic())
			System.out.println("Contains cycle");
		else
			System.out.println("Do not contain cycle");
	}

}
