package interfacsGraphiques;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Courbes.CourbeBernsten;
import graphe3D.Cub3D;
import graphe3D.ExerciceCub;

public class Graphique3D extends JFrame{
	private static final long serialVersionUID = 1L;
	private PanelCub3D panelCub3D;
	private PanelExerciceCub panelExerciceCub;
	private PanelCub3DPerspective panelCub3DPerspective;
	private PanelCourbeBezier panelCourbeBezier;
	private PanelElipse panelElipse;
	private PanelP_Plan_Qlq panelP_Plan_Qlq;
	private JPanel panel;
	

	public Graphique3D() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cube 3D");
		setBounds(100, 100, 700, 600);
		setResizable(false);
		panelCub3D = new PanelCub3D();
		panelCub3D.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelCub3D);
		panelCub3D.setLayout(null);
		
	}
	

	public Graphique3D(String nom) {
		
		if(nom.equals("Translation")) {
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setTitle("Translation");
				setBounds(100, 100, 450, 200);
				setResizable(false);
				panel = new JPanel();
				panel.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(panel);
				JLabel T = new JLabel("-------TRANSLATION----------");
				T.setBounds(150,10,200,28);
				add(T);
				//TRANSLATION DE CUBE   
				JLabel x = new JLabel("X: ");
				x.setBounds(0,60,60,28);
				JTextField X = new JTextField();
				X.setBounds(30,60,100,28);
				
				JLabel y = new JLabel("Y: ");
				y.setBounds(130,60,100,28);
				JTextField Y = new JTextField();
				Y.setBounds(160,60,100,28);
				
				JLabel z = new JLabel("Z: ");
				z.setBounds(260,60,100,28);
				JTextField Z = new JTextField();
				Z.setBounds(290,60,100,28);
				add(x);
				add(y);
				add(z);
				add(X);
				add(Y);
				add(Z);
				
				JButton cub = new JButton("Translation");
				cub.addActionListener((ActionListener) new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(X.getText().equals("") || Y.getText().equals("")|| Z.getText().equals("") ) {
							X.setText("0");
							Y.setText("0");
							Z.setText("0");
						}
						int x =Integer.parseInt(X.getText());
						int y =Integer.parseInt(Y.getText());
						int z =Integer.parseInt(Z.getText());
						
						Graphique3D2 frame = new Graphique3D2(x,y,z);
						
						frame.setVisible(true);
					}
				});
				cub.setBounds(150,110,120,28);	
				add(cub);
				panel.setLayout(null);
		}
		else if(nom.equals("Rotation")) {
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setTitle("Rotation");
			setBounds(100, 100, 450, 250);
			setResizable(false);
			panel = new JPanel();
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(panel);
			JLabel T = new JLabel("-------Rotation----------");
			T.setBounds(150,10,200,28);
			add(T);
			//ROTATION DE CUBE   
			JLabel xd = new JLabel("XD: ");
			xd.setBounds(0,60,60,28);
			JTextField XD = new JTextField();
			XD.setBounds(30,60,100,28);
			
			JLabel yd = new JLabel("YD: ");
			yd.setBounds(130,60,100,28);
			JTextField YD = new JTextField();
			YD.setBounds(160,60,100,28);
			
			JLabel xf = new JLabel("XF: ");
			xf.setBounds(0,90,100,28);
			JTextField XF = new JTextField();
			XF.setBounds(30,90,100,28);
			
			JLabel yf = new JLabel("YF: ");
			yf.setBounds(130,90,100,28);
			JTextField YF = new JTextField();
			YF.setBounds(160,90,100,28);
			
			
			JLabel angle = new JLabel("Angle : ");
			angle.setBounds(0,120,80,28);
			JTextField Angle = new JTextField();
			Angle.setBounds(100,120,80,28);
			
			add(xd);
			add(yd);
			add(xf);
			add(yf);
			add(angle);
			add(XD);
			add(YD);
			add(XF);
			add(YF);
			add(Angle);
			
			JButton cub = new JButton("Rotation");
			cub.addActionListener((ActionListener) new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(XD.getText().equals("") || YD.getText().equals("")|| XF.getText().equals("") || YF.getText().equals("")) {
						XD.setText("0");
						YD.setText("0");
						XF.setText("0");
						YF.setText("0");
					}
					double xd =Double.parseDouble(XD.getText());
					double yd =Double.parseDouble(YD.getText());
					double xf =Double.parseDouble(XF.getText());
					double yf =Double.parseDouble(YF.getText());
					double angle = Double.parseDouble(Angle.getText());
					Graphique3D2 frame = new Graphique3D2(xd,yd,xf,yf,angle);
					frame.setVisible(true);
				} 
			});
			cub.setBounds(290,74,120,28);	
			add(cub);
			panel.setLayout(null);
			
		}
		
		else if(nom.equals("Alignement")) {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setTitle("Alignement");
			setBounds(100, 100, 450, 280);
			setResizable(false);
			panel = new JPanel();
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(panel);
			JLabel T = new JLabel("-------Alignement----------");
			T.setBounds(150,10,200,28);
			add(T);
			//TRANSLATION DE CUBE   
			JLabel a = new JLabel("a: ");
			a.setBounds(0,60,60,28);
			JTextField A = new JTextField();
			A.setBounds(30,60,100,28);
			
			JLabel b = new JLabel("b: ");
			b.setBounds(130,60,100,28);
			JTextField B = new JTextField();
			B.setBounds(160,60,100,28);
			
			JLabel c = new JLabel("c: ");
			c.setBounds(260,60,100,28);
			JTextField C = new JTextField();
			C.setBounds(290,60,100,28);
			add(a);
			add(b);
			add(c);
			add(A);
			add(B);
			add(C);
			
			JLabel T1 = new JLabel("-------VECTOR ALIGNER----------");
			T1.setBounds(150,100,200,28);
			add(T1);
			
			JLabel a1 = new JLabel("a1: ");
			a1.setBounds(0,150,60,28);
			JTextField A1 = new JTextField();
			A1.setBounds(30,150,100,28);
			
			JLabel b1 = new JLabel("b1: ");
			b1.setBounds(130,150,100,28);
			JTextField B1 = new JTextField();
			B1.setBounds(160,150,100,28);
			
			JLabel c1 = new JLabel("c1: ");
			c1.setBounds(260,150,100,28);
			JTextField C1 = new JTextField();
			C1.setBounds(290,150,100,28);
			add(a1);
			add(b1);
			add(c1);
			add(A1);
			add(B1);
			add(C1);
			
			JButton cub = new JButton("Alignement");
			cub.addActionListener((ActionListener) new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(A.getText().equals("") || B.getText().equals("")|| C.getText().equals("") ||
							A1.getText().equals("") || B1.getText().equals("")|| C1.getText().equals("")) {
						A.setText("0");
						B.setText("0");
						C.setText("0");
						A1.setText("0");
						B1.setText("0");
						C1.setText("0");
					}
					double a =Double.parseDouble(A.getText());
					double b =Double.parseDouble(B.getText());
					double c =Double.parseDouble(C.getText());
					double a1 =Double.parseDouble(A1.getText());
					double b1 =Double.parseDouble(B1.getText());
					double c1 =Double.parseDouble(C1.getText());
					Graphique3D2 frame = new Graphique3D2(a, b, c,a1, b1,c1);
					
					frame.setVisible(true);
				}
			});
			cub.setBounds(150,190,120,28);	
			add(cub);
			panel.setLayout(null);
			
		}
		else if(nom.equals("Perspective")) {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setTitle("projection perspictive");
			setBounds(100, 100, 700, 600);
			setResizable(false);
			panelCub3DPerspective = new PanelCub3DPerspective();
			panelCub3DPerspective.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(panelCub3DPerspective);
			panelCub3DPerspective.setLayout(null);
		}
		else if(nom.equals("CourbeBezier")) {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setTitle("Courbe Bezier");
			setBounds(100, 100, 800, 600);
			setResizable(false);
			panelCourbeBezier = new PanelCourbeBezier();
			panelCourbeBezier.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(panelCourbeBezier);
			panelCourbeBezier.setLayout(null);
		}
		else if (nom.equals("Symetrique")) {
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setTitle("Symetrique");
			setBounds(100, 100, 450, 250);
			setResizable(false);
			panel = new JPanel();
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(panel);
			JLabel T = new JLabel("-------Symetrique----------");
			T.setBounds(150,10,200,28);
			add(T);
			//ROTATION DE CUBE   
			JLabel x = new JLabel("X: ");
			x.setBounds(0,60,60,28);
			JTextField X = new JTextField();
			X.setBounds(30,60,100,28);			
			add(x);
			add(X);
			
			JButton cub = new JButton("Symetrique");
			cub.addActionListener((ActionListener) new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(X.getText().equals("")) {
						X.setText("");		
					}
					String x =X.getText();
					Graphique3D2 frame = new Graphique3D2(x);
					frame.setVisible(true);
				} 
			});
			cub.setBounds(290,74,120,28);	
			add(cub);
			panel.setLayout(null);
		}
		else if(nom.equals("Elipse")) {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setTitle("Elipse");
			setBounds(100, 100, 800, 600);
			setResizable(false);
			panelElipse = new PanelElipse();
			panelElipse.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(panelElipse);
			panelElipse.setLayout(null);
		}
		else if(nom.equals("P_Plan_Qlq")) {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setTitle("P_Plan_Qlq");
			setBounds(100, 100, 800, 600);
			setResizable(false);
			panelP_Plan_Qlq = new PanelP_Plan_Qlq();
			panelP_Plan_Qlq.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(panelP_Plan_Qlq);
			panelP_Plan_Qlq.setLayout(null);
		}
	}
	
	
	public Graphique3D(double angle,double a) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cube 3D");
		setBounds(100, 100, 700, 600);
		setResizable(false);
		panelExerciceCub = new PanelExerciceCub();
		panelExerciceCub.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelExerciceCub);
		panelExerciceCub.setLayout(null);
	}
	
	public class PanelCub3D extends JPanel{
		private static final long serialVersionUID = 1L;
		@Override
		protected void paintChildren(Graphics g) {
			super.paintChildren(g);
			 double M[][] = {{0,0,0,1},
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
			int MMT[][] =null;
			Cub3D cub = new Cub3D();
			MP = cub.projectionCavalier(M);
			MMT = cub.doubleToInt(MP);
			//---------------------------------------
	
			//---------------------------------------
			cub.extraction(MMT, tx,ty);
			cub.tracer(tx, ty, g);
			cub.reper(g);
		}
		
	}
	public class PanelCub3DPerspective extends JPanel{
		private static final long serialVersionUID = 1L;
		@Override
		protected void paintChildren(Graphics g) {
			super.paintChildren(g);
			 double M[][] = {{0,0,0,1},
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
			int MMT[][] =null;
			Cub3D cub = new Cub3D();
			try {
				MP = cub.projectionPerspective(M,10);
			} catch (Exception e) {
				e.printStackTrace();
			}
			MMT = cub.doubleToInt(MP);
			//---------------------------------------
	
			//---------------------------------------
			cub.extraction(MMT, tx,ty);
			cub.tracer(tx, ty, g);
			cub.reper(g);
		}
		
	}
	public class PanelCourbeBezier extends JPanel{
		private static final long serialVersionUID = 1L;
		@Override
		protected void paintChildren(Graphics g) {
			super.paintChildren(g);
			//reper----------------
			Graphics2D g2 = (Graphics2D) g;
			 g2.draw ((Shape) new Line2D.Double(0,340,640,340));
			g2.draw ((Shape) new Line2D.Double(320,0,320,480));
			//--------------------------
			CourbeBernsten bez = new CourbeBernsten();
			double[] b0 = {1,1};
			double[] b1 = {2,3};
			double[] b2 = {4,3};
			double[] b3 = {3,1};
			g.setColor(Color.blue);
			g.drawLine(100+320,340-100,320+200,340-300);
			g.drawLine(320+200,340-300,320+400,340-300);
			g.drawLine(320+400,340-300,320+300,340-100);
			double Point[][] = {b0,b1,b2,b3};
			double[][] p =new double[7][2];
			p[0]=bez.polynomBern(Point, 0);
			p[1]=bez.polynomBern(Point, 0.15);
			p[2]=bez.polynomBern(Point, 0.35);
			p[3]=bez.polynomBern(Point, 0.50);
			p[4]=bez.polynomBern(Point, 0.65);
			p[5]=bez.polynomBern(Point, 0.85);
			p[6]=bez.polynomBern(Point, 1);
			
			for(int i=0;i<7;i++) {
				//System.err.println("["+p[i][0]+","+p[i][1]+"]");
				g.setColor(Color.red);
				if(i==6) {
					g.drawLine(320+(int)(p[i][0]*100),340-(int)(p[i][1]*100),320+(int)(p[i][0]*100),340-(int)(p[i][1]*100));
					//break;
				}
				else {
					g.drawLine(320+(int)(p[i][0]*100),340-(int)(p[i][1]*100),320+(int)(p[i+1][0]*100),340-(int)(p[i+1][1]*100));
				}
				
			}
		
			
		}
			
	}
	public class PanelExerciceCub extends JPanel{
		private static final long serialVersionUID = 1L;
		@Override
		protected void paintChildren(Graphics g) {
			super.paintChildren(g);
			 double M[][] = {{0,0,0,1},
							{1,0,0,1},
							{1,1,0,1},
							{0,1,0,1},
							{0,0,1,1},
							{1,0,1,1},
							{1,0.5,1,1},
							{0,1,1,1},
							{0.5,1,1,1},
							{1,1,0.5,1}};
			
			int tx[] = new int [10];
			int ty[] = new int [10];
			double MP[][] = null;
			int MMT[][] =null;
			Cub3D cub = new Cub3D();
			cub.reper(g);
			ExerciceCub ex = new ExerciceCub();
			MP = cub.projectionCavalier(M);
			MMT = ex.doubleToInt(MP);
			ex.extraction(MMT, tx, ty);
			ex.tracer(tx, ty, g);
			g.setColor(Color.blue);
			g.drawLine(0+320,240-0,320+150,240-150);
			
	
		}
		
	}
	public class PanelElipse extends JPanel{
		private static final long serialVersionUID = 1L;
		@Override
		protected void paintChildren(Graphics g) {
			super.paintChildren(g);
			Cub3D cub =new Cub3D();
			cub.reper(g);
			cub.elips(g);
			
	
		}
		
	}
	public class PanelP_Plan_Qlq extends JPanel{
		private static final long serialVersionUID = 1L;
		@Override
		protected void paintChildren(Graphics g) {
			super.paintChildren(g);
			Cub3D cub =new Cub3D();
			double M[][] = {{0,0,0,1},
					{1,0,0,1},
					{1,1,0,1},
					{0,1,0,1},
					{0,0,1,1},
					{1,0,1,1},
					{1,1,1,1},
					{0,1,1,1}};
			g.drawString("R0",145+320,240+55);
			double x0=150,y0=100,z0=0;
			g.drawLine(150+320,240+60,200+320 ,240+100);
			g.setColor(Color.red);
			g.drawString("N",165+320,240+50);
			g.drawLine(150+320,240+60,200+320 ,240+60);
			double n1=50,n2=0,n3=0;
			g.setColor(Color.black);
			g.drawLine(150+320,240+60,150+320 ,240+160);
			g.drawLine(200+320,240+100,200+320 ,240+200);
			g.drawLine(150+320,240+160,200+320 ,240+200);
			g.drawLine(320,240+280,320 ,240+280);
			cub.reper(g);
			double a=0,b=280,c=0;
			
			int tx[] = new int [8];
			int ty[] = new int [8];
			double MP[][] = null;
			int MMT[][] =null;
			MP=cub.projectionCavalier(M);
			MMT = cub.doubleToInt(MP);
			cub.extraction(MMT, tx,ty);
			cub.tracer(tx, ty, g);
			cub.reper(g);
			
			//projection
			try {
				MP =cub.projectionPerspectivePlanQlq(M, a, b, c, n1, 
						n2, n3, x0, y0, z0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MP=cub.projectionCavalier(M);
			MMT = cub.doubleToInt(MP);
			cub.extraction(MMT, tx,ty);
			cub.tracer(tx, ty, g);
	System.out.println(MP[0][1]);
		}
	}
}
