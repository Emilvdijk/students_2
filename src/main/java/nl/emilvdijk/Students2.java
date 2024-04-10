package nl.emilvdijk;


import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;


class Students2 {

  /**
   * school database system where mentors, students and classes can be added and removed and mentors
   * and students can be added and removed from classes
   *
   * @param args not used
   */
  public static void main(String[] args) {
    String ch;
    Scanner myScanner = new Scanner(System.in);
    Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");

    // 3 examples added for students mentors and classes and notify they have been added
    ArrayList<Student> javaStudentList = new ArrayList<>();
    ArrayList<Student> htmlStudentList = new ArrayList<>();
    ArrayList<Student> pythonStudentList = new ArrayList<>();
    ArrayList<Student> studentsList = new ArrayList<>();
    createStudents(studentsList, javaStudentList, pythonStudentList, htmlStudentList);

    ArrayList<Mentor> pythonMentorList = new ArrayList<>();
    ArrayList<Mentor> javaMentorList = new ArrayList<>();
    ArrayList<Mentor> htmlMentorList = new ArrayList<>();
    ArrayList<Mentor> mentorsList = new ArrayList<>();
    createMentors(mentorsList, javaMentorList, htmlMentorList, pythonMentorList);

    ArrayList<Classes> classesList = new ArrayList<>();
    createClasses(javaMentorList, javaStudentList, pythonMentorList, pythonStudentList,
        htmlMentorList,
        htmlStudentList, classesList);
    System.out.println("er zijn voorbeelden toevevoegd.");
    // end of example adding code

    // main menu of the system where inputs are asked
    do {
      do {
        System.out.println("""
            Welkom in het studentendatabasesysteem v2.
            1 voor studenten.
            2 voor mentoren.
            3 voor klassen.
            'quit' om het programma af te sluiten.""");
        ch = myScanner.nextLine();
      } while ((ch == "1") || (ch == "2") || (ch == "3") && (ch != "quit"));

      // choices for adding removing or showing of students
      switch (ch) {
        case "1":
          manageStudents(myScanner, emailPattern, studentsList);
          break;

        // choices for adding, removing or showing of mentors
        case "2":
          manageMentors(myScanner, emailPattern, mentorsList);
          break;

        // choices for classes like adding a class or changing its occupants
        case "3":
          ClassManager.manageClasses(myScanner, classesList, mentorsList, studentsList);
          break;
      }
    } while (!ch.equals("quit"));
  }

  /**
   * manage mentorlist switchcase
   *
   * @param myScanner reuse scanner from main
   * @param emailPattern pattern to check email validity
   * @param mentorsList list to manage
   */
  private static void manageMentors(Scanner myScanner, Pattern emailPattern,
      ArrayList<Mentor> mentorsList) {
    String ch;
    do {
      do {
        System.out.println("""
            Opties voor mentoren:
            1 om een mentor toe te voegen.
            2 om een mentor te verwijderen.
            3 om alle mentoren te tonen.
            q om terug te gaan naar het menu.""");
        ch = myScanner.nextLine();
      } while ((ch == "1") || (ch == "2") || (ch == "3") && (ch != "q"));

      switch (ch) {

        // ask for input and makes mentor object and adds it to list
        case "1":
          addNewMentor(myScanner, emailPattern, mentorsList);
          break;

        // ask for input and removes mentor object
        case "2":
          deleteMentor(myScanner, mentorsList);
          break;

        // prints out all mentors and details
        case "3":
          printMentors(mentorsList);
      }
    } while (!ch.equals("q"));
  }

  /**
   * asks input and adds new mentor to mentorlist with input
   *
   * @param myScanner reuse scanner from main
   * @param emailPattern pattern to check email validity
   * @param mentorsList list to add mentor to
   */
  private static void addNewMentor(Scanner myScanner, Pattern emailPattern,
      ArrayList<Mentor> mentorsList) {
    System.out.println(
        "Vul de naam van de nieuwe mentor in of \"q\" om te annuleren: \n");
    String mentorName = myScanner.nextLine();
    if (Objects.equals(mentorName, "q")) {
      return;
    }

    System.out.println("Vul de leeftijd van de mentor student in: \n");

    while (!myScanner.hasNextInt()) {
      System.out.println("vul een cijfer in voor leeftijd!");
      myScanner.next();
    }
    int mentorAge = myScanner.nextInt();
    myScanner.skip("\n");
    System.out.println("Vul het telefoonnummer van de nieuwe mentor in: \n");

    while (!myScanner.hasNextInt()) {
      System.out.println("vul een geldig telefoonnummer in!");
      myScanner.next();
    }
    String mentorPhone = String.valueOf(myScanner.nextInt());
    myScanner.skip("\n");

    System.out.println("Vul het e-mail adress van de nieuwe mentor in: \n");
    while (!myScanner.hasNext(emailPattern)) {
      System.out.println("Please enter a valid email address: ");
      myScanner.next();
    }
    String mentorEmail = myScanner.nextLine();

    System.out.println("Vul het adress van de nieuwe mentor in: \n");
    String mentorAdress = myScanner.nextLine();

    System.out.println("Vul de woonplaats van de nieuwe mentor in: \n");
    String mentorPlace = myScanner.nextLine();

    System.out.println("Vul het werknemernummer van de nieuwe mentor in: \n");
    while (!myScanner.hasNextInt()) {
      System.out.println("vul een geldig werknemernummer in!");
      myScanner.next();
    }
    int mentorNumber = myScanner.nextInt();

    Mentor newMentor = new Mentor(mentorName, mentorAge, mentorPhone, mentorEmail,
        mentorAdress,
        mentorPlace, mentorNumber);
    mentorsList.add(newMentor);
  }

  /**
   * ask input and delete selected mentor from list
   *
   * @param myScanner   reuse from main
   * @param mentorsList list to delete mentor from
   */
  private static void deleteMentor(Scanner myScanner, ArrayList<Mentor> mentorsList) {
    if (mentorsList.isEmpty()) {
      System.out.println("de mentorenlijst is leeg");
      return;
    }
    int y = 1;
    System.out.println("welke mentor wil je verwijderen:");
    for (; y - 1 < mentorsList.size(); y++) {
      System.out.printf("%s  %s%n", y, mentorsList.get(y - 1).name);
    }
    int choice;
    do {
      choice = myScanner.nextInt();
    } while (!(choice >= 1 && choice <= y - 1));
    myScanner.skip("\n");
    mentorsList.remove(choice - 1);
  }

  /**
   * uses methed from Mentor class to print out mentor info
   * @param mentorsList list to print out
   */
  private static void printMentors(ArrayList<Mentor> mentorsList) {
    if (mentorsList.isEmpty()) {
      System.out.println("de mentorenlijst is leeg");
      return;
    }
    for (Mentor mentor : mentorsList) {
      mentor.mentorPrinter();
    }
    System.out.println();
  }

  /**
   * 3 option switch case controlled with input
   *
   * @param myScanner reuse scanner from main
   * @param emailPattern  pattern to check email validity
   * @param studentsList list to manage
   */
  private static void manageStudents(Scanner myScanner, Pattern emailPattern,
      ArrayList<Student> studentsList) {
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
      ArrayList<Student> studentsList) {
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
  private static void deleteStudent(Scanner myScanner, ArrayList<Student> studentsList) {
    if (studentsList.isEmpty()) {
      System.out.println("de studentenlijst is leeg");
      return;
    }
    int y = 1;
    System.out.println("welke student wil je verwijderen:");
    for (; y - 1 < studentsList.size(); y++) {
      System.out.printf("%s  %s%n", y, studentsList.get(y - 1).name);
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
  private static void printStudents(ArrayList<Student> studentsList) {
    if (studentsList.isEmpty()) {
      System.out.println("de studentenlijst is leeg");
      return;
    }
    for (Student student : studentsList) {
      student.studentPrinter();
    }
    System.out.println();
  }


  /**
   * creates excample classes
   * @param javaMentorList list of mentors for java class
   * @param javaStudentList list of students for java class
   * @param pythonMentorList list of mentors for python class
   * @param pythonStudentList list of students for python class
   * @param htmlMentorList list of mentors for html class
   * @param htmlStudentList list of students for html class
   * @param classesList list of classes to add examples to
   */
  private static void createClasses(ArrayList<Mentor> javaMentorList,
      ArrayList<Student> javaStudentList, ArrayList<Mentor> pythonMentorList,
      ArrayList<Student> pythonStudentList, ArrayList<Mentor> htmlMentorList,
      ArrayList<Student> htmlStudentList, ArrayList<Classes> classesList) {
    Classes java = new Classes("Java", javaMentorList, javaStudentList);
    Classes python = new Classes("Python", pythonMentorList, pythonStudentList);
    Classes html = new Classes("HTML", htmlMentorList, htmlStudentList);
    classesList.add(java);
    classesList.add(python);
    classesList.add(html);
  }


  /**
   * adds example mentors and adds some to example classes
   * @param mentorsList list of mentors for examples to be added to
   * @param javaMentorList java example class list to add to
   * @param htmlMentorList html example class list to add to
   * @param pythonMentorList python example class list to add to
   */
  private static void createMentors(ArrayList<Mentor> mentorsList, ArrayList<Mentor> javaMentorList,
      ArrayList<Mentor> htmlMentorList, ArrayList<Mentor> pythonMentorList) {
    Mentor daan = new Mentor("Daan", 55, "2345234532", "nice@school.com", "Schoolstraat",
        "Schoolstad", 55);
    Mentor david = new Mentor("David", 57, "56785867", "nice2@school2.com", "Schoolweg",
        "Schooldorp", 56);
    Mentor simone = new Mentor("Simone", 99, "96964623", "nice3@school3.com", "Schoolwijk",
        "Schoolplek", 57);
    mentorsList.add(daan);
    mentorsList.add(david);
    mentorsList.add(simone);
    javaMentorList.add(daan);
    htmlMentorList.add(simone);
    pythonMentorList.add(david);
  }

  /**
   * adds example students and adds some to example classes
   * @param studentsList list of students for examples to be added to
   * @param javaStudentList java example class list to add to
   * @param pythonStudentList html example class list to add to
   * @param htmlStudentList python example class list to add to
   */
  private static void createStudents(ArrayList<Student> studentsList,
      ArrayList<Student> javaStudentList,
      ArrayList<Student> pythonStudentList, ArrayList<Student> htmlStudentList) {
    Student eric = new Student("Eric", 12, "346575764", "nice@nice.com", "Nicestraat 1", "Nicestad",
        34);
    Student jantje = new Student("Jantje", 5, "23452345", "nice3@nice3.com", "Nicewijk 2",
        "Niceplek", 36);
    Student evelien = new Student("Evelien", 34, "23452345", "nice2@nice2.com", "Niceweg 3",
        "Nicedorp", 35);
    studentsList.add(eric);
    studentsList.add(jantje);
    studentsList.add(evelien);
    javaStudentList.add(jantje);
    javaStudentList.add(evelien);
    pythonStudentList.add(eric);
    pythonStudentList.add(evelien);
    htmlStudentList.add(eric);
    htmlStudentList.add(jantje);
  }
}



