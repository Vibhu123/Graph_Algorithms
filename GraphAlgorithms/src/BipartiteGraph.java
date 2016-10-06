import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class BipartiteGraph {

	int V;
	ArrayList<Integer>[] adj;
	public BipartiteGraph(int v) {
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
	public boolean checkBipartite(int color[],int src)
	{
		color[src]=1;
		Queue<Integer> q1=new LinkedList<Integer>();
		q1.add(src);
		while(!q1.isEmpty())
		{
			int first=q1.poll();
			Iterator<Integer> itr=adj[first].iterator();
			while(itr.hasNext())
			{
				int next=itr.next();
				if(color[next]==-1)
				{
					color[next]=1-color[first];
					q1.add(next);
				}
				else if(color[next]==color[first])
				{
					return false;
				}
				
			}
		}
		return true;
	}
	public static void main(String[] args)
	{
		BipartiteGraph bg=new BipartiteGraph(4);
		bg.addEdge(0, 1);
		bg.addEdge(0, 3);
		bg.addEdge(1, 0);
		bg.addEdge(1, 2);
		bg.addEdge(2, 1);
		bg.addEdge(2, 3);
		bg.addEdge(3, 0);
		bg.addEdge(3, 2);
		int color[]=new int[bg.V];
		for(int i=0;i<color.length;i++)
			color[i]=-1;
		if(bg.checkBipartite(color, 0))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
