import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class UserInterface extends JFrame implements ActionListener{
	
	private JButton connect;
	private JButton inscrpt;
	private Connexion conn;
	private JTextField log;
	private JPasswordField pswd;
	private JTextField l;
	private JPasswordField p;
	private Member membre;
	
	
	public UserInterface(){
		super();	
		build();
		membre = new Member();
		conn = new Connexion();
	}
	
	public void build (){
		setTitle("MyMovieList");
		setSize(800,600);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(buildContentPane());
		
	}
	
	public JTextField getTextFieldlog(){
		return log;
	}
	
	public JPasswordField getTextFieldpswd(){
		return pswd;
	}
	
	public JTextField getTextFieldl(){
		return l;
	}
	
	public JPasswordField getTextFieldp(){
		return p;
	}
	
	private JPanel buildContentPane(){
		JPanel pannel = new JPanel();
		JPanel pConnect = new JPanel();
		JPanel inscription = new JPanel();
		JPanel intro = new JPanel();
 		
		pannel.setLayout(new BorderLayout());
		pConnect.setLayout(new GridBagLayout());
		inscription.setLayout(new GridBagLayout());
		pannel.setBackground(Color.LIGHT_GRAY);
		pConnect.setBackground(Color.DARK_GRAY);
		inscription.setBackground(Color.LIGHT_GRAY);
		
		TitledBorder titled = new TitledBorder("Inscription");
		inscription.setBorder(titled);
		
	    
		intro.setBackground(Color.DARK_GRAY);	
		intro.setPreferredSize(new Dimension(575,20));
	 
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagConstraints inscript = new GridBagConstraints();
		
		gbc.insets = new Insets(5, 20, 5, 00);
		inscript.insets = new Insets(5, 20, 5, 00);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		l = new JTextField(8);
		inscription.add(l, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel title = new JLabel("MyMovieList");		
		title.setForeground(Color.RED);
		pConnect.add(title, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		JLabel login = new JLabel("Login");
		login.setPreferredSize(new Dimension(90,20));
		login.setForeground(Color.WHITE);
		pConnect.add(login, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		JLabel password = new JLabel("Password");
		password.setPreferredSize(new Dimension(90,20));
		password.setForeground(Color.WHITE);
		pConnect.add(password, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		log = new JTextField(8);
		pConnect.add(log, gbc);	
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		pswd = new JPasswordField(8);
		pConnect.add(pswd, gbc);
		
		connect = new JButton("Connection");
		gbc.gridx = 4;
		gbc.gridy = 1;
		pConnect.add(connect, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel  ins= new JLabel("Inscription");		
		ins.setForeground(Color.RED);
		inscription.add(ins, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel lg = new JLabel("Login");
		lg.setForeground(Color.BLACK);
		inscription.add(lg, gbc);
				
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel pass = new JLabel("Password");
		pass.setForeground(Color.BLACK);
		inscription.add(pass, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		p = new JPasswordField(8);
		inscription.add(p, gbc);
		
		inscrpt = new JButton("Inscription");
		gbc.gridx = 1;
		gbc.gridy = 3;
		inscription.add(inscrpt, gbc);
		
		ImageIcon img = new ImageIcon("Image/logo.jpg");
		img.getIconHeight();
		img.getIconWidth();
		JLabel lab = new JLabel(img);
		intro.add(lab);
		
		pannel.add(pConnect, BorderLayout.NORTH);
		pannel.add(inscription, BorderLayout.EAST);
		pannel.add(intro, BorderLayout.WEST);
		
		connect.addActionListener(this);
		inscrpt.addActionListener(this);
		
		return pannel;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource() == connect){
			try{
				membre.setLogin(getTextFieldlog().getText());
				membre.setPassword(getTextFieldpswd().getText());
				if(conn.connect(membre.getLogin(), membre.getPassword())){
					this.dispose();
					membre.connect();
					membre.setVisible(true);
				}
			} catch (ClassNotFoundException e2){
				e2.printStackTrace();
			} catch (SQLException e1){
				e1.printStackTrace();
			}
			
		}
		else if(e.getSource() == inscrpt){
			try{
				membre.setLogin(getTextFieldl().getText());
				membre.setPassword(getTextFieldp().getText());
				if(conn.inscription(membre.getLogin(), membre.getPassword())){
					this.dispose();
					membre.connect();
					membre.setVisible(true);
				}
			} catch (ClassNotFoundException e2){
				e2.printStackTrace();
			} catch (SQLException e1){
				e1.printStackTrace();
			}
		}
		
	}
}