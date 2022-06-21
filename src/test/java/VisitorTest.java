import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

}
