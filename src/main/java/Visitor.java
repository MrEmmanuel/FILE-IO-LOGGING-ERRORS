import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Visitor {

    private String fullName;
    private int age;
    private String dateOfVisit;
    private String timeOfVisit;
    private String comments;
    private String nameOfAssistor;

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

        return false;
    }

}
