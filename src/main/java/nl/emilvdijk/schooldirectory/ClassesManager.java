package nl.emilvdijk.schooldirectory;

import java.util.ArrayList;
import java.util.Scanner;

class ClassesManager {

  private ClassesManager() {

  }

  static void manageClasses(Scanner myScanner, ArrayList<Classes> classesList,
      ArrayList<Person> mentorsList, ArrayList<Person> studentsList) {
    String ch;
    do {
      ch = showMenuOptions(myScanner);

      switch (ch) {

        // makes new class object
        case "1":
          addNewClass(myScanner, classesList);
          break;

        // ask for input and adds mentor to class
        case "2":
          addMentorToClass(myScanner, classesList, mentorsList);
          break;

        // ask for input and adds student to class
        case "3":
          addStudentToClass(myScanner, classesList, studentsList);
          break;

        // ask for input and removes chosen mentor from class
        case "4":
          removeMentorFromClass(myScanner, classesList);
          break;

        // ask for input and removes chosen student from class
        case "5":
          removeStudentFromClass(myScanner, classesList);
          break;

        //asks for input and removes chosen class
        case "6":
          deleteClass(myScanner, classesList);
          break;

        // prints out all classes and occupants
        case "7":
          printClasses(classesList);
      }
    } while (!ch.equals("q"));
  }


  private static String showMenuOptions(Scanner myScanner) {
    String ch;
    do {
      System.out.println("""
          Opties voor klassen:
          1 om een klas toe te voegen.
          2 om een mentor toe te voegen aan een klas.
          3 om een student toe te voegen aan een klas.
          4 om een mentor te verwijderen uit een klas.
          5 om een student te verwijderen uit een klas.
          6 om een klas te verwijderen.
          7 om alle klassen weer te geven.
          q om terug te gaan naar het menu.""");
      ch = myScanner.nextLine();
    } while ((ch == "1") || (ch == "2") || (ch == "3") || (ch == "4") || (ch == "5") || (ch
        == "6") || (ch == "7") && (ch != "q"));
    return ch;
  }


  private static void addNewClass(Scanner myScanner, ArrayList<Classes> classesList) {
    System.out.println("naam van de klas:");
    String newClassName = myScanner.nextLine();
    ArrayList<Person> newMentorList = new ArrayList<>();
    ArrayList<Person> newStudentList = new ArrayList<>();
    Classes newClass = new Classes(newClassName, newMentorList, newStudentList);
    classesList.add(newClass);
  }


  private static void addMentorToClass(Scanner myScanner, ArrayList<Classes> classesList,
      ArrayList<Person> mentorsList) {
    if (classesList.isEmpty()) {
      System.out.println("de klassenlijst is leeg");
      return;
    }

    System.out.println("aan welke klas wil je een mentor toevoegen:");
    for (int y = 1; y - 1 < classesList.size(); y++) {
      System.out.printf("%s  %s%n", y, classesList.get(y - 1).getClass());
    }
    int chosenClass;
    do {
      chosenClass = myScanner.nextInt();

    } while (!(chosenClass >= 1 && chosenClass <= classesList.size()));
    myScanner.skip("\n");
    System.out.println("welke mentor wil je toevoegen?");

    for (int y = 1; y - 1 < mentorsList.size(); y++) {
      System.out.printf("%s  %s%n", y, mentorsList.get(y - 1).getName());
    }

    int chosenMentor;
    do {
      chosenMentor = myScanner.nextInt();
    } while (!(chosenMentor >= 1 && chosenMentor <= mentorsList.size()));
    myScanner.skip("\n");
    if (classesList.get(chosenClass - 1).getClassMentors().contains(
        mentorsList.get(chosenMentor - 1))) {
      System.out.println("mentor zit al in deze klas");
      return;
    }
    classesList.get(chosenClass - 1).addClassMentor(mentorsList.get(chosenMentor - 1));
  }


  private static void addStudentToClass(Scanner myScanner, ArrayList<Classes> classesList,
      ArrayList<Person> studentsList) {
    if (classesList.isEmpty()) {
      System.out.println("de klassenlijst is leeg");
      return;
    }
    //ask to choose class
    System.out.println("aan welke klas wil je een student toevoegen:");
    for (int y = 0; y <= classesList.size() - 1; y++) {
      System.out.printf("%s  %s%n", y + 1, classesList.get(y).getClassName());
    }

    int chosenClass;
    do {
      chosenClass = myScanner.nextInt();
    } while (!(chosenClass >= 1 && chosenClass <= classesList.size()));
    myScanner.skip("\n");

    //ass to choose student
    System.out.println("welke student wil je toevoegen?");

    for (int y = 1; y - 1 < studentsList.size(); y++) {
      System.out.printf("%s  %s%n", y, studentsList.get(y - 1).getName());
    }
    int chosenStudent;
    do {
      chosenStudent = myScanner.nextInt();
    } while (!(chosenStudent >= 1 && chosenStudent <= studentsList.size()));
    myScanner.skip("\n");
    if (classesList.get(chosenClass - 1).getClassStudents().contains(
        studentsList.get(chosenStudent - 1))) {
      System.out.println("student zit al in deze klas");
      return;
    }
    classesList.get(chosenClass - 1).addClassStudent(studentsList.get(chosenStudent - 1));
  }


  private static void removeMentorFromClass(Scanner myScanner, ArrayList<Classes> classesList) {
    if (classesList.isEmpty()) {
      System.out.println("de klassenlijst is leeg");
      return;
    }

    System.out.println("van welke klas wil je een mentor verwijderen:");
    for (int y = 1; y - 1 < classesList.size(); y++) {
      System.out.printf("%s  %s%n", y, classesList.get(y - 1).getClassName());
    }
    int chosenClass;
    do {
      chosenClass = myScanner.nextInt();
    } while (!(chosenClass >= 1 && chosenClass <= classesList.size()));
    myScanner.skip("\n");
    if (classesList.get(chosenClass - 1).getClassMentors().isEmpty()) {
      System.out.println("in deze klas zitten geen mentoren");
      return;
    }
    System.out.println("welke mentor wil je verwijderen?");

    for (int y = 1; y - 1 < classesList.get(chosenClass - 1).getClassMentors().size(); y++) {
      System.out.printf("%s  %s%n", y,
          classesList.get(chosenClass - 1).getClassMentors().get(y - 1).getName());
    }
    int chosenMentor;
    do {
      chosenMentor = myScanner.nextInt();
    } while (!(chosenMentor >= 1 && chosenMentor <= classesList.get(chosenClass - 1).getClassMentors().size()));
    myScanner.skip("\n");
    classesList.get(chosenClass - 1).removeClassMentor(classesList.get(chosenClass - 1).getClassMentors().get(chosenMentor-1));
  }


  private static void removeStudentFromClass(Scanner myScanner, ArrayList<Classes> classesList) {
    if (classesList.isEmpty()) {
      System.out.println("de klassenlijst is leeg");
      return;
    }
    int y = 1;
    System.out.println("van welke klas wil je een student verwijderen:");
    for (; y - 1 < classesList.size(); y++) {
      System.out.printf("%s  %s%n", y, classesList.get(y - 1).getClassName());
    }
    int chosenClass;
    do {
      chosenClass = myScanner.nextInt();
    } while (!(chosenClass >= 1 && chosenClass <= y - 1));
    myScanner.skip("\n");
    if (classesList.get(chosenClass - 1).getClassStudents().isEmpty()) {
      System.out.println("in deze klas zitten geen studenten");
      return;
    }
    System.out.println("welke student wil je verwijderen?");
    y = 1;
    for (; y - 1 < classesList.get(chosenClass - 1).getClassStudents().size(); y++) {
      System.out.printf("%s  %s%n", y,
          classesList.get(chosenClass - 1).getClassStudents().get(y - 1).getName());
    }
    int chosenStudent;
    do {
      chosenStudent = myScanner.nextInt();
    } while (!(chosenStudent >= 1 && chosenStudent <= y - 1));
    myScanner.skip("\n");
    classesList.get(chosenClass - 1)
        .removeClassStudent(classesList.get(chosenClass - 1).getClassStudents().get(chosenStudent - 1));
  }


  private static void deleteClass(Scanner myScanner, ArrayList<Classes> classesList) {
    if (classesList.isEmpty()) {
      System.out.println("de klassenlijst is leeg");
      return;
    }
    System.out.println("welke klas wil je verwijderen?");
    int y = 1;
    for (; y - 1 < classesList.size(); y++) {
      System.out.printf("%s  %s%n", y, classesList.get(y - 1).getClassName());
    }
    int choice;
    do {
      choice = myScanner.nextInt();
    } while (!(choice >= 1 && choice <= y - 1));
    myScanner.skip("\n");
    classesList.remove(choice - 1);
  }


  private static void printClasses(ArrayList<Classes> classesList) {
    if (classesList.isEmpty()) {
      System.out.println("de klassenlijst is leeg");
      return;
    }
    for (Classes classes : classesList) {
      classes.classesPrinter();
    }
  }
}
