package utils;

public class Euler{
	
	//Création d'une classe Tuple parce que Java c'est de la merde il retourne qu'un seul arguments
	public class Tuple<X,Y>{ //<X,Y> est puissant on ne décrit pas les types on peut metre X=int, Y=double --> fonction d'ordre supérieur
		  public final double[] x;
		  public final double[] y;
		  public Tuple(double[] x, double[] y) { 
		    this.x = x;
		    this.y = y;
		  }
	}

	//Pour une fonction u donnée, on peut résoudre les équations u'(t)=f(t,u(t))
	
	//On a besoin  de:
	//On discrétise le pas temporel avec dt
	//On doit connaître l'intervalle temporel: [a,b]
	//u=(S,I,R)
	// u et du à l'instant 0 qui suivent ensuite les relations:
	//u=u+dt*du
	//du=f(t,u(t))
	
	// La classe EulerSolve 
	public Tuple<double[],double[]> EulerSolve(double dt,double u[],double du[]) 
	{
		u[0]=u[0]+dt*du[0];
		u[1]=u[1]+dt*du[1];
		u[2]=u[2]+dt*du[2];
		du=f(u);
		return new Tuple(u,du);
	}
	
	
}
