package nl.emilvdijk.schooldirectory;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MentorManager {

  private MentorManager(){

  }


  /**
   * manage mentorlist switchcase
   *
   * @param myScanner reuse scanner from main
   * @param emailPattern pattern to check email validity
   * @param mentorsList list to manage
   */
  static void manageMentors(Scanner myScanner, Pattern emailPattern,
      List<Mentor> mentorsList) {
    String ch;
    do {
      ch = manageMentorMenu(myScanner);

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

  private static String manageMentorMenu(Scanner myScanner) {
    String ch;
    do {
      System.out.println("""
          Opties voor mentoren:
          1 om een mentor toe te voegen.
          2 om een mentor te verwijderen.
          3 om alle mentoren te tonen.
          q om terug te gaan naar het menu.""");
      ch = myScanner.nextLine();
    } while (ch.equals("1\n") || ch.equals("2\n") || ch.equals("3\n") && !(ch.equals("q\n")));
    return ch;
  }

  /**
   * asks input and adds new mentor to mentorlist with input
   *
   * @param myScanner reuse scanner from main
   * @param emailPattern pattern to check email validity
   * @param mentorsList list to add mentor to
   */
  private static void addNewMentor(Scanner myScanner, Pattern emailPattern,
      List<Mentor> mentorsList) {
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
  private static void deleteMentor(Scanner myScanner, List<Mentor> mentorsList) {
    if (mentorsList.isEmpty()) {
      System.out.println("de mentorenlijst is leeg");
      return;
    }
    int y = 1;
    System.out.println("welke mentor wil je verwijderen:");
    for (; y - 1 < mentorsList.size(); y++) {
      System.out.printf("%s  %s%n", y, mentorsList.get(y - 1).getName());
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
  private static void printMentors(List<Mentor> mentorsList) {
    if (mentorsList.isEmpty()) {
      System.out.println("de mentorenlijst is leeg");
      return;
    }
    for (Person mentor : mentorsList) {
      System.out.print(mentor.toString());
    }
    System.out.println();
  }
}
