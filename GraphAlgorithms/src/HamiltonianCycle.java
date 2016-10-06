
public class HamiltonianCycle {

	int V;
	int[] path;
	public HamiltonianCycle(int v) {
		// TODO Auto-generated constructor stub
		this.V=v;
		path=new int[V];
	}
	public boolean isSafe(int i,int path[],int graph[][],int pos)
	{
		if(graph[path[pos-1]][i]==0)
			return false;
		for(int j=0;j<pos;j++)
			if(path[j]==i)
				return false;
		return true;		
	}
	public boolean hamCycleUtil(int path[],int graph[][],int pos)
	{
		if(pos==V)
		{
			if(graph[path[pos-1]][path[0]]==1)
				return true;
			return false;
		}
		for(int i=1;i<V;i++)
		{
			if(isSafe(i,path,graph,pos))
			{
				path[pos]=i;
				if(hamCycleUtil(path, graph, pos+1)==true)
					return true;
				path[pos]=-1;
			}
		}
		return false;
	}
	public void hamCycle(int graph[][])
	{
		for(int i=0;i<V;i++)
			path[i]=-1;
		path[0]=0;
		if(hamCycleUtil(path,graph,1)==false)
		{
			System.out.println("Solution does not exist");
			return;
		}
		return;
	}
	
	public static void main(String[] args)
	{
		HamiltonianCycle hc=new HamiltonianCycle(5);
		
	}
	
}
