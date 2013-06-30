import java.sql.*;

public class Connexion {
	
	private Message message = new Message();
		
	public boolean connect(String login, String password) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/MyMovieList";
		String utilisateur = "root";
		String motDePasse = "ili688";
		Connection connexion = null;
		connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
		Statement statement = connexion.createStatement();
		ResultSet resultat = statement.executeQuery( "SELECT login, password FROM user;" );
		while (resultat.next()){
			if ((login.equals(resultat.getString("login"))) &&  (password.equals(resultat.getString("password")))){
				return true;
			}
		}
		message.erreurLog();
		return false;		
	}
	
	public boolean inscription(String login, String password) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/MyMovieList";
		String utilisateur = "root";
		String motDePasse = "ili688";
		Connection connexion = null;
		connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
		Statement statement = connexion.createStatement();
		ResultSet resultat = statement.executeQuery( "SELECT login, password FROM user;" );
		while (resultat.next())
			if ((login.equals(resultat.getString("login")))){
				message.erreur();
				return false;	
			}
			else if (login.equals("") && (password.equals(""))){
				message.erreurLog();
				return false;
			}
			statement.executeUpdate("INSERT INTO user (login,password)" + "VALUES ('"+ login +"', '"+ password +"');");
			statement.addBatch("CREATE TABLE "+login+" ( "
                    +"Titre VARCHAR( 255 ),"
                    +"Synopsis TEXT,"
                    +"Date_de_sortie INT(11),"
                    +"Realisateur VARCHAR(255)," 
                    +"Duree INT(11)," 
                    +"Image VARCHAR(255),"
                    +"Situation INT(11));");
			statement.executeBatch();

		return true;
				
	}
}
