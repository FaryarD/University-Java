package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;


public class Gui implements ActionListener{

	private JFrame frmHalmaGame;
	private NewGameFrame gsetting;
	JButton btnStartNewGame;
	JButton btnResume;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frmHalmaGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmHalmaGame = new JFrame();
		frmHalmaGame.getContentPane().setBackground(Color.DARK_GRAY);
		frmHalmaGame.setBackground(Color.DARK_GRAY);
		frmHalmaGame.setResizable(false);
		frmHalmaGame.setTitle("Halma Game");
		frmHalmaGame.setBounds(100, 100, 190, 389);
        
		frmHalmaGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHalmaGame.setLocationByPlatform(true);
		
		btnResume = new JButton("Resume");
		btnResume.setBackground(Color.LIGHT_GRAY);
		btnResume.setBounds(15, 207, 145, 25);
		btnResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(gsetting!=null)gsetting.setGameBoardVisible(true);
			}
		});
		frmHalmaGame.getContentPane().setLayout(null);
		frmHalmaGame.getContentPane().add(btnResume);
		
		btnStartNewGame = new JButton("Start New");
		btnStartNewGame.setBackground(Color.LIGHT_GRAY);
		btnStartNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(gsetting!=null) {
					gsetting.disposeGame();
					gsetting.dispose();
				}
				gsetting=new NewGameFrame();
				gsetting.setVisible(true);
			}
		});
		btnStartNewGame.setBounds(15, 239, 145, 25);
		frmHalmaGame.getContentPane().add(btnStartNewGame);
		
		JButton btnShowScores = new JButton("Show Scores");
		btnShowScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WinnerDataBase winnerp=new WinnerDataBase();
				winnerp.display();
			}
		});
		btnShowScores.setBackground(Color.LIGHT_GRAY);
		btnShowScores.setBounds(15, 276, 145, 25);
		frmHalmaGame.getContentPane().add(btnShowScores);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(15, 12, 160, 170);
		frmHalmaGame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblImage = new JLabel(new ImageIcon("Data/Images/1.png"));
		panel.add(lblImage, BorderLayout.WEST);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 System.exit(0);
				
			}
		});
		btnExit.setBackground(Color.LIGHT_GRAY);
		btnExit.setBounds(15, 313, 145, 25);
		frmHalmaGame.getContentPane().add(btnExit);
	}
	public void actionPerformed(ActionEvent e) {  
		
		
	}
}
