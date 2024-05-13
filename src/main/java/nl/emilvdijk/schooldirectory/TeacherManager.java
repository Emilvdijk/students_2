package nl.emilvdijk.schooldirectory;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class TeacherManager {

  /**
   * private constructor to prevent instantiation
   */
  private TeacherManager() {
  }

  /**
   * checks through list of teachers and sends a mail to teachers that need to declare still
   * @param teacherlist list to go through
   */
  public static void mailDeclarationReminder(List<Person> teacherlist){
    LocalDate currentDate = LocalDate.now();
    Month date = currentDate.getMonth();
    for (Person teacher : teacherlist) {
      Teacher teacherCopy = (Teacher) teacher;
      if (!teacherCopy.checkCurrentMonthDeclaration()){
        Mailer.sendMail(teacher,"voor de maand "+date+" moet je uw uren nog declareren");
      }
    }
  }

}
