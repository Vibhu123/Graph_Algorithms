import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;


public class SCCAlgo {

	int V;
	ArrayList<Integer>[] adj;
	SCCAlgo(int v)
	{
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
	public void fillStack(int v,boolean visited[],Stack<Integer> s1)
	{
		visited[v]=true;
		Iterator<Integer> itr=adj[v].iterator();
		while(itr.hasNext())
		{
			int next=itr.next();
			if(!visited[next])
				fillStack(next, visited, s1);
		}
		s1.push(v);
	}
	public ArrayList<Integer>[] getTranspose()
	{
		ArrayList<Integer>[] transp=new ArrayList[adj.length];
		for(int i=0;i<transp.length;i++)
		{
			transp[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<V;i++)
		{
			Iterator<Integer> itr=adj[i].iterator();
			while(itr.hasNext())
			{
				transp[itr.next()].add(i);
			}
		}
		return transp;
	}
	public void DFSUtil(int v,ArrayList<Integer>[] transp,boolean visited[])
	{
		visited[v]=true;
		System.out.print(v+" ");
		Iterator<Integer> itr=transp[v].iterator();
		while(itr.hasNext())
		{
			int w=itr.next();
			if(!visited[w])
				DFSUtil(w, transp, visited);
		}
	}
	public void printAllSCCs()
	{
		Stack<Integer> s1=new Stack<Integer>();
		boolean visited[]=new boolean[V];
		for(int i=0;i<V;i++)
		{
			if(!visited[i])
				fillStack(i,visited,s1);
		}
		ArrayList<Integer>[] transp=getTranspose();
		visited=new boolean[V];
		while(!s1.isEmpty())
		{
			int v=s1.pop();
			if(!visited[v])
			{
				DFSUtil(v, transp, visited);
				System.out.println();
			}
		}
	}
	public static void main(String[] args)
	{
		SCCAlgo sc=new SCCAlgo(5);
		sc.addEdge(1, 0);
		sc.addEdge(0, 2);
		sc.addEdge(2, 1);
		sc.addEdge(0, 3);
		sc.addEdge(3, 4);
		
		sc.printAllSCCs();
	}
	
}
