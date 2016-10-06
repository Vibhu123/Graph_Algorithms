import java.util.ArrayList;
import java.util.ListIterator;


public class CycleUsingColor {

	int V;
	ArrayList<Integer>[] adj;
	public CycleUsingColor(int v) {
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
	public boolean DFSUti(int u,String color[])
	{
		color[u]="GRAY";//being visited
		ListIterator<Integer> itr=adj[u].listIterator();
		while(itr.hasNext())
		{
			int v=itr.next();
			if(color[v].contentEquals("GRAY"))//has a back edge
				return true;
			if(color[v].contentEquals("WHITE")&&DFSUti(v, color))//if not explored then check if explored then it might contain cycle
				return true;
		}
		color[u]="BLACK";//mark it as done, both descendants and it has been checked
		return false;
	}
	public boolean cycleDFS()
	{
		String color[]=new String[V];
		for(int i=0;i<color.length;i++)
			color[i]="WHITE";
		for(int i=0;i<V;i++)
		{
			if(color[i].contentEquals("WHITE"))
			{
				if(DFSUti(i, color))
					return true;
			}
		}
		return false;
	}
	
}
