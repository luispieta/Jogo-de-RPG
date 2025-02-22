package BancoDeDados;

import java.sql.Connection; 
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		try {
			Connection connection = DatabaseConnection.conectar();
			System.out.println(connection);
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	
	}

}
