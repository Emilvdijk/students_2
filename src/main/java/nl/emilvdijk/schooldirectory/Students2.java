package nl.emilvdijk.schooldirectory;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import net.datafaker.Faker;


class Students2 {


  /**
   * school database system where mentors, students and classes can be added and removed and mentors
   * and students can be added and removed from classes
   *
   */
  public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);
    Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    Faker faker = new Faker();

    // 3 examples added for students mentors and classes and notify they have been added
    ArrayList<Person> javaStudentList = new ArrayList<>();
    ArrayList<Person> htmlStudentList = new ArrayList<>();
    ArrayList<Person> pythonStudentList = new ArrayList<>();
    ArrayList<Student> studentsList = new ArrayList<>();
    createStudents(studentsList, javaStudentList, pythonStudentList, htmlStudentList,5,faker);

    ArrayList<Person> pythonMentorList = new ArrayList<>();
    ArrayList<Person> javaMentorList = new ArrayList<>();
    ArrayList<Person> htmlMentorList = new ArrayList<>();
//    ArrayList<Person> mentorsList = new ArrayList<>();
    //FIXME @JsonProperty constructor toevoegen?
    List<Mentor> mentorsList = JsonManager.LoadFiles("mentorsList",Mentor.class);
//    createMentors(mentorsList, javaMentorList, htmlMentorList, pythonMentorList,5,faker);

    ArrayList<Classes> classesList = new ArrayList<>();
    createClasses(javaMentorList, javaStudentList, pythonMentorList, pythonStudentList,
        htmlMentorList,
        htmlStudentList, classesList);
    System.out.println("er zijn voorbeelden toevevoegd.");
    // end of example adding code

    // main menu of the system where inputs are asked
    mainMenu(myScanner, emailPattern, studentsList, mentorsList, classesList);

    // save mentorlist to JSON
    JsonManager.SaveFiles("mentorsList",mentorsList);
  }

  private static void mainMenu(Scanner myScanner, Pattern emailPattern,
      List<Student> studentsList, List<Mentor> mentorsList,
      ArrayList<Classes> classesList) {
    String ch;
    do {
      ch = showMainMenuOptions(myScanner);

      // choices for adding removing or showing of students
      switch (ch) {
        case "1":
          StudentManager.manageStudents(myScanner, emailPattern, studentsList);
          break;

        // choices for adding, removing or showing of mentors
        case "2":
          MentorManager.manageMentors(myScanner, emailPattern, mentorsList);
          break;

        // choices for classes like adding a class or changing its occupants
        case "3":
          ClassesManager.manageClasses(myScanner, classesList, mentorsList, studentsList);
          break;
      }
    } while (!ch.equals("quit"));
  }

  private static String showMainMenuOptions(Scanner myScanner) {
    String ch;
    do {
      System.out.println("""
          Welkom in het studentendatabasesysteem v2.
          1 voor studenten.
          2 voor mentoren.
          3 voor klassen.
          'quit' om het programma af te sluiten.""");
      ch = myScanner.nextLine();
    } while ((ch == "1") || (ch == "2") || (ch == "3") && (ch != "quit"));
    return ch;
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
  private static void createClasses(ArrayList<Person> javaMentorList,
      ArrayList<Person> javaStudentList, ArrayList<Person> pythonMentorList,
      ArrayList<Person> pythonStudentList, ArrayList<Person> htmlMentorList,
      ArrayList<Person> htmlStudentList, ArrayList<Classes> classesList) {
    Classes java = new Classes("Java", javaMentorList, javaStudentList);
    Classes python = new Classes("Python", pythonMentorList, pythonStudentList);
    Classes html = new Classes("HTML", htmlMentorList, htmlStudentList);
    classesList.add(java);
    classesList.add(python);
    classesList.add(html);
  }


  /**
   * adds example mentors and adds some to example classes
   *
   * @param mentorsList      list of mentors for examples to be added to
   * @param javaMentorList   java example class list to add to
   * @param htmlMentorList   html example class list to add to
   * @param pythonMentorList python example class list to add to
   * @param numberOfMentors  number of example mentor to add on top of 3 base ones
   * @param faker            reuse faker
   */
  private static void createMentors(ArrayList<Person> mentorsList, ArrayList<Person> javaMentorList,
      ArrayList<Person> htmlMentorList, ArrayList<Person> pythonMentorList, int numberOfMentors,Faker faker) {
    Mentor daan = new Mentor("Daan", 55, "2345234532", "nice@school.com", "Schoolstraat",
        "Schoolstad", 55);
    Mentor david = new Mentor("David", 57, "56785867", "nice2@school2.com", "Schoolweg",
        "Schooldorp", 56);
    Mentor simone = new Mentor("Simone", 99, "96964623", "nice3@school3.com", "Schoolwijk",
        "Schoolplek", 57);
    mentorsList.add(daan);
    mentorsList.add(david);
    mentorsList.add(simone);
    for (int i = 0; i < numberOfMentors; i++) {
      Mentor exampleTeacher = new Mentor(
          faker.animal().name(),
          faker.number().numberBetween(0, 69),
          faker.phoneNumber().cellPhone(),
          faker.internet().emailAddress(),
          faker.address().streetAddress(),
          faker.address().city(),
          faker.number().numberBetween(0, 9999));
      mentorsList.add(exampleTeacher);
    }

    javaMentorList.add(daan);
    htmlMentorList.add(simone);
    pythonMentorList.add(david);
  }

  /**
   * adds example students and adds some to example classes
   * @param studentsList      list of students for examples to be added to
   * @param javaStudentList   java example class list to add to
   * @param pythonStudentList html example class list to add to
   * @param htmlStudentList   python example class list to add to
   * @param numberOfStudents  number of example students to add on top of 3 base ones
   * @param faker             reuse faker
   */
  private static void createStudents(ArrayList<Student> studentsList,
      ArrayList<Person> javaStudentList,
      ArrayList<Person> pythonStudentList, ArrayList<Person> htmlStudentList, int numberOfStudents, Faker faker) {
    Student eric = new Student("Eric", 12, "346575764", "nice@nice.com", "Nicestraat 1", "Nicestad",
        34);
    Student jantje = new Student("Jantje", 5, "23452345", "nice3@nice3.com", "Nicewijk 2",
        "Niceplek", 36);
    Student evelien = new Student("Evelien", 34, "23452345", "nice2@nice2.com", "Niceweg 3",
        "Nicedorp", 35);
    studentsList.add(eric);
    studentsList.add(jantje);
    studentsList.add(evelien);
    for (int i = 0; i < numberOfStudents; i++) {
      Student exampleStudent = new Student(
          faker.pokemon().name(),
          faker.number().numberBetween(0,69),
          faker.phoneNumber().cellPhone(),
          faker.internet().emailAddress(),
          faker.address().streetAddress(false),
          faker.address().city(),
          faker.number().numberBetween(0,9999));
      studentsList.add(exampleStudent);
    }
    javaStudentList.add(jantje);
    javaStudentList.add(evelien);
    pythonStudentList.add(eric);
    pythonStudentList.add(evelien);
    htmlStudentList.add(eric);
    htmlStudentList.add(jantje);
  }
}