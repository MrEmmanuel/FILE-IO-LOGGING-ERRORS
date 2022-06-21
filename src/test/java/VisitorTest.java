import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VisitorTest {

    @Test
    void saveTest() throws IOException {
        DateTimeFormatter dateTimeFormatterMonth = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatterTime = DateTimeFormatter.ofPattern( "hh:mm");
        LocalDateTime time = LocalDateTime.now();
        Visitor saveVisitor = new Visitor("Sadio Mane", 35, dateTimeFormatterMonth.format(date),
                dateTimeFormatterTime.format(time),"It was nice meeting you", "Oreneile Sejeso");
        assertTrue(saveVisitor.save(),"File should be created successful and data be saved");

    }

    @Test
    void saveEmpty(){
        Visitor testPathExist = new Visitor();
        assertThrows(IOException.class, testPathExist::save,"The file cannot be created with an empty name");
    }

    @Test
    void load() throws IOException {
        Visitor fetch = new Visitor();
        assertTrue(fetch.load("Alice Cooper"),"Before you test make sure visitor_alice_cooper.txt exit in the root directory");
    }

    @Test
    void loadFailing(){
        Visitor testFile = new Visitor();
        assertThrows(FileNotFoundException.class, () -> testFile.load("Oreneile Sejeso"), "Should throw since file not found");
    }

}
