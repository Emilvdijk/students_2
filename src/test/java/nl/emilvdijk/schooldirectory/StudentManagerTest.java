package nl.emilvdijk.schooldirectory;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentManagerTest {

  final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @BeforeEach
  public void setUpStream() {
    System.setOut(new PrintStream(outContent, false, StandardCharsets.UTF_8));
  }


  @Test
  void testMailFailingStudents() {
    Student eric = new Student("Eric", 12, "346575764", "nice@nice.com", "Nicestraat 1", "Nicestad",
        34);
    Student jantje = new Student("Jantje", 5, "23452345", "nice3@nice3.com", "Nicewijk 2",
        "Niceplek", 36);
    Student evelien = new Student("Evelien", 34, "23452345", "nice2@nice2.com", "Niceweg 3",
        "Nicedorp", 35);
    Mentor daan = new Mentor("Daan", 55, "2345234532", "nice@school.com", "Schoolstraat",
        "Schoolstad", 55);
    Subject chemistry = new Subject("chemistry",daan,5);
    Subject english = new Subject("english",daan,10);
    eric.setSubjectGrade(chemistry,5);
    jantje.setSubjectGrade(chemistry,6);
    evelien.setSubjectGrade(chemistry,7);
    eric.setSubjectGrade(english,7);
    jantje.setSubjectGrade(english,5);
    evelien.setSubjectGrade(english,5);
    ArrayList<Person> studentsList = new ArrayList<>();
    studentsList.add(eric);
    studentsList.add(jantje);
    studentsList.add(evelien);
    StudentManager.mailFailingStudents(studentsList,chemistry);
    String testOutput = outContent.toString();
    assertEquals("Greetings, Eric\r\n"
        + "\r\n"
        + "doe eens beter je best.\r\n"
        + "\r\n"
        + "with kind regards",testOutput);
    outContent.reset();
    StudentManager.mailFailingStudents(studentsList,english,"doe beter je best.");
    testOutput = outContent.toString();
    assertEquals("Greetings, Jantje\r\n"
        + "\r\n"
        + "doe beter je best.\r\n"
        + "\r\n"
        + "with kind regardsGreetings, Evelien\r\n"
        + "\r\n"
        + "doe beter je best.\r\n"
        + "\r\n"
        + "with kind regards",testOutput);
  }
}