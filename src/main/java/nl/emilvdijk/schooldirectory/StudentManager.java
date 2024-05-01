package nl.emilvdijk.schooldirectory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

class StudentManager {

  /**
   * private constructor to prevent instantiation
   */
  private StudentManager(){
  }
  private static final String STANDARD_MESSAGE = "doe eens beter je best.";


  /**
   * 3 option switch case controlled with input
   *
   * @param myScanner reuse scanner from main
   * @param emailPattern  pattern to check email validity
   * @param studentsList list to manage
   */
  static void manageStudents(Scanner myScanner, Pattern emailPattern,
      ArrayList<Person> studentsList) {
    String ch;
    do {
      do {
        System.out.println("""
            Opties voor studenten:
            1 om een student toe te voegen.
            2 om een student te verwijderen.
            3 om alle studenten te tonen.
            q om terug te gaan naar het menu.""");
        ch = myScanner.nextLine();
      } while ((ch == "1") || (ch == "2") || (ch == "3") && (ch != "q"));

      switch (ch) {
        case "1":
          // ask input and makes student object and adds student to list
          addNewStudent(myScanner, emailPattern, studentsList);
          break;

        // ask for input and removes student
        case "2":
          deleteStudent(myScanner, studentsList);
          break;

        // prints out all students
        case "3":
          printStudents(studentsList);
      }

    } while (!ch.equals("q"));
  }

  /**
   * asks input and adds new student to studentlist with input
   * @param myScanner reuse from main
   * @param emailPattern pattern to check email validity
   * @param studentsList list to add student
   */
  private static void addNewStudent(Scanner myScanner, Pattern emailPattern,
      ArrayList<Person> studentsList) {
    System.out.println(
        "Vul de naam van de nieuwe student in of \"q\" om te annuleren: \n");
    String studentName = myScanner.nextLine();
    if (Objects.equals(studentName, "q")) {
      return;
    }

    System.out.println("Vul de leeftijd van de nieuwe student in: \n");

    while (!myScanner.hasNextInt()) {
      System.out.println("vul een cijfer in voor leeftijd!");
      myScanner.next();
    }
    int studentAge = myScanner.nextInt();
    myScanner.skip("\n");
    System.out.println("Vul het telefoonnummer van de nieuwe student in: \n");

    while (!myScanner.hasNextInt()) {
      System.out.println("vul een geldig telefoonnummer in!");
      myScanner.next();
    }
    String studentPhone = String.valueOf(myScanner.nextInt());
    myScanner.skip("\n");

    System.out.println("Vul het e-mail adress in van de nieuwe student: \n");
    while (!myScanner.hasNext(emailPattern)) {
      System.out.println("Please enter a valid email address: ");
      myScanner.next();
    }
    String studentEmail = myScanner.nextLine();

    System.out.println("Vul het adress van de nieuwe student in: \n");
    String studentAdress = myScanner.nextLine();

    System.out.println("Vul de woonplaats van de nieuwe student in: \n");
    String studentPlace = myScanner.nextLine();

    System.out.println("Vul het studentnummer van de nieuwe student in: \n");
    while (!myScanner.hasNextInt()) {
      System.out.println("vul een geldig studentnummer in!");
      myScanner.next();
    }
    int studentNumber = myScanner.nextInt();
    myScanner.skip("\n");

    Student newStudent = new Student(studentName, studentAge, studentPhone,
        studentEmail, studentAdress,
        studentPlace, studentNumber);
    studentsList.add(newStudent);
  }

  /**
   * deletes selected student from list
   * @param myScanner reuse from main
   * @param studentsList list to delete student from
   */
  private static void deleteStudent(Scanner myScanner, ArrayList<Person> studentsList) {
    if (studentsList.isEmpty()) {
      System.out.println("de studentenlijst is leeg");
      return;
    }
    int y = 1;
    System.out.println("welke student wil je verwijderen:");
    for (; y - 1 < studentsList.size(); y++) {
      System.out.printf("%s  %s%n", y, studentsList.get(y - 1).getName());
    }
    int choice;
    do {
      choice = myScanner.nextInt();
    } while (!(choice >= 1 && choice <= y - 1));
    myScanner.skip("\n");
    studentsList.remove(choice - 1);
  }

  /**
   * prints out student info with printer method from Student class
   * @param studentsList list to print
   */
  private static void printStudents(ArrayList<Person> studentsList) {
    if (studentsList.isEmpty()) {
      System.out.println("de studentenlijst is leeg");
      return;
    }
    for (Person student : studentsList) {
      System.out.print(student.toString());
    }
    System.out.println();
  }

  /**
   * sends an email with specified message to students who are failing a specified subject
   * @param studentsList    list of students to go through
   * @param subject         subject to check
   * @param message         message to send the students
   */
  static void mailFailingStudents(ArrayList<Person> studentsList, Subject subject, String message){
    for (Person person : studentsList) {
      Student student = (Student) person;
      HashMap<Subject,Integer> mapCopy = student.getSubjects();
      if (mapCopy.get(subject)<6){
        Mailer.sendMail(person,message);
      }
    }
  }

  /**
   * overloaded method sending a standard message
   * @param studentsList  list of students to go through
   * @param subject       subject to check
   */
  static void mailFailingStudents(ArrayList<Person> studentsList, Subject subject){
    mailFailingStudents(studentsList,subject, STANDARD_MESSAGE);
  }

}
