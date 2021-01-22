package trainingtaskk;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileOperation {
	private Logger logger = Logger.getLogger(FileOperation.class.getName());

	@SuppressWarnings("resource")
	public ArrayList<FileData> readData() {

		ArrayList<FileData> data = new ArrayList<>();

		try {
			BufferedReader readingInfo = new BufferedReader(
					new FileReader("E:\\Data\\Trainee4\\workspace/StudentInfo.csv"));
			String str = null;
			readingInfo.readLine();
			while ((str = readingInfo.readLine()) != null) {
				String array[] = str.split(",");
				FileData file = new FileData();
				file.setId(Integer.parseInt(array[0]));
				file.setName(array[1]);
				file.setAge(Integer.parseInt(array[2]));
				data.add(file);
			}
		} catch (FileNotFoundException e) {
			logger.log(Level.INFO, "problem in file or while reading file ", e);
		} catch (NumberFormatException k) {
			logger.log(Level.WARNING, "problem in string array or storing in array ", k);
		} catch (Exception p) {
			logger.log(Level.SEVERE, "problem in main class ", p);
		}
		return data;
	}
}
