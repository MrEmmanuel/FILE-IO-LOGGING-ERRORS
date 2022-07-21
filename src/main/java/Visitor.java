import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Visitor {

    private String fullName;
    private int age;
    private String dateOfVisit;
    private String timeOfVisit;
    private String comments;
    private String nameOfAssistor;
    private String fileName = " ";
    private String data = " ";

    static Logger logger = LogManager.getLogger(Visitor.class);
    public  Visitor(String name, int age, String date, String time, String comments, String assistor ){
        this.fullName = name;
        this.age = age;
        this.dateOfVisit = date;
        this.timeOfVisit = time;
        this.comments = comments;
        this.nameOfAssistor = assistor;
    }

    public boolean save() {
        this.fileName = "visitor_"+ fullName.replaceAll(" ", "_").toLowerCase() + ".txt";
        File visitorData = new File(fileName);
        try {
            if (fileName.equals("visitor_.txt")) {
                throw new IOException("File needs a name");
            }

            if (visitorData.createNewFile()) {
                data += fullName + " Age: " + age + " | Date: " + dateOfVisit +
                        " | Time: " + timeOfVisit + " | comment: " + comments + " | Assisted by : " + nameOfAssistor;
                logger.info("\nFile created: " + visitorData.getName());
            } else {
                data += "\n Date: " + dateOfVisit + " | Time: " + timeOfVisit + " | comment: " + comments + " | Assisted by : " + nameOfAssistor;
                logger.info("\nFile already exist and new information was added");

            }
            Files.write(Paths.get(fileName), data.getBytes(), StandardOpenOption.APPEND);
            return visitorData.exists();
        } catch (IOException e) {
            logger.info(e.toString());
            return false;
        }
    }

    public static boolean load(String full_name) throws FileNotFoundException {
        try {
            String retrieve = full_name.replaceAll(" ", "_").toLowerCase();
            BufferedReader file = new BufferedReader(new FileReader("visitor_" + retrieve + ".txt"));
            String line;
            while ((line = file.readLine()) != null) {
                System.out.println(line);
            }
            logger.info("\nRead was successful.");
            file.close();
            return true;
        } catch (IOException e) {
            logger.info(e.toString());
            throw new FileNotFoundException();
        }
    }
    public String getFullName(){
        return this.fullName;
    }
    public int getAge(){
        return this.age;
    }
    public String getDate(){
        return this.dateOfVisit;
    }
    public String getTime(){
        return this.timeOfVisit;
    }
    public String getComments(){
        return this.comments;
    }
    public String getAssistor(){
        return this.nameOfAssistor;
    }
}
