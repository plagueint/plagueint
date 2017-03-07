package utils;

public class Euler implements Function{
	//Pour une fonction u donnée, on peut résoudre les équations u'(t)=f(t,u(t))
	
	//On a besoin  de:
	//On discrétise le pas temporel avec dt
	//On doit connaître l'intervalle temporel: [a,b]
	//u=(S,I,R)
	// u et du à l'instant 0 qui suivent ensuite les relations:
	//u=u+dt*du
	//du=f(t,u(t))
	
	public void EulerSolve(double dt,double a, double b, double u[],double du) 
	{
		u[0]=u[0]+dt*du[0];
		u[1]=u[1]+dt*du[1];
		u[2]=u[2]+dt*du[2];
		du=f(u);
	}
		
}
