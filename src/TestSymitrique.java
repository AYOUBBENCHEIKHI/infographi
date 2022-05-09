import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import graphe3D.Cub3D;

public class TestSymitrique  extends JPanel {

	public TestSymitrique() {
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
		double Mt[][] = null;
		double MF[][] =null;
		MF=cub.translationXYZ(M,0,-2,0);
		MF=ex.rotaionZA(MF,-Math.PI/(5.4));
		try {
			MF=ex.symetriqueParapporAxe(MF, "xz",0,0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MF=ex.rotaionZA(MF,Math.PI/(5.4));
		MF=cub.translationXYZ(MF, 0,2,0);
		Mt = cub.projectionCavalier(MF);
		MMT = ex.doubleToInt(Mt);
		ex.extraction(MMT, tx,ty);
		g.setColor(Color.blue);
		ex.tracer(tx, ty, g);
		
	
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("Symitriue par rapport a BFDH");
		f.addWindowListener( new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		f.getContentPane().add(new TestSymitrique());
		f.setSize(800,800);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setResizable(false);
		f.revalidate();	
		
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
