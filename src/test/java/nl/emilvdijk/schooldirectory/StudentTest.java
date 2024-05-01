package nl.emilvdijk.schooldirectory;

import static org.junit.jupiter.api.Assertions.*;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

class StudentTest {
  Faker faker=new Faker();
  Student jantje = new Student(faker.funnyName().name(),
      faker.number().numberBetween(0,69),
      faker.phoneNumber().phoneNumber(),
      faker.internet().emailAddress(),
      faker.address().streetAddress(),
      faker.address().city(),
      faker.number().numberBetween(0,9999));
  Mentor leraar = new Mentor(faker.funnyName().name(),
      faker.number().numberBetween(0,69),
      faker.phoneNumber().phoneNumber(),
      faker.internet().emailAddress(),
      faker.address().streetAddress(),
      faker.address().city(),
      faker.number().numberBetween(0,9999));


  @Test
  void testToString() {
    assertEquals(jantje.toString(),
        "naam: %-14s  leeftijd: %-5s  telefoonnr: %-18s e-mail: %-26s adres: %-22s woonplaats: %-18s studentnummer: %-8s %n".formatted(
            jantje.getName(),
            jantje.getAge(),
            jantje.getTelephoneNumber(),
            jantje.getEmail(),
            jantje.getAddress(),
            jantje.getPlace(),
            jantje.getStudentNumber()));
  }

  @Test
  void addSubject() {
    Subject chemistry = new Subject("chemistry",leraar,5);
    jantje.addSubject(chemistry,5);
    assertEquals(5, jantje.getSubjects().get(chemistry));
  }

  @Test
  void removeSubject() {
    Subject chemistry = new Subject("chemistry",leraar,5);
    jantje.addSubject(chemistry,5);
    assertEquals(5, jantje.getSubjects().get(chemistry));
    jantje.removeSubject(chemistry);
    assertNotEquals(5, jantje.getSubjects().get(chemistry));
  }

  @Test
  void getSubjects() {
    Subject chemistry = new Subject("chemistry", leraar, 5);
    jantje.addSubject(chemistry, 5);
    assertEquals(1, jantje.getSubjects().size());
  }

  @Test
  void setSubjectGrade() {
    Subject chemistry = new Subject("chemistry", leraar, 5);
    jantje.addSubject(chemistry, 5);
    assertEquals(5, jantje.getSubjects().get(chemistry));
    jantje.setSubjectGrade(chemistry,4);
    assertEquals(4, jantje.getSubjects().get(chemistry));

  }
}