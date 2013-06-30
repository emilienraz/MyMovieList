import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Film {

	private String boutton;
	private JButton[] bouton;
	private int nb = 0;

	public void setBoutton(String str){
		boutton = str;
	}
	
	public JScrollPane liste() throws ClassNotFoundException, SQLException{
		int i=0;
		JPanel result= new JPanel(); 
		JScrollPane aff= new JScrollPane(result); 
		result.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		//GridBagConstraints.LAST_LINE_START = 0;
		//gbc.insets = new Insets(10, 20, 5, 00);
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/MyMovieList";
		String utilisateur = "root";
		String motDePasse = "ili688";
		Connection connexion = null;
		connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
		Statement statement = connexion.createStatement();
		ResultSet resultat = statement.executeQuery( "SELECT * FROM "+boutton+";" );
		while (resultat.next()){
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.anchor = GridBagConstraints.WEST;  
			gbc.gridx = 0 ;
			gbc.gridy = i;
			gbc.ipadx = 60;
			JLabel name = new JLabel(resultat.getString("Titre"));
			name.setForeground(Color.BLACK);
			result.add(name, gbc);
			
			gbc.gridx = 0;
			gbc.gridy = i+1;
			gbc.gridwidth = 1;
			gbc.ipadx = 60;
			ImageIcon img = new ImageIcon(resultat.getString("Image"));
			JLabel im = new JLabel(img);
			im.setPreferredSize(new Dimension(50,100));
			result.add(im, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = i+1;
			gbc.gridwidth = 1;
			gbc.ipadx = 150;
			gbc.ipady = 30;
			JTextArea syn = new JTextArea(resultat.getString("Synopsis"));
			syn.setLineWrap(true);
	        syn.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(syn);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setPreferredSize(new Dimension(250, 100));
			scrollPane.setForeground(Color.BLACK);
			result.add(scrollPane, gbc);
			i= i+30;
		
		}
		return aff;
	}
}

