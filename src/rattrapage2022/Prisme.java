package rattrapage2022;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;

import graphe3D.ProuduitMatriciel;

public class Prisme {

	public Prisme() {
		// TODO Auto-generated constructor stub
	}
	//transformation en int et multiplier par 100
	public int[][] doubleToInt(double T[][]){
		int MT[][]= new int[7][4];
		for(int i = 0;i<T.length;i++) {
			for(int j = 0; j<T[i].length;j++) {
				MT[i][j] = (int) (T[i][j]*50);
			}
		}
		 return MT;
		
	}
	//roper 
	 public void reper(Graphics g) {
		 Graphics2D g2 = (Graphics2D) g;
		 g2.draw ((Shape) new Line2D.Double(0,240,640,240));
		g2.draw ((Shape) new Line2D.Double(320,0,320,480));
	 }
	
	public void extraction(int T[][],int TX[],int TY[]) {
		for(int i = 0;i<6;i++) {
		  
			 TX[i] = T[i][0];
			 TY[i] = T[i][1];
			
		}
	}
	
	//projection cavalier 
	public  double[][] projectionCavalier( double M[][]){
		 double T[][] ={{1,0,0,0},
					    {0,1,0,0},
					    {0.5*(Math.sqrt(2)/2),0.5*(Math.sqrt(2)/2),0,0},
					    {0,0,0,1}};
		
		 double MT[][] = null;
		try {
			MT = ProuduitMatriciel.produit(M, T);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return MT;
		
	}
	//projection perspective sur un plan qlq 
	public double[][] projectionPerspectivePlanQlq( double M[][],double a,double b,double c,
					double n1,double n2,double n3,double x0,double y0,double z0)
					throws Exception{
		 double MTR[][] = new  double[6][4];
		 double d0= n1*x0+n2*y0+n3*z0;
		 double d1= n1*a+n2*b+n3*c;
		 double T[][] ={{1+(a*n1)/d0,(b*n1)/d0,(c*n1)/d0,n1/d0},
						{(a*n2)/d0,	1+(b*n2)/d0,(c*n2)/d0,n2/d0},
						{(a*n3)/d0,	(b*n3)/d0,	1+(c*n3)/d0,n3/d0},
						{-a-(a*d1)/d0,-b-(b*d1)/d0,-c-(c*d1)/d0,-(d1/d0)}};
			 double TR[][] = null;
			 double TIT[][] = null;
			TR = ProuduitMatriciel.produit(M,T);
			for (int i=0;i<6;i++) {
				for(int j =0;j<4;j++) {
					MTR[i][j] = TR[i][j]/TR[i][3];
				}
			}
		return MTR;
	}
	public void tracer(int TX[],int TY[],Graphics  g) {
		//A------->B
		g.drawLine(TX[0]+320,240-TY[0],TX[1]+320,240-TY[1]);
		//A------>c
		g.drawLine(TX[0]+320,240-TY[0],TX[2]+320,240-TY[2]);
		//D------->A
		g.drawLine(TX[3]+320,240-TY[3],TX[0]+320,240-TY[0]);
		//B------->C
		g.drawLine(TX[1]+320,240-TY[1],TX[2]+320,240-TY[2]);
		//E------->F
		g.drawLine(TX[4]+320,240-TY[4],TX[5]+320,240-TY[5]);
		//D------->E
		g.drawLine(TX[3]+320,240-TY[3],TX[4]+320,240-TY[4]);
		//D------->F
		g.drawLine(TX[3]+320,240-TY[3],TX[5]+320,240-TY[5]);
		//E------->B
		g.drawLine(TX[4]+320,240-TY[4],TX[1]+320,240-TY[1]);
		//C------->F
		g.drawLine(TX[2]+320,240-TY[2],TX[5]+320,240-TY[5]);
		
		
		g.drawString("A",TX[0]+320+6,240-TY[0]);
		g.drawString("B",TX[1]+320+6,240-TY[1]);
		g.drawString("C",TX[2]+320,240-TY[2]);
		g.drawString("D",TX[3]+320,240-TY[3]);
		g.drawString("E",TX[4]+320,240-TY[4]);
		g.drawString("F",TX[5]+320,240-TY[5]);
	}
	
	public void tracerPlan(int TX[],int TY[],Graphics  g) {
		//A------->B
		g.setColor(Color.red);
		g.drawLine(TX[0]+320,240-TY[0],TX[1]+320,240-TY[1]);
		//A------>c
		g.setColor(Color.black);
		g.drawLine(TX[0]+320,240-TY[0],TX[2]+320,240-TY[2]);
		//D------->A
		g.setColor(Color.red);
		g.drawLine(TX[3]+320,240-TY[3],TX[0]+320,240-TY[0]);
		//B------->C
		g.setColor(Color.black);
		g.drawLine(TX[1]+320,240-TY[1],TX[2]+320,240-TY[2]);
		//E------->F
		g.drawLine(TX[4]+320,240-TY[4],TX[5]+320,240-TY[5]);
		//D------->E
		g.setColor(Color.red);
		g.drawLine(TX[3]+320,240-TY[3],TX[4]+320,240-TY[4]);
		//D------->F
		g.setColor(Color.black);
		g.drawLine(TX[3]+320,240-TY[3],TX[5]+320,240-TY[5]);
		//E------->B
		g.setColor(Color.red);
		g.drawLine(TX[4]+320,240-TY[4],TX[1]+320,240-TY[1]);
		//C------->F
		g.setColor(Color.black);
		g.drawLine(TX[2]+320,240-TY[2],TX[5]+320,240-TY[5]);
		
		
		g.drawString("A",TX[0]+320+6,240-TY[0]);
		g.drawString("B",TX[1]+320+6,240-TY[1]);
		g.drawString("C",TX[2]+320,240-TY[2]);
		g.drawString("D",TX[3]+320,240-TY[3]);
		g.drawString("E",TX[4]+320,240-TY[4]);
		g.drawString("F",TX[5]+320,240-TY[5]);
	}
	
	public  double[][] rotaionZ( double M[][]){
		 double R[][] ={{2/Math.sqrt(13),3/Math.sqrt(13),0,0},
						{-3/Math.sqrt(13),2/Math.sqrt(13),0,0},
						{0,0,1,0},
						{0,0,0,1}};

		 double MTR[][] = null;
		try {
			MTR = ProuduitMatriciel.produit(M,R);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return MTR;
		
	}
	public  double[][] rotaionY( double M[][]){
		 double R[][] ={{Math.cos(45),0,-Math.sin(45),0},
				 		{0,1,0,0},
						{Math.sin(45),0,Math.cos(45),0},
						{0,0,0,1}};

		 double MTR[][] = null;
		try {
			MTR = ProuduitMatriciel.produit(M,R);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return MTR;
		
	}
	public  double[][] rotaionZMoin( double M[][]){
		 double R[][] ={{2/Math.sqrt(13),-3/Math.sqrt(13),0,0},
						{3/Math.sqrt(13),2/Math.sqrt(13),0,0},
						{0,0,1,0},
						{0,0,0,1}};

		 double MTR[][] = null;
		try {
			MTR = ProuduitMatriciel.produit(M,R);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return MTR;
		
	}
	//le courbe de bizier
	
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
		double[] p =new double[4];
		int n = pt.length;
		for(int j = 0;j<pt.length;j++) {
				p[0] = p[0] + pt[j][0]*this.fIBern(n-1, j, T);
				p[1] = p[1] + pt[j][1]*this.fIBern(n-1, j, T);
				p[2] = p[2] + pt[j][2]*this.fIBern(n-1, j, T);
				p[3]=1;
		}
		
		return p;
	}

}
