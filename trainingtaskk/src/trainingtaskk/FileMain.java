package trainingtaskk;

import java.util.ArrayList;

public class FileMain {

	public static void main(String[] args) {
		FileOperation reading = new FileOperation();
		ArrayList<FileData> dataRead = reading.readData();

		DBconnect db = new DBconnect();
		db.insertToDB(dataRead);
		db.retriveFromDB();

	}

}
