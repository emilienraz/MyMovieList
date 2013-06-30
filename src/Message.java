import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Message extends JDialog implements ActionListener {
	
	private JDialog dialog;
	private JPanel dial;
	private JButton ok;
	private JLabel label;
	
	public void erreur (){
		dialog = new JDialog();
		dialog.setSize(200, 150);
		dialog.setTitle("Erreur");
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		dialog.setResizable(false);
		dialog.setAlwaysOnTop(true);
		
		dial = new JPanel();
		dial.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(25, 20, 5, 00);
		
		label = new JLabel("Le Login existe deja !");
		gbc.gridx = 1;
		gbc.gridy = 1;
		dial.add(label, gbc);
		
		ok = new JButton(" OK ");
		ok.setPreferredSize(new Dimension(90,50));
		gbc.gridx = 1;
		gbc.gridy = 3;
		dial.add(ok,gbc);
		
		
		dialog.add(dial);
		ok.addActionListener(this);
		
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		}
	
	public void erreurLog (){
		dialog = new JDialog();
		dialog.setSize(300, 150);
		dialog.setTitle("Erreur");
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		dialog.setResizable(false);
		dialog.setAlwaysOnTop(true);
				
		dial = new JPanel();
		dial.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(25, 20, 5, 00);
		
		label = new JLabel("Login ou Mot de Passe Incorrect !");
		gbc.gridx = 1;
		gbc.gridy = 1;
		dial.add(label, gbc);
		
		ok = new JButton(" OK ");
		ok.setPreferredSize(new Dimension(90,50));
		gbc.gridx = 1;
		gbc.gridy = 3;
		dial.add(ok,gbc);
		
		
		dialog.add(dial);
		ok.addActionListener(this);
		
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		}
	
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource() == ok ){
			dialog.dispose();
		}
	}
	
}
