import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class Member extends JFrame implements ActionListener{
	
	private String login;
	private String password;
	private JButton action;
	private JButton aventure;
	private JButton guerre;
	private JButton epouvantehorreur;
	private JButton comedie;
	private JButton drame;
	private JButton fantastique;
	private JButton policier;
	private JButton romance;
	private JButton science_fiction;
	private JButton western;
	private JButton animation;
	private JButton deconnexion;
	private UserInterface acceuil;
	private JPanel pannel;
	private Film f;
	
	public Member(){
		super();
		connect();
		f = new Film();
	}
	
	public void setLogin(String log){
		login= log;
	}
	
	public String getLogin(){
		return this.login;
	}
	
	public void setPassword(String pswd){
		password = pswd;
	}
	
	public String getPassword(){
		return this.password;
	}

	
	public void connect(){
		setTitle("Espace membre");
		setSize(800,600);
		setLocationRelativeTo(null);
		setResizable(false);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(affichage());
	}
	
	private JPanel affichage(){
		pannel = new JPanel();
		JPanel categorie = new JPanel();
		JPanel utilisateur = new JPanel();
		JPanel top = new JPanel();
		pannel.setLayout(new BorderLayout());
		categorie.setLayout(new GridBagLayout());
		utilisateur.setLayout(new GridBagLayout());
		pannel.setBackground(Color.LIGHT_GRAY);
		categorie.setBackground(Color.DARK_GRAY);
		utilisateur.setBackground(Color.gray);
		
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagConstraints user = new GridBagConstraints();
		
		gbc.insets = new Insets(10, 20, 5, 00);
		user.insets = new Insets(10, 200, 5, 200);
		
		action = new JButton("Action");
		gbc.gridx = 0;
		gbc.gridy = 0;
		categorie.add(action, gbc);
		action.setPreferredSize(new Dimension(170,20));
		
		animation = new JButton("Animation");
		gbc.gridx = 0;
		gbc.gridy = 1;
		categorie.add(animation, gbc);
		animation.setPreferredSize(new Dimension(170,20));
		
		aventure = new JButton("Aventure");
		gbc.gridx = 0;
		gbc.gridy = 2;
		categorie.add(aventure, gbc);
		aventure.setPreferredSize(new Dimension(170,20));
		
		comedie = new JButton("Comédie");
		gbc.gridx = 0;
		gbc.gridy = 3;
		categorie.add(comedie, gbc);
		comedie.setPreferredSize(new Dimension(170,20));
		
		drame = new JButton("Drame");
		gbc.gridx = 0;
		gbc.gridy = 4;
		categorie.add(drame, gbc);
		drame.setPreferredSize(new Dimension(170,20));
		
		epouvantehorreur = new JButton("Epouvante-Horreur");
		gbc.gridx = 0;
		gbc.gridy = 5;
		categorie.add(epouvantehorreur, gbc);
		epouvantehorreur.setPreferredSize(new Dimension(170,20));
		
		fantastique = new JButton("Fantastique");
		gbc.gridx = 0;
		gbc.gridy = 6;
		categorie.add(fantastique, gbc);
		fantastique.setPreferredSize(new Dimension(170,20));
		
		guerre = new JButton("Guerre");
		gbc.gridx = 0;
		gbc.gridy = 7;
		categorie.add(guerre, gbc);
		guerre.setPreferredSize(new Dimension(170,20));
		
		policier = new JButton("Policier");
		gbc.gridx = 0;
		gbc.gridy = 8;
		categorie.add(policier, gbc);
		policier.setPreferredSize(new Dimension(170,20));
		
		romance = new JButton("Romance");
		gbc.gridx = 0;
		gbc.gridy = 9;
		categorie.add(romance, gbc);
		romance.setPreferredSize(new Dimension(170,20));
		
		science_fiction = new JButton("Science-Fiction");
		gbc.gridx = 0;
		gbc.gridy = 10;
		categorie.add(science_fiction, gbc);
		science_fiction.setPreferredSize(new Dimension(170,20));
		
		western = new JButton("Western");
		gbc.gridx = 0;
		gbc.gridy = 11;
		categorie.add(western, gbc);
		western.setPreferredSize(new Dimension(170,20));
		
		
		user.gridx = 0;
		user.gridy = 0;
		JLabel name = new JLabel("Bienvenue " + login);
		name.setForeground(Color.WHITE);
		utilisateur.add(name, user);
		
		deconnexion = new JButton("Déconnexion");
		user.gridx = 1;
		user.gridy = 0;
		utilisateur.add(deconnexion, user);
		deconnexion.setPreferredSize(new Dimension(150,20));
		
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		ImageIcon img = new ImageIcon("Image/Films.jpg");
		JLabel im = new JLabel(img);
		top.add(im);
		
		pannel.add(categorie, BorderLayout.WEST);
		pannel.add(utilisateur, BorderLayout.NORTH);
		pannel.add(top, BorderLayout.CENTER);
		
		deconnexion.addActionListener(this);
		action.addActionListener(this);
		animation.addActionListener(this);
		aventure.addActionListener(this);
		guerre.addActionListener(this);
		epouvantehorreur.addActionListener(this);
		comedie.addActionListener(this);
		drame.addActionListener(this);
		fantastique.addActionListener(this);
		policier.addActionListener(this);
		romance.addActionListener(this);
		science_fiction.addActionListener(this);
		western.addActionListener(this);
		return pannel;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == deconnexion){
			this.login = null;
			this.password = null;
			this.dispose();
			acceuil = new UserInterface();
			acceuil.setVisible(true);
		}
		if(e.getSource() == action){
			try {
				f.setBoutton("action");
				pannel.removeAll();
				pannel.add(this.affichage());
				pannel.add(f.liste(), BorderLayout.CENTER);
				this.setVisible(true);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource() == animation){
			try {
				f.setBoutton("animation");
				pannel.removeAll();
				pannel.add(this.affichage());
				pannel.add(f.liste(), BorderLayout.CENTER);
				this.setVisible(true);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource() == aventure){
			try {
				f.setBoutton("aventure");
				pannel.removeAll();
				pannel.add(this.affichage());
				pannel.add(f.liste(), BorderLayout.CENTER);
				this.setVisible(true);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource() == guerre){
			try {
				f.setBoutton("guerre");
				pannel.removeAll();
				pannel.add(this.affichage());
				pannel.add(f.liste(), BorderLayout.CENTER);
				this.setVisible(true);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource() == epouvantehorreur){
			try {
				f.setBoutton("epouvantehorreur");
				pannel.removeAll();
				pannel.add(this.affichage());
				pannel.add(f.liste(), BorderLayout.CENTER);
				this.setVisible(true);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource() == comedie){
			try {
				f.setBoutton("comedie");
				pannel.removeAll();
				pannel.add(this.affichage());
				pannel.add(f.liste(), BorderLayout.CENTER);
				this.setVisible(true);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource() == drame){
			try {
				f.setBoutton("drame");
				pannel.removeAll();
				pannel.add(this.affichage());
				pannel.add(f.liste(), BorderLayout.CENTER);
				this.setVisible(true);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource() == fantastique){
			try {
				f.setBoutton("fantastique");
				pannel.removeAll();
				pannel.add(this.affichage());
				pannel.add(f.liste(), BorderLayout.CENTER);
				this.setVisible(true);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource() == policier){
			try {
				f.setBoutton("policier");
				pannel.removeAll();
				pannel.add(this.affichage());
				pannel.add(f.liste(), BorderLayout.CENTER);
				this.setVisible(true);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource() == romance){
			try {
				f.setBoutton("romance");
				pannel.removeAll();
				pannel.add(this.affichage());
				pannel.add(f.liste(), BorderLayout.CENTER);
				this.setVisible(true);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource() == science_fiction){
			try {
				f.setBoutton("science_fiction");
				pannel.removeAll();
				pannel.add(this.affichage());
				pannel.add(f.liste(), BorderLayout.CENTER);
				this.setVisible(true);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource() == western){
			try {
				f.setBoutton("western");
				pannel.removeAll();
				pannel.add(this.affichage());
				pannel.add(f.liste(), BorderLayout.CENTER);
				this.setVisible(true);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}