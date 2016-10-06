import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;


public class BFSGraph {

	int V;
	LinkedList<Integer>[] adj;
	BFSGraph(int V)
	{
		this.V=V;
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
	public void BFS(int s)
	{
		boolean visited[]=new boolean[V];
		visited[s]=true;
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(s);
		while(queue.size()!=0)
		{
			int v=queue.poll();
			System.out.println("Visiting "+v);
			ListIterator<Integer> itr=adj[v].listIterator();
			while(itr.hasNext())
			{
				int w=itr.next();
				if(!visited[w])
				{
					visited[w]=true;
					queue.add(w);
				}
			}
		}
	}
	public static void main(String[] args)
	{
		BFSGraph g=new BFSGraph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);	
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		g.BFS(2);
	}
}
