package Courbes;

public class CourbeBernsten {

	public CourbeBernsten() {
		/*double[] b0 = {1,1};
		double[] b1 = {2,3};
		double[] b2 = {4,3};
		double[] b3 = {3,1};
		double Point[][] = {b0,b1,b2,b3};
		double[][] p =new double[7][2];
		p[0]=this.polynomBern(Point, 0);
		p[1]=this.polynomBern(Point, 0.15);
		p[2]=this.polynomBern(Point, 0.35);
		p[3]=this.polynomBern(Point, 0.50);
		p[4]=this.polynomBern(Point, 0.65);
		p[5]=this.polynomBern(Point, 0.85);
		p[6]=this.polynomBern(Point, 1);
		
		for(int i=0;i<7;i++) {
			System.err.println("["+p[i][0]+","+p[i][1]+"]");
		}*/
		
	}

	public double factoriel(double n) {
		if(n <=0) {
			return 1;
		}
		else {
			return factoriel(n-1)*n;
		}
	}
	public double combunison(double n,double k) {
		return (this.factoriel(n)/(this.factoriel(k)*this.factoriel((n-k))));
	}
	
	public double fIBern(double n,double k,double t) {
		return (this.combunison(n,k)*Math.pow(t,k)*Math.pow((1-t),(n-k)));
	}
	
	public double[] polynomBern(double pt[][],double T) {
		double[] p =new double[2];
		int n = pt.length;
		for(int j = 0;j<pt.length;j++) {
				p[0] = p[0] + pt[j][0]*this.fIBern(n-1, j, T);
				p[1] = p[1] + pt[j][1]*this.fIBern(n-1, j, T);
		}
		
		return p;
	}
	
	public double[] Bsplin(double pt[][],double T) {
		double[] p =new double[3];
		int n = pt.length;
		for(int j = 0;j<pt.length;j++) {
				p[0] = p[0] + pt[j][0]*this.fIBern(n-1, j, T);
				p[1] = p[1] + pt[j][1]*this.fIBern(n-1, j, T);
				p[2] = p[2] + pt[j][2]*this.fIBern(n-1, j, T);
		}
		
		return p;
	}
	/*public static void main(String[] args) {
	
		new CourbeBernsten();

	}*/

}
