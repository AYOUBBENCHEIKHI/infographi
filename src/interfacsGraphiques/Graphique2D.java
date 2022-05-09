package interfacsGraphiques;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import graphe2D.Cercle;
import graphe2D.Ligne;

public class Graphique2D  extends JFrame{
	private static final long serialVersionUID = 1L;
	private panelLigne panelLigne;
	private PanelCercle panelCercle;
	private PanelHorloge panelHorloge;
	
	public Graphique2D(int R) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("HORLOGE");
		setBounds(100, 100, 700, 600);
		setResizable(false);
		panelHorloge = new PanelHorloge(R);
		panelHorloge.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelHorloge);
		panelHorloge.setLayout(null);
	}

	public Graphique2D(int xd,int yd,int xf,int yf) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("les Ligne");
		setBounds(100, 100, 700, 600);
		setResizable(false);
		panelLigne = new panelLigne(xd, yd, xf, yf);
		panelLigne.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelLigne);
		panelLigne.setLayout(null);
	}
	public Graphique2D(int R,int H,int K) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("les Cercle");
		setBounds(100, 100, 700, 600);
		setResizable(false);
		panelCercle = new PanelCercle(R, H, K);
		panelCercle.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelCercle);
		panelCercle.setLayout(null);
	}
	public class panelLigne extends JPanel{
		private static final long serialVersionUID = 1L;
		private int xd;
		private int yd;
		private int xf;
		private int yf;
		public panelLigne() {
			// TODO Auto-generated constructor stub
		}
		 public panelLigne(int xd,int yd,int xf,int yf) {
			 this.setXd(xd);
			 this.setYd(yd);
			 this.setXf(xf);
			 this.setYf(yf);
		 }
			@Override
			protected void paintChildren(Graphics g) {
				super.paintChildren(g);
				Ligne l = new Ligne(getXd(), getYd(),getXf(), getYf());
				l.reper(g);
				l.LignePolynomial(g);
				
			}
		 
		public int getXd() {
			return xd;
		}

		public void setXd(int xd) {
			this.xd = xd;
		}

		public int getYd() {
			return yd;
		}

		public void setYd(int yd) {
			this.yd = yd;
		}

		public int getXf() {
			return xf;
		}

		public void setXf(int xf) {
			this.xf = xf;
		}

		public int getYf() {
			return yf;
		}

		public void setYf(int yf) {
			this.yf = yf;
		}	
	}
	
	public class PanelCercle extends JPanel{
		private static final long serialVersionUID = 1L;
		private int h;
		private int k;
		private int r;
		public PanelCercle() {
			
		}
		public PanelCercle(int r, int h, int k) {
			super();
			this.setH(h);
			this.setK(k);
			this.setR(r);
		}
		
		@Override
		protected void paintChildren(Graphics g) {
			super.paintChildren(g);
			Cercle c =new Cercle(getR(),getH(),getK());
			c.CercleBresenHam(g);;
			c.reper(g);
			
			
		}
		public int getH() {
			return h;
		}
		public void setH(int h) {
			this.h = h;
		}
		public int getK() {
			return k;
		}
		public void setK(int k) {
			this.k = k;
		}
		public int getR() {
			return r;
		}
		public void setR(int r) {
			this.r = r;
		}
		
		
	}
	
	public class PanelHorloge extends JPanel {
		private static final long serialVersionUID = 1L;
		private int r;
		public PanelHorloge() {
			
		}
		public PanelHorloge(int r) {
			this.setR(r);
		}
		@Override
		protected void paintChildren(Graphics g) {
			super.paintChildren(g);
			Cercle c =new Cercle();
			c.Horloge(g,getR());;
			c.reper(g);			
		}
		public int getR() {
			return r;
		}
		public void setR(int r) {
			this.r = r;
		}
		
	}


}
