package trainingtaskk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBconnect {
	private Logger logger = Logger.getLogger(FileOperation.class.getName());

	public void insertToDB(ArrayList<FileData> dataRead) {

		String jdbcURL = "jdbc:postgresql://localhost:5432/Project";
		String username = "trainee";
		String password = "akshay";

		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);

			System.out.println("connected for inserting");

			String sql = "INSERT INTO tasktable(id,name,age)" + "VALUES(?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			for (int i = 0; i < dataRead.size(); i++) {
				FileData op = dataRead.get(i);
				statement.setLong(1, op.getId());
				statement.setString(2, op.getName());
				statement.setLong(3, op.getAge());
				statement.executeUpdate();
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			logger.log(Level.INFO, "problem be in connection or in the sql database", e);
		} catch (Exception z) {
			logger.log(Level.INFO, "problem in storing the data from statement ", z);
		}
	}

	@SuppressWarnings("unused")
	public void retriveFromDB() {

		String jdbcURL = "jdbc:postgresql://localhost:5432/Project";
		String username = "trainee";
		String password = "akshay";

		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("connected for retrieving");

			String sql = "SELECT * FROM tasktable";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);

			System.out.println("retrieving from database.................");
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				int age = result.getInt("age");

				String line = String.format(" %s\",%s,%s", id, name, age);

				System.out.println(id + "," + name + "," + age);
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "problem in selection process from table or in sql connection ", e);
		}

	}
}
