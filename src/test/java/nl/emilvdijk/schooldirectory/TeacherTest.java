package nl.emilvdijk.schooldirectory;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Month;
import java.util.HashMap;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

class TeacherTest {

  Faker faker=new Faker();
  Mentor leraar = new Mentor(faker.funnyName().name(),faker.number().numberBetween(0,69),faker.phoneNumber().phoneNumber(),faker.internet().emailAddress(), faker.address().streetAddress(),faker.address().city(),faker.number().numberBetween(0,9999));

  @Test
  void setHoursDeclared() {
    leraar.setHoursDeclared(Month.of(1),true);
    assertEquals(true,leraar.getHoursDeclared().get(Month.of(1)));
    leraar.setHoursDeclared(Month.of(1),false);
    assertEquals(false,leraar.getHoursDeclared().get(Month.of(1)));
    assertNull(leraar.getHoursDeclared().get(Month.of(2)));
  }

  @Test
  void getHoursDeclared() {
    leraar.setHoursDeclared(Month.of(1),true);
    HashMap<Month,Boolean> newMap = leraar.getHoursDeclared();
    assertEquals(true,newMap.get(Month.of(1)));
    assertNull(newMap.get(Month.of(2)));

  }
}
