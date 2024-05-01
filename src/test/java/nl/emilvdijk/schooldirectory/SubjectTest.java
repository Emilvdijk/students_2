package nl.emilvdijk.schooldirectory;

import static org.junit.jupiter.api.Assertions.*;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

class SubjectTest {

  Faker faker = new Faker();
  Mentor leraar = new Mentor(
      faker.pokemon().name(),
      faker.number().numberBetween(0, 69),
      faker.phoneNumber().phoneNumber(),
      faker.internet().emailAddress(),
      faker.address().streetAddress(),
      faker.address().city(),
      faker.number().numberBetween(0, 9999));

  Subject subject = new Subject(
      "faker.beer().name()",
      leraar,
      5);

  Subject subject2 = new Subject(
      faker.beer().name(),
      leraar,
      faker.number().numberBetween(0, 9999));

  @Test
  void getName() {
    assertEquals("faker.beer().name()",subject.getName());
  }

  @Test
  void getTeacher() {
    assertEquals(leraar,subject2.getTeacher());
  }

  @Test
  void getMaxsize() {
    assertEquals(5,subject.getMaxsize());
  }

  @Test
  void testToString() {
    assertEquals(subject.toString(),
        "name: %-14s leraar: %-14s  max leerlingen: %-4s".formatted(
            subject.getName(),
            subject.getTeacher().getName(),
            subject.getMaxsize()
        ));

  }

  @Test
  void testEquals() {
    Subject subject3 = new Subject(
        "faker.beer().name()",
        leraar,
        5);
    assertEquals(subject, subject3);

  }
}