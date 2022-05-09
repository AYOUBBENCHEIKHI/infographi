import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;

import graphe3D.Cub3D;
import graphe3D.ProuduitMatriciel;

public class exament {

	public exament() {
		// TODO Auto-generated constructor stub
	}
	//transformation en int et multiplier par 100
		public int[][] doubleToInt(double T[][]){
			int MT[][]= new int[8][4];
			for(int i = 0;i<T.length;i++) {
				for(int j = 0; j<T[i].length;j++) {
					MT[i][j] = (int) (T[i][j]*100);
				}
			}
			 return MT;
			
		}
		public int[][] doubleToIntBS(double T[][]){
			int MT[][]= new int[10][4];
			for(int i = 0;i<T.length;i++) {
				for(int j = 0; j<T[i].length;j++) {
					MT[i][j] = (int) (T[i][j]);
				}
			}
			 return MT;
			
		}
		//roper 
		 public void reper(Graphics g) {
			 Graphics2D g2 = (Graphics2D) g;
			 g2.draw ((Shape) new Line2D.Double(0,300,640,300));
			g2.draw ((Shape) new Line2D.Double(320,0,320,480));
		 }
		
		public void extraction(int T[][],int TX[],int TY[]) {
			for(int i = 0;i<8;i++) {
			  
				 TX[i] = T[i][0];
				 TY[i] = T[i][1];
				
			}
		}
		

	public void tracer(int TX[],int TY[],Graphics  g) {
		//A------->B
		g.drawLine(TX[0]+320,300-TY[0],TX[1]+320,300-TY[1]);
		//B------->C
		g.drawLine(TX[1]+320,300-TY[1],TX[2]+320,300-TY[2]);
		//C------->D
		g.drawLine(TX[2]+320,300-TY[2],TX[3]+320,300-TY[3]);
		//D------->A
		g.drawLine(TX[3]+320,300-TY[3],TX[0]+320,300-TY[0]);
		//E------->F
		g.drawLine(TX[4]+320,300-TY[4],TX[5]+320,300-TY[5]);
		//F------->G
		g.drawLine(TX[5]+320,300-TY[5],TX[6]+320,300-TY[6]);
		//E------->H
		g.drawLine(TX[4]+320,300-TY[4],TX[7]+320,300-TY[7]);
		//H------->G
		g.drawLine(TX[7]+320,300-TY[7],TX[6]+320,300-TY[6]);
		//A------->E
		g.drawLine(TX[0]+320,300-TY[0],TX[4]+320,300-TY[4]);
		//B------->F
		g.setColor(Color.red);
		g.drawLine(TX[1]+320,300-TY[1],TX[5]+320,300-TY[5]);
		//D------->H
		g.setColor(Color.red);
		g.drawLine(TX[3]+320,300-TY[3],TX[7]+320,300-TY[7]);
		//C------->G
		g.setColor(Color.black);
		g.drawLine(TX[2]+320,300-TY[2],TX[6]+320,300-TY[6]);
		
		
		g.drawString("A",TX[0]+320+6,300-TY[0]);
		g.drawString("B",TX[1]+320+6,300-TY[1]);
		g.drawString("C",TX[2]+320,300-TY[2]);
		g.drawString("D",TX[3]+320,300-TY[3]);
		g.drawString("E",TX[4]+320,300-TY[4]);
		g.drawString("F",TX[5]+320,300-TY[5]);
		g.drawString("G",TX[6]+320,300-TY[6]);
		g.drawString("H",TX[7]+320,300-TY[7]);
		}
	
	public  double[][] aligne(double[][] M,double a,double b ,double c,double a1,double b1 ,double c1) throws Exception{
		double A = Math.sqrt(a*a+b*b+c*c);
		double B = Math.sqrt(b*b+c*c);
		 double T[][] = {{(B/A),0,(a/A),0},
						{(-(a*b)/(A*B)),(c/B),(b/A),0},
						{(-(c*a)/(A*B)),(-b/B),(c/A),0},
						{0,0,0,1}};
		 
		 double A1 = Math.sqrt(a1*a1+b1*b1+c1*c1);
		 double B1 = Math.sqrt(b1*b1+c1*c1);
		 double TI[][] = {{(B1/A1),(-(a1*b1)/(A1*B1)),(-(c1*a1)/(A1*B1)),0},
						 {0,(c1/B1),(-b1/B1),0},
						 {(a1/A1),(b1/A1),(c1/A1),0},
						 {0,0,0,1}};
		
		 //double M[][] = {{a,b,c,1}};
		/* double M[][] = {{0,0,0,1},
					{3,0,0,1},
					{3,2,0,1},
					{0,2,0,1},
					{0,0,1,1},
					{3,0,1,1},
					{3,2,1,1},
					{0,2,1,1}};*/
		 double M1[][] = {{a1,b1,c1,1}};
		 double MT[][] = null;	
		 double MT1[][] = null;
		 double MP[][] = null;
		 Cub3D cub =new Cub3D();
		 MP=cub.translationXYZ(M, 0,-2,0);
		 
		 
		MT = ProuduitMatriciel.produit(T,TI);
		MT1 = ProuduitMatriciel.produit(M,MT);
		return MT1;
		
	}
	public  double[][] rotaionZ( double M[][]){
		 double R[][] ={{0,1,0,0},
						{-1,0,0,0},
						{0,0,1,0},
						{0,0,0,1}};
		 double MTR[][] = null;
		 double TR[][] = null;
		 double TIT[][] = null;
		try {
			
			MTR = ProuduitMatriciel.produit(M,R);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return MTR;
		
	}
	public  double[][] rotaionZSy( double M[][]){
		 double R[][] ={{Math.sqrt(2)/2,Math.sqrt(2)/2,0,0},
						{-Math.sqrt(2)/2,Math.sqrt(2)/2,0,0},
						{0,0,1,0},
						{0,0,0,1}};
		 double MTR[][] = null;
		 double TR[][] = null;
		 double TIT[][] = null;
		try {
			
			MTR = ProuduitMatriciel.produit(M,R);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return MTR;
		
	}
	public  double[][] rotaionZA( double M[][],double x){
		 double R[][] ={{Math.cos(x),-Math.sin(x),0,0},
						{Math.sin(x),Math.cos(x),0,0},
						{0,0,1,0},
						{0,0,0,1}};
		 double MTR[][] = null;
		 double TR[][] = null;
		 double TIT[][] = null;
		try {
			
			MTR = ProuduitMatriciel.produit(M,R);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return MTR;
		
	}
	public  double[][] symetriqueParapporAxe( double M[][],String axe,int x,int y) throws Exception {
		//Tx les coordonnes de x et tY les coordone de y
		 double MT[][] = null;
		if(axe.equals("xy")) {
			x = 0;
			y = 0;
			 double T[][] ={{1,0,0,0},
						{0,1,0,0},
						{0,0,-1,0},
						{0,0,0,1}};
			MT = ProuduitMatriciel.produit(M,T);
			return MT;
		}
		else if(axe.equals("xz")) {
			x = 0;
			y = 0;
			 double T[][] ={{1,0,0,0},
							{0,-1,0,0},
							{0,0,1,0},
							{0,0,0,1}};
			MT = ProuduitMatriciel.produit(M,T);
			return MT;
			
		}
		else if(axe.equals("yz")) {
			x = 0;
			y = 0;
			 double T[][] ={{-1,0,0,0},
						{0,1,0,0},
						{0,0,1,0},
						{0,0,0,1}};
			MT = ProuduitMatriciel.produit(M,T);
			return MT;
		}
		else if(axe.equals("ql")) {
			 double TT[][] =  {{1,0,0,0},
							{0,1,0,0},
							{0,0,1,0},
							{-x,-y,0,1}}; 
			 double TTI[][] = {{1,0,0,0},
							{0,1,0,0},
							{0,0,1,0},
							{x,y,0,1}}; 
			 int cx = 0,cy = 0;
			 
			 if(x != 0) {
				 cx = -1;
				 cy = 1;
			 }
			 if(y != 0) {
				 cx = 1;
				 cy = -1;
			 }
			 double T[][] =  {{cx,0,0,0},
							{0,cy,0,0},
							{0,0,1,0},
							{0,0,0,1}};
			 double P[][] = null ;
			 double PR[][] = null;
			 
			 P = ProuduitMatriciel.produit(TT,T);
			 PR = ProuduitMatriciel.produit(P,TTI);
 			MT = ProuduitMatriciel.produit(M,PR);
 			
			return MT;
			
		}
		//
		return null;
	}
	public double[] bSplin(double t) {
		double T[]=new double[4];
		T[0]=300*t*Math.pow((1-t),2)+200*((2*Math.pow(t,2)+t)*(1-t))+300*Math.pow(t,3);
		T[1]=0;
		T[2]=300*t*Math.pow((1-t),2)+50*((2*Math.pow(t,2)+t)*(1-t))+100*Math.pow(t,3);
		T[3]=1;
		return T;
	}

}
