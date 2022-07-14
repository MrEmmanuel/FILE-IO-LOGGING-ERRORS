
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class VisitorTest {

   private DateTimeFormatter dateTimeFormatterMonth = DateTimeFormatter.ofPattern("yyyy/MM/dd");
   private DateTimeFormatter dateTimeFormatterTime = DateTimeFormatter.ofPattern("hh:mm");
   private LocalDateTime date;
   private LocalDateTime time;
   private Visitor visitor;

    @Test
    @DisplayName("This test should test a successful save of a visitor ")
    void createVisitorAndSuccessfulSave(){
        date = LocalDateTime.now();
        time = LocalDateTime.now();
        visitor = new Visitor("Oreneile Sejeso", 35, dateTimeFormatterMonth.format(date),
                dateTimeFormatterTime.format(time),"It was nice meeting you", "Emmanuel Marumo");
        try {
            assertTrue(visitor.save(),"File should be created successful and data be saved");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("This test should test loading visitor that was not saved")
    void createVisitorAndDontSave(){
        date = LocalDateTime.now();
        time = LocalDateTime.now();
        visitor = new Visitor("Cassper Nyovest", 38, dateTimeFormatterMonth.format(date),
                dateTimeFormatterTime.format(time),"It was great meeting you", "AKA Forbes");
        assertThrows(FileNotFoundException.class, () -> visitor.load("Cassper Nyovest"), "The visitor can't be loaded because file was not saved");
    }

    @Test
    @DisplayName("This should test loading a saved visitor and check if the output matches the expected output as per the saved data")
    void loadSavedVisitor(){
        date = LocalDateTime.now();
        String dateCaptured = dateTimeFormatterMonth.format(date);
        time = LocalDateTime.now();
        String timeCaptured = dateTimeFormatterTime.format(time);
        visitor = new Visitor("Paul Pogba", 29, dateCaptured,
                timeCaptured,"It was nice meeting you", "Monate Mpolaye");
        try {
            visitor.save();
            assertAll( ()-> assertTrue(visitor.load("Paul Pogba")),
                    () -> assertEquals(visitor.getFullName().compareTo("Paul Pogba"), 0),
                    () ->assertEquals(29,visitor.getAge()),
                    () -> assertEquals(visitor.getDate().compareTo(dateCaptured), 0),
                    () -> assertEquals(visitor.getTime().compareTo(timeCaptured), 0),
                    () -> assertEquals(visitor.getComments().compareTo("It was nice meeting you"), 0),
                    () -> assertEquals(visitor.getAssistor().compareTo("Monate Mpolaye"),0)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("This method test loading of visitor file that was not saved")
    void loadUnsavedVisitor(){
        date = LocalDateTime.now();
        time = LocalDateTime.now();
        visitor = new Visitor("Sadio Mane", 25,  dateTimeFormatterMonth.format(date),
                dateTimeFormatterTime.format(time), "It was nice meeting you", "Monate Mpolaye" );
        assertThrows(FileNotFoundException.class, () -> visitor.load("Sadio Mane"), "Should throw IO exception since file not found");
    }
}
