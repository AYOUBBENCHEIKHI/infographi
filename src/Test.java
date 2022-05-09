import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Courbes.CourbeBernsten;
import graphe3D.Cub3D;
public class Test extends JPanel{

	public Test() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void paintChildren(Graphics g) {
		super.paintChildren(g);
		double M[][] = {{0,0,0,1},
						{3,0,0,1},
						{3,2,0,1},
						{0,2,0,1},
						{0,0,1,1},
						{3,0,1,1},
						{3,2,1,1},
						{0,2,1,1}};
		int tx[] = new int [8];
		int ty[] = new int [8];
		double MP[][] = null;
		int MMT[][] =null;
		Cub3D cub = new Cub3D();
		exament ex = new exament();
		MP = cub.projectionCavalier(M);
		MMT = ex.doubleToInt(MP);
		
		ex.extraction(MMT, tx,ty);
		ex.tracer(tx, ty, g);
		ex.reper(g);
		g.setColor(Color.red);
		g.drawLine(320,300-200,320+300,300);
		
		
		
		
		//TRANSLATION PARAPPORT A Y----------------------
		g.setColor(Color.black);
		g.setColor(Color.green);
		double Mt[][] = null;
		MP=cub.translationXYZ(M, 0,-2,0);
		 Mt = cub.projectionCavalier(MP);
		MMT = ex.doubleToInt(Mt);
		ex.extraction(MMT, tx,ty);
		//ex.tracer(tx, ty, g);
		g.setColor(Color.black);
		//-----------------------------------------------------------
		
		
		
		
		//en faire alignement--------------------------------------
		try {
			MP=ex.aligne(MP,3.0,-2.0,0.0,0.0,0.0,1.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Mt = cub.projectionCavalier(MP);
		MMT = ex.doubleToInt(Mt);
		ex.extraction(MMT, tx,ty);
		//ex.tracer(tx, ty, g);
		
		//------------------rotaion parapor a z
		double MR[][] =null;
		MR=ex.rotaionZ(MP);
		 Mt = cub.projectionCavalier(MP);
		MMT = ex.doubleToInt(Mt);
		ex.extraction(MMT, tx,ty);
		//ex.tracer(tx, ty, g);
	
		try {
			MP=ex.aligne(MR,0.0,0.0,1.0,3.0,-2.0,0.0);
			//3.0,-2.0,0.0,0.0,0.0,1.0
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Mt = cub.projectionCavalier(MP);
		MMT = ex.doubleToInt(Mt);
		ex.extraction(MMT, tx,ty);
		//ex.tracer(tx, ty, g);
		
		
		
		/// deuxieme translation
		g.setColor(Color.blue);
		MP=cub.translationXYZ(MP, 0,2,0);
		 Mt = cub.projectionCavalier(MP);
		MMT = ex.doubleToInt(Mt);
		ex.extraction(MMT, tx,ty);
		ex.tracer(tx, ty, g);
		
	
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("Rotaion de 90dg");
		f.addWindowListener( new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		f.getContentPane().add(new Test());
		f.setSize(800,800);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setResizable(false);
		f.revalidate();	
		
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
