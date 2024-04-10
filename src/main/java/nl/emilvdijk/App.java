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

    ArrayList<Student> javaStudentList = new ArrayList<>();
    ArrayList<Student> htmlStudentList = new ArrayList<>();
    ArrayList<Student> pythonStudentList = new ArrayList<>();
    ArrayList<Student> studentsList = new ArrayList();
    createStudents(studentsList, javaStudentList, pythonStudentList, htmlStudentList);

    ArrayList<Mentor> pythonMentorList = new ArrayList<>();
    ArrayList<Mentor> javaMentorList = new ArrayList<>();
    ArrayList<Mentor> htmlMentorList = new ArrayList<>();
    ArrayList<Mentor> mentorsList = new ArrayList();
    createMentors(mentorsList, javaMentorList, htmlMentorList, pythonMentorList);

    ArrayList<Classes> classesList = new ArrayList();
    createClasses(javaMentorList, javaStudentList, pythonMentorList, pythonStudentList, htmlMentorList,
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
      } while ((ch == "1") | (ch == "2") | (ch == "3") & (ch != "quit"));

      // choices for adding removing or showing of students
      switch (ch) {
        case "1":
          ch = manageStudents(myScanner, emailPattern, studentsList);
          break;

        // choices for adding, removing or showing of mentors
        case "2":
          ch = manageMentors(myScanner, emailPattern, mentorsList);
          break;

        // choices for classes like adding a class or changing its occupants
        case "3":
          ch = ClassManager.manageClasses(myScanner, classesList, mentorsList, studentsList);
          break;
      }
    } while (!ch.equals("quit"));
  }

  private static String manageMentors(Scanner myScanner, Pattern emailPattern,
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
      } while ((ch == "1") | (ch == "2") | (ch == "3") & (ch != "q"));

      switch (ch) {

        // ask for input and makes mentor object and adds it to list
        case "1":
          System.out.println(
              "Vul de naam van de nieuwe mentor in of \"q\" om te annuleren: \n");
          String mentorName = myScanner.nextLine();
          if (Objects.equals(mentorName, "q")) {
            break;
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
          break;

        // ask for input and removes mentor object
        case "2":
          if (mentorsList.isEmpty()){
            System.out.println("de mentorenlijst is leeg");
            break;
          }
          int y = 1;
          System.out.println("welke mentor wil je verwijderen:");
          for (; y - 1 < mentorsList.size(); y++) {
            System.out.printf("%s  %s%n", y, mentorsList.get(y - 1).Name);
          }
          int choice;
          do {
            choice = myScanner.nextInt();
          } while (!(choice >= 1 && choice <= y - 1));
          myScanner.skip("\n");
          mentorsList.remove(choice - 1);
          break;

        // prints out all mentors and details
        case "3":
          if (mentorsList.isEmpty()){
            System.out.println("de mentorenlijst is leeg");
            break;
          }
          for (int i = 0; i < mentorsList.size(); i++) {
            mentorsList.get(i).MentorPrinter();
          }
          System.out.println();
          break;
      }
    } while (!ch.equals("q"));
    return ch;
  }

  private static String manageStudents(Scanner myScanner, Pattern emailPattern,
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
      } while ((ch == "1") | (ch == "2") | (ch == "3") & (ch != "q"));

      switch (ch) {
        case "1":
          // ask input and makes student object and adds student to list

          System.out.println(
              "Vul de naam van de nieuwe student in of \"q\" om te annuleren: \n");
          String studentName = myScanner.nextLine();
          if (Objects.equals(studentName, "q")) {
            break;
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
          break;

        // ask for input and removes student
        case "2":
          if (studentsList.isEmpty()){
            System.out.println("de studentenlijst is leeg");
            break;
          }
          int y = 1;
          System.out.println("welke student wil je verwijderen:");
          for (; y - 1 < studentsList.size(); y++) {
            System.out.printf("%s  %s%n", y, studentsList.get(y - 1).Name);
          }
          int choice;
          do {
            choice = myScanner.nextInt();
          } while (!(choice >= 1 && choice <= y - 1));
          myScanner.skip("\n");
          studentsList.remove(choice - 1);
          break;

        // prints out all students
        case "3":
          if (studentsList.isEmpty()){
            System.out.println("de studentenlijst is leeg");
            break;
          }
          for (int i = 0; i < studentsList.size(); i++) {
            studentsList.get(i).StudentPrinter();
          }
          System.out.println();
          break;
      }

    } while (!ch.equals("q"));
    return ch;
  }

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

  private static void createStudents(ArrayList<Student> studentsList, ArrayList<Student> javaStudentList,
      ArrayList<Student> pythonStudentList, ArrayList<Student> htmlStudentList) {
    // 3 examples added for students mentors and classes and notify they have been added
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