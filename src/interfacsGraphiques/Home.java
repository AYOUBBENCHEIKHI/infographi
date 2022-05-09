package interfacsGraphiques;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;

public class Home extends JFrame {
	private static final long serialVersionUID = 1L;
	public Home() {
		
		JFrame frame = new JFrame("Home");
		frame.getContentPane().setBackground(new Color(51, 153, 255));
		
		//  ------patie de 2 D---------
		JLabel message = new JLabel("Pour tracer Un ligne");
		message.setBounds(250,10,150,28);
		this.ligne(frame);
		JLabel message1 = new JLabel("Pour tracer Une Cercle");
		message1.setBounds(250,70,150,28);
		this.cercle(frame);
		JLabel message2 = new JLabel("---Horloge----");
		message2.setBounds(150,150,150,28);
		this.Horloge(frame);
		frame.getContentPane().add(message);
		frame.getContentPane().add(message1);
		frame.getContentPane().add(message2);
		//---------------FIN-------------------
		
		//----------partie de 3 D--------------------
		JLabel message3 = new JLabel("--------------Partie 3D-------------");
		message3.setBounds(200,250,200,28);
		frame.getContentPane().add(message3);
		this.cub3D(frame);
		this.translation(frame);
		this.rotaion(frame);
		this.alignement(frame);
		this.ExerciceCub(frame);
		this.RotationExercice(frame);
		this.TracerCubPerspective(frame);
		this.CourbeBezier(frame);
		this.Symetrique(frame);
		this.Elipse(frame);
		this.ProjetctionSurPlanQIQ(frame);
		//--------------FIN----------------
		
		
		
		
		
		frame.setSize(600,500);
		//frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		System.err.println(frame.getSize().toString());
	}

	public void ligne ( JFrame frame) {
		
		
		//le butten et li x debute est fine 
		
		JLabel xd = new JLabel("XD: ");
		xd.setBounds(0,40,80,28);
		JTextField XD = new JTextField();
		XD.setBounds(30,40,80,28);
		
		JLabel yd = new JLabel("YD: ");
		yd.setBounds(110,40,80,28);
		JTextField YD = new JTextField();
		YD.setBounds(140,40,80,28);
		
		JLabel xf = new JLabel("XF: ");
		xf.setBounds(220,40,80,28);
		JTextField XF = new JTextField();
		XF.setBounds(250,40,80,28);
		
		JLabel yf = new JLabel("YF: ");
		yf.setBounds(330,40,80,28);
		JTextField YF = new JTextField();
		YF.setBackground(Color.WHITE);
		YF.setBounds(360,40,80,28);
		
		frame.getContentPane().add(xd);
		frame.getContentPane().add(yd);
		frame.getContentPane().add(xf);
		frame.getContentPane().add(yf);
		frame.getContentPane().add(XD);
		frame.getContentPane().add(YD);
		frame.getContentPane().add(XF);
		frame.getContentPane().add(YF);
		JButton ligne = new JButton("Tracer ligne");
	
		
			ligne.setBackground(UIManager.getColor("CheckBox.background"));
			ligne.addActionListener((ActionListener) new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int xd =Integer.parseInt(XD.getText());
					int yd =Integer.parseInt(YD.getText());
					int xf =Integer.parseInt(XF.getText());
					int yf =Integer.parseInt(YF.getText());
					Graphique2D frame = new Graphique2D(xd, yd, xf, yf);
					frame.setVisible(true);
				}
			});
			ligne.setBounds(460,40,120,28);	
			frame.getContentPane().add(ligne);
		}


	
	public void cercle(JFrame frame) {
		//le butten et li x debute est fine 
		JLabel r = new JLabel("R: ");
		r.setBounds(0,100,100,28);
		JTextField R = new JTextField();
		R.setBounds(30,100,100,28);
		
		JLabel h = new JLabel("H: ");
		h.setBounds(130,100,100,28);
		JTextField H = new JTextField();
		H.setBounds(160,100,100,28);
		
		JLabel k = new JLabel("K: ");
		k.setBounds(260,100,100,28);
		JTextField K = new JTextField();
		K.setBounds(290,100,100,28);
		
		
		frame.getContentPane().add(r);
		frame.getContentPane().add(h);
		frame.getContentPane().add(k);
		frame.getContentPane().add(R);
		frame.getContentPane().add(H);
		frame.getContentPane().add(K);

		
		
		JButton cercle = new JButton("Tracer Cercle");
		cercle.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r =Integer.parseInt(R.getText());
				int h =Integer.parseInt(H.getText());
				int k =Integer.parseInt(K.getText());
				Graphique2D frame = new Graphique2D(r, h, k);
				frame.setVisible(true);
			}
		});
		cercle.setBounds(460,100,120,28);	
		frame.getContentPane().add(cercle);
		
	}
	
	public void Horloge(JFrame frame) {
		
		JLabel r = new JLabel("Rayon: ");
		r.setBounds(10,200,100,28);
		JTextField R = new JTextField();
		R.setBounds(100,200,180,28);

		frame.getContentPane().add(r);
		frame.getContentPane().add(R);
		
		JButton ligne = new JButton("Horloge");
		ligne.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r =Integer.parseInt(R.getText());
				Graphique2D frame = new Graphique2D(r);
				frame.setVisible(true);
			}
		});
		ligne.setBounds(460,200,120,28);	
		frame.getContentPane().add(ligne);
		
	}
	//-----------------partie de 3 d -------------------------------------
	
	public void cub3D(JFrame frame) {
		
		JButton cub = new JButton("Cub 3D");
		cub.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphique3D frame = new Graphique3D();
				frame.setVisible(true);
			}
		});
		cub.setBounds(10,300,120,28);	
		frame.getContentPane().add(cub);
	}
	
	public void translation(JFrame frame) {
		
		JButton cub = new JButton("Translation");
		cub.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphique3D frame = new Graphique3D("Translation");
				frame.setVisible(true);
			}
		});
		cub.setBounds(160,300,120,28);	
		frame.getContentPane().add(cub);
	} 
	
	public void rotaion(JFrame frame) {
		
		JButton cub = new JButton("Rotation");
		cub.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphique3D frame = new Graphique3D("Rotation");
				frame.setVisible(true);
			}
		});
		cub.setBounds(310,300,120,28);	
		frame.getContentPane().add(cub);
	}
	public void alignement(JFrame frame) {
		
		JButton cub = new JButton("Alignement");
		cub.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphique3D frame = new Graphique3D("Alignement");
				frame.setVisible(true);
			}
		});
		cub.setBounds(460,300,120,28);	
		frame.getContentPane().add(cub);
	}
	
	public void ExerciceCub(JFrame frame) {
		
		JButton cub = new JButton("Exercice Cub");
		cub.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphique3D frame = new Graphique3D(0,0);
				frame.setVisible(true);
			}
		});
		cub.setBounds(10,350,120,28);	
		frame.getContentPane().add(cub);
	}
	public void RotationExercice(JFrame frame) {
		
		JButton cub = new JButton("Rotation");
		cub.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphique3D frame = new Graphique3D(0,0);
				frame.setVisible(true);
			}
		});
		cub.setBounds(160,350,120,28);	
		frame.getContentPane().add(cub);
	}
	public void TracerCubPerspective(JFrame frame) {
		
		JButton cub = new JButton("P_PERSPECTIVE");
		cub.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphique3D frame = new Graphique3D("Perspective");
				frame.setVisible(true);
			}
		});
		cub.setBounds(310,350,120,28);	
		frame.getContentPane().add(cub);
	}
	public void CourbeBezier(JFrame frame) {
		
		JButton cub = new JButton("CourbeBezier");
		cub.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphique3D frame = new Graphique3D("CourbeBezier");
				frame.setVisible(true);
			}
		});
		cub.setBounds(460,350,120,28);	
		frame.getContentPane().add(cub);
	}
	public void Symetrique(JFrame frame) {
		
		JButton cub = new JButton("Symitrique");
		cub.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphique3D frame = new Graphique3D("Symetrique");
				frame.setVisible(true);
			}
		});
		cub.setBounds(10,400,120,28);	
		frame.getContentPane().add(cub);
	}
	public void Elipse(JFrame frame) {
		
		JButton cub = new JButton("Elipse");
		cub.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphique3D frame = new Graphique3D("Elipse");
				frame.setVisible(true);
			}
		});
		cub.setBounds(160,400,120,28);	
		frame.getContentPane().add(cub);
	}
	public void ProjetctionSurPlanQIQ(JFrame frame) {
		
		JButton cub = new JButton("P_Plan_Qlq");
		cub.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphique3D frame = new Graphique3D("P_Plan_Qlq");
				frame.setVisible(true);
			}
		});
		cub.setBounds(310,400,120,28);	
		frame.getContentPane().add(cub);
	}
	public static void main(String[] args) {
		new Home();
	}

}
