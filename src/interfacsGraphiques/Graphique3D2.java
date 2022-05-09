package interfacsGraphiques;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import graphe3D.Cub3D;
import graphe3D.ProuduitMatriciel;

public class Graphique3D2 extends JFrame {
	private static final long serialVersionUID = 1L;
	private PanelTranslation panelTranslation;
	private PanelRotaion panelRotaion;
	private PanelSymetrique panelSymetrique;
	private PanelAlignement panelAlignement;

	public Graphique3D2() {
		// TODO Auto-generated constructor stub
	}
	public Graphique3D2(String x) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Symetrique");
		setBounds(100, 100, 700, 600);
		setResizable(false);
		panelSymetrique = new PanelSymetrique(x);
		panelSymetrique.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelSymetrique);
		panelSymetrique.setLayout(null);
	}
	public Graphique3D2(int x,int y,int z) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Translation");
		setBounds(100, 100, 700, 600);
		setResizable(false);
		panelTranslation = new PanelTranslation(x, y, z);
		panelTranslation.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelTranslation);
		panelTranslation.setLayout(null);
	}
	 
	public Graphique3D2(double xd,double yd,double xf,double yf,double angle) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Rotation");
		setBounds(100, 100, 700, 600);
		setResizable(false);
			panelRotaion = new PanelRotaion(xd, yd,xf,yf,angle);
			panelRotaion.setBorder(new EmptyBorder(5, 5, 5, 5));
			panelRotaion.setBackground(Color.LIGHT_GRAY);
			setContentPane(panelRotaion);
			panelRotaion.setLayout(null);
		
		
	}
	public Graphique3D2(double a,double b,double c,double a1,double b1,double c1) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Alignement");
		setBounds(100, 100, 700, 600);
		setResizable(false);
		panelAlignement = new PanelAlignement(a,b,c,a1,b1,c1);
		panelAlignement.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelAlignement);
		panelAlignement.setLayout(null);
	}
	


	public class PanelTranslation extends JPanel{
		private static final long serialVersionUID = 1L;
		private int x;
		private int y;
		private int z;
		public PanelTranslation(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		@Override
		protected void paintChildren(Graphics g) {
			super.paintChildren(g);
			 double M[][] =	{{0,0,0,1},
							{1,0,0,1},
							{1,1,0,1},
							{0,1,0,1},
							{0,0,1,1},
							{1,0,1,1},
							{1,1,1,1},
							{0,1,1,1}};
			
			int txo[] = new int [8];
			int tyo[] = new int [8];
			int tx[] = new int [8];
			int ty[] = new int [8];
			int MMT [][] = new int[8][4];
			int MMT1 [][] = new int[8][4];
			double MPO[][] = null;
			double MP[][] = null;
			double MT[][] = null;
			Cub3D cub = new Cub3D();
			MPO = cub.projectionCavalier(M);
			MMT = cub.doubleToInt(MPO);
			cub.extraction(MMT, txo,tyo);
			cub.tracer(txo, tyo, g);
			cub.reper(g);
			
			
			MT = cub.translationXYZ(M,getX(),getY(),getZ());
			MP = cub.projectionCavalier(MT);
			MMT1 = cub.doubleToInt(MP);
			cub.extraction(MMT1,tx,ty);
			cub.tracer(tx, ty, g);
			
			
			
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getZ() {
			return z;
		}
		public void setZ(int z) {
			this.z = z;
		}
		
	}
	
	public class PanelRotaion extends JPanel{
		private static final long serialVersionUID = 1L;
		private double xd;
		private double yd;
		private double xf;
		private double yf;
		private double angle;
		
		public PanelRotaion() {
			
		}
		public PanelRotaion(double xd, double yd, double xf, double yf, double angle) {
			super();
			this.xd = xd;
			this.yd = yd;
			this.xf = xf;
			this.yf = yf;
			this.angle = angle;
		}

		
		@Override
		protected void paintChildren(Graphics g) {
			super.paintChildren(g);
			 double M[][] =	{{0,0,0,1},
							{1,0,0,1},
							{1,1,0,1},
							{0,1,0,1},
							{0,0,1,1},
							{1,0,1,1},
							{1,1,1,1},
							{0,1,1,1}};
			
			int tx[] = new int [8];
			int ty[] = new int [8];
			 double MP[][] = null;
			 double MT[][] = null;
			 int MMT[][] =new int [8][4];
			Cub3D cub = new Cub3D();
			
			MP = cub.projectionCavalier(M);
			MMT = cub.doubleToInt(MP);
			cub.extraction(MMT, tx,ty);
			cub.tracer(tx, ty, g);
			cub.reper(g);
			
			//g.setColor(Color.blue);
			MT = cub.rotaionAxeQuelquan(M,getXd(),getYd(), getXf(),getYf(), getAngle());
			
			MP = cub.projectionCavalier(MT);
			MMT = cub.doubleToInt(MP);
			cub.extraction(MMT,tx,ty);
			cub.tracer(tx, ty, g);
			
			double bita = getAngle()/10;
			while(bita < getAngle()) {
				g.setColor(Color.blue);
				MT = cub.rotaionAxeQuelquan(M,getXd(),getYd(), getXf(),getYf(), bita);
				MP = cub.projectionCavalier(MT);
				MMT = cub.doubleToInt(MP);
				cub.extraction(MMT,tx,ty);
				cub.tracer(tx, ty, g);
				cub.reper(g);
				bita = bita +getAngle()/10;
				
			}
			
			double x,y,xx,yy;
			x = getXd()*100;
			y=getYd()*100;
			xx = getXf()*100;
			yy=getYf()*100;
			g.setColor(Color.black);
			g.drawLine(320+((int)x),240-((int)y), 320+((int)xx),240-((int)yy));
			g.setColor(Color.red);
			MT = cub.rotaionAxeQuelquan(M,getXd(),getYd(), getXf(),getYf(), getAngle());
			MP = cub.projectionCavalier(MT);
			MMT = cub.doubleToInt(MP);
			cub.extraction(MMT,tx,ty);
			cub.tracer(tx, ty, g);
		
		}
		
		public double getXd() {
			return xd;
		}

		public void setXd(double xd) {
			this.xd = xd;
		}

		public double getYd() {
			return yd;
		}

		public void setYd(double yd) {
			this.yd = yd;
		}

		public double getXf() {
			return xf;
		}

		public void setXf(double xf) {
			this.xf = xf;
		}

		public double getYf() {
			return yf;
		}

		public void setYf(double yf) {
			this.yf = yf;
		}

		public double getAngle() {
			return angle;
		}

		public void setAngle(double angle) {
			this.angle = angle;
		}	
	}
	
	
	public class PanelAlignement extends JPanel{
		private static final long serialVersionUID = 1L;
		private double a;
		private double b;
		private double c;
		private double a1;
		private double b1;
		private double c1;
		public PanelAlignement() {
			super();
			// TODO Auto-generated constructor stub
		}
		public PanelAlignement(double a, double b, double c, double a1,double b1, double c1) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
			this.a1 = a1;
			this.b1 = b1;
			this.c1 = c1;
		}
		@Override
		protected void paintChildren(Graphics g) {
			super.paintChildren(g);
			 double M[][] =	{{getA(),getB(),getC(),1}};
			 double MP[][] = null;
			 double MT[][] = null;
			 int MMT[][] =new int [8][4];
			 
			 double M1[][] =	{{getA1(),getB1(),getC1(),1}};
			 double MP1[][] = null;
			 double MT1[][] = null;
			 int MMT1[][] =new int [8][4];
			 
			 
			    Cub3D cub = new Cub3D();
				cub.reper(g);
				
				MP = cub.projectionCavalier(M);
				MMT = cub.doubleToInt(MP);
				
				
				MP1 = cub.projectionCavalier(M1);
				MMT1 = cub.doubleToInt(MP1);
				g.setColor(Color.blue);
				g.drawString("VECTEUR V ",MMT[0][0]+325,245-MMT[0][1]);
				g.drawLine(0+320,240-0,MMT[0][0]+320,240-MMT[0][1]);
				g.setColor(Color.green);
				g.drawString("VECTEUR N ",MMT1[0][0]+325,245-MMT1[0][1]);
				g.drawLine(0+320,240-0,MMT1[0][0]+320,240-MMT1[0][1]);
			


				try {
					MT = cub.aligne(a, b, c,a1, b1, c1);
					MP = cub.projectionCavalier(MT);
					MMT = cub.doubleToInt(MP);
					g.setColor(Color.red);
					g.drawString("V aligne en N ",MMT[0][0]+325,245-MMT[0][1]);
					g.drawLine(0+320,240-0,MMT[0][0]+320,240-MMT[0][1]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
		public double getA() {
			return a;
		}
		public void setA(double a) {
			this.a = a;
		}
		public double getB() {
			return b;
		}
		public void setB(double b) {
			this.b = b;
		}
		public double getC() {
			return c;
		}
		public void setC(double c) {
			this.c = c;
		}
		public double getA1() {
			return a1;
		}
		public void setA1(double a1) {
			this.a1 = a1;
		}
		public double getB1() {
			return b1;
		}
		public void setB1(double b1) {
			this.b1 = b1;
		}
		public double getC1() {
			return c1;
		}
		public void setC1(double c1) {
			this.c1 = c1;
		}
			
	}
	public class PanelSymetrique extends JPanel{
		private static final long serialVersionUID = 1L;
		private String axe;
		
		public PanelSymetrique() {
			super();
			// TODO Auto-generated constructor stub
		}
		public PanelSymetrique(String axe) {
			super();
			this.axe = axe;
		}
		@Override
		protected void paintChildren(Graphics g) {
			super.paintChildren(g);
			 double M[][] =	{{0,0,0,1},
						{1,0,0,1},
						{1,1,0,1},
						{0,1,0,1},
						{0,0,1,1},
						{1,0,1,1},
						{1,1,1,1},
						{0,1,1,1}};

			 int tx[] = new int [8];
				int ty[] = new int [8];
				 double MP[][] = null;
				 double MT[][] = null;
				 int MMT[][] =new int [8][4];
				Cub3D cub = new Cub3D();
				
				MP = cub.projectionCavalier(M);
				MMT = cub.doubleToInt(MP);
				cub.extraction(MMT, tx,ty);
				cub.tracer(tx, ty, g);
				cub.reper(g);
				
				try {
					MT = cub.symetriqueParapporAxe(M, getAxe(), 0, 0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				MP = cub.projectionCavalier(MT);
				MMT = cub.doubleToInt(MP);
				cub.extraction(MMT, tx,ty);
				cub.tracer(tx, ty, g);
				cub.reper(g);
			
		}
		
		public String getAxe() {
			return axe;
		}
		public void setAxe(String axe) {
			this.axe = axe;
		}
		
		
	}
	

}
