package nl.emilvdijk.schooldirectory;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.Month;
import java.util.ArrayList;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TeacherManagerTest {

  final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @BeforeEach
  public void setUpStream() {
    System.setOut(new PrintStream(outContent, false, StandardCharsets.UTF_8));
  }

  @Test
  void mailDeclarationReminder() {
    Faker faker = new Faker();
    ArrayList<Person> people = new ArrayList<>();
    Teacher sampleTeach = new Teacher("teach1",
        faker.number().numberBetween(0, 69),
        faker.phoneNumber().phoneNumber(),
        faker.internet().emailAddress(),
        faker.address().streetAddress(),
        faker.address().city(),
        faker.number().numberBetween(0, 9999));
    sampleTeach.setHoursDeclared(Month.MAY,true);
    Teacher sampleTeach2 = new Teacher("teach2",
        faker.number().numberBetween(0, 69),
        faker.phoneNumber().phoneNumber(),
        faker.internet().emailAddress(),
        faker.address().streetAddress(),
        faker.address().city(),
        faker.number().numberBetween(0, 9999));
    sampleTeach2.setHoursDeclared(Month.MAY,true);
    Teacher sampleTeach3 = new Teacher("teach3",
        faker.number().numberBetween(0, 69),
        faker.phoneNumber().phoneNumber(),
        faker.internet().emailAddress(),
        faker.address().streetAddress(),
        faker.address().city(),
        faker.number().numberBetween(0, 9999));
    sampleTeach3.setHoursDeclared(Month.MAY,false);
    people.add(sampleTeach);
    people.add(sampleTeach2);
    people.add(sampleTeach3);
    TeacherManager.mailDeclarationReminder(people);
    String testOutput = outContent.toString();
    assertEquals("Greetings, teach3\r\n"
        + "\r\n"
        + "voor de maand MAY moet je uw uren nog declareren\r\n"
        + "\r\n"
        + "with kind regards", testOutput);
  }
}