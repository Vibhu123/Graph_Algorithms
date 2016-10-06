
public class MColoringProblem {

	static int V=4;
	public static boolean isSafe(int v,int graph[][],int color[],int c)
	{
		for(int i=0;i<V;i++)
		{
			if(graph[v][i]==1&&c==color[i])
				return false;
		}
		return true;
	}
	public static boolean mColorUtil(int graph[][],int color[],int m,int v)
	{
		if(v==V)
			return true;
		for(int c=1;c<=m;c++)
		{
			if(isSafe(v,graph,color,c))
			{
				color[v]=c;
				if(mColorUtil(graph,color,m,v+1))
					return true;
				color[v]=0;
			}
		}
		return false;
	}
	public static void printSolution(int[] color)
	{
		for(int i=0;i<color.length;i++)
		{
			System.out.print(color[i]+" ");
		}
	}
	public static void mColor(int graph[][],int m)
	{
		int color[]=new int[V];
		for(int i=0;i<V;i++)
		{
			color[i]=0;
		}
		if(mColorUtil(graph,color,m,0)==false)
		{
			System.out.println("Solution does not exist");
			return;
		}
		printSolution(color);
		return;
	}
	public static void main(String[] args)
	{
		int graph[][]={{0,1,1,1},{1,0,1,0},{1,1,0,1},{1,0,1,0}};
		int m=3;
		mColor(graph, m);
	}
}
