import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
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
    private String fileName = "";
    private String data;

    Logger logger = LogManager.getLogger(Visitor.class);
    public  Visitor(String name, int age, String date, String time, String comments, String assistor ){
        this.fullName = name;
        this.age = age;
        this.dateOfVisit = date;
        this.timeOfVisit = time;
        this.comments = comments;
        this.nameOfAssistor = assistor;
    }

    public boolean save() throws IOException{
        File visitorData = new File(fileName);
        if(fileName.equals("visitor_.txt")){
            throw new IOException("File needs a name");
        }

        if (visitorData.createNewFile()) {
            data += fullName + " Age: " + age + " | Date: " + dateOfVisit +
                    " | Time: " + timeOfVisit + " | comment: " + comments + " | Assisted by : " + nameOfAssistor;
            logger.info("\nFile created: " + visitorData.getName());
        }
        else {
            data += "\n Date: "+ dateOfVisit + " | Time: "+ timeOfVisit +" | comment: "+ comments + " | Assisted by : "+ nameOfAssistor;
            logger.info("\nFile already exist and new information was added");
        }
        Files.write(Paths.get(fileName), data.getBytes(), StandardOpenOption.APPEND);
        return visitorData.exists();
    }

    

}
