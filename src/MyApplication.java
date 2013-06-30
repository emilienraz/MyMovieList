import javax.swing.*;

public class MyApplication{
	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				UserInterface fenetre = new UserInterface();
				fenetre.setVisible(true);
			}
		});
	}
}
