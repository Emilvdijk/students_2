package nl.emilvdijk.schooldirectory;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MailerTest {

  final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @BeforeEach
  public void setUpStream() {
    System.setOut(new PrintStream(outContent, false, StandardCharsets.UTF_8));
  }

  @Test
  void sendMail() {
    Faker faker = new Faker();
    Teacher sampleTeach = new Teacher("Sample",
        faker.number().numberBetween(0, 69),
        faker.phoneNumber().phoneNumber(),
        faker.internet().emailAddress(),
        faker.address().streetAddress(),
        faker.address().city(),
        faker.number().numberBetween(0, 9999));

    Mailer.sendMail(sampleTeach,"nice contents");
    String testOutput = outContent.toString();
    assertEquals("Greetings, Sample\r\n"
        + "\r\n"
        + "nice contents\r\n"
        + "\r\n"
        + "with kind regards",testOutput);

  }
}