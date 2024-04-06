package nl.emilvdijk;


import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class findingDeleter {

  /**
   * finds target in arraylist of string arrays and  ends its existence also prints succes or
   * failure
   *
   * @param arrayTarget ArrayList<String[]> to search through
   * @param targetName  String what to search for
   * @return ArrayList<String [ ]> return altered list
   */
  ArrayList<String[]> searchAndDestroy(ArrayList<String[]> arrayTarget, String targetName) {
    boolean found = false;
    for (int i = 0; i < arrayTarget.size(); i++) {
      String[] arrayToSearch = arrayTarget.get(i);
      if (Objects.equals(arrayToSearch[0], targetName)) {
        arrayTarget.remove(i);
        found = true;
      }
    }
    if (found) {
      System.out.println("verwijderen gelukt!");
    } else {
      System.out.println("niet gevonden, probeer het nog eens.");
    }
    return arrayTarget;
  }
}

class printing {

  /**
   * takes ArrayList<String[]> in params and prints it out neatly
   *
   * @param arrayListToPrint ArrayList<String[]> to print out
   */
  static void arrayPrinter(ArrayList<String[]> arrayListToPrint) {
    for (int i = 0; i < arrayListToPrint.size(); i++) {
      String[] arrayToPrint = arrayListToPrint.get(i);
      for (int y = 0; y < arrayToPrint.length; y++) {
        System.out.print(arrayToPrint[y]);
        if (y != arrayToPrint.length - 1) {
          System.out.print(", ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }

}

class StudentOld {

  ArrayList<String[]> StudentChoices(ArrayList<String[]> studentArrayList) {
    Scanner myScanner = new Scanner(System.in);
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

          System.out.println("Vul de naam van de nieuwe student in of \"q\" om te annuleren: \n");
          String studentName = myScanner.nextLine();
          if (Objects.equals(studentName, "q")) {
            break;
          }

          System.out.println("Vul de leeftijd van de nieuwe student in: \n");

          while (!myScanner.hasNextInt()) {
            System.out.println("vul een cijfer in voor leeftijd!");
            myScanner.next();
          }
          String studentAge = String.valueOf(myScanner.nextInt());
          myScanner.skip("\n");
          System.out.println("Vul het telefoonnummer van de nieuwe student in: \n");

          while (!myScanner.hasNextInt()) {
            System.out.println("vul een geldig telefoonnummer in!");
            myScanner.next();
          }
          String studentPhone = String.valueOf(myScanner.nextInt());
          myScanner.skip("\n");

          System.out.println("Vul het e-mail adress in van de nieuwe student: \n");
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
          String studentNumber = String.valueOf(myScanner.nextInt());
          myScanner.skip("\n");

          String[] newStudent = {studentName, studentAge, studentPhone, studentEmail, studentAdress,
              studentPlace, studentNumber};
          studentArrayList.add(newStudent);
          break;

        case "2":
          System.out.println(
              "Vul de naam van de te vervijderen student in of q om te annuleren: \n");
          String studentDelete = myScanner.nextLine();
          if (Objects.equals(studentDelete, "q")) {
            break;
          }
          new findingDeleter().searchAndDestroy(studentArrayList, studentDelete);
          break;
        case "3":
          System.out.println(
              "naam, leeftijd, telefoonnummer, e-mail, adress, plaats, studentnummer");
          new printing().arrayPrinter(studentArrayList);
          break;

      }

    } while (!ch.equals("q"));
    System.out.println();
    return studentArrayList;
  }
}

class Mentor {

  Mentor(ArrayList<String[]> mentorArrayList) {
    Scanner myScanner = new Scanner(System.in);
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
        case "1":

          System.out.println("Vul de naam van de nieuwe mentor in of \"q\" om te annuleren: \n");
          String mentorName = myScanner.nextLine();
          if (Objects.equals(mentorName, "q")) {
            break;
          }

          System.out.println("Vul de leeftijd van de mentor student in: \n");

          while (!myScanner.hasNextInt()) {
            System.out.println("vul een cijfer in voor leeftijd!");
            myScanner.next();
          }
          String mentorAge = String.valueOf(myScanner.nextInt());
          myScanner.skip("\n");
          System.out.println("Vul het telefoonnummer van de nieuwe mentor in: \n");

          while (!myScanner.hasNextInt()) {
            System.out.println("vul een geldig telefoonnummer in!");
            myScanner.next();
          }
          String mentorPhone = String.valueOf(myScanner.nextInt());
          myScanner.skip("\n");

          System.out.println("Vul het e-mail adress van de nieuwe mentor in: \n");
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
          String mentorNumber = String.valueOf(myScanner.nextInt());
          myScanner.skip("\n");

          String[] newMentor = {mentorName, mentorAge, mentorPhone, mentorEmail, mentorAdress,
              mentorPlace, mentorNumber};
          mentorArrayList.add(newMentor);
          break;

        case "2":
          System.out.println(
              "Vul de naam van de te vervijderen mentor in of q om te annuleren: \n");
          String mentorDelete = myScanner.nextLine();
          if (Objects.equals(mentorDelete, "q")) {
            break;
          }
          new findingDeleter().searchAndDestroy(mentorArrayList, mentorDelete);
          break;
        case "3":
          System.out.println(
              "naam, leeftijd, telefoonnummer, e-mail, adress, plaats, werknemernummer");
          new printing().arrayPrinter(mentorArrayList);
          break;

      }

    } while (!ch.equals("q"));
  }
}

class Klas {

  Klas(ArrayList<String[]> classesArrayList) {
    System.out.println("klas");
    Scanner myScanner = new Scanner(System.in);
    String ch;
    do {
      do {
        System.out.println("""
            Opties voor klassen:
            1 om een klas toe te voegen.
            2 om een klas te verwijderen.
            3 om alle klassen te tonen.
            q om terug te gaan naar het menu.""");
        ch = myScanner.nextLine();
      } while ((ch == "1") | (ch == "2") | (ch == "3") & (ch != "q"));

      switch (ch) {
        case "1":

          break;

        case "2":

          break;

        case "3":
          System.out.println(
              "vaknaam, mentor, leerlingen");
          new printing().arrayPrinter(classesArrayList);
          break;
      }
    } while (!ch.equals("q"));
  }
}

class examples {
  /**
   * takes ArrayList<String[]> and fills it with example students
   *
   * @return ArrayList<String [ ]> new list with examples old contents will be gone
   */
  static ArrayList<String[]> addSampleStudents() {
    System.out.println("Er zijn voorbeeld studenten toegevoegd.");
    ArrayList<String[]> studentsArray = new ArrayList<>();
    String[] eric = {"Eric", "12", "346575764", "nice@nice.com", "Nicestraat", "Nicestad", "34"};
    String[] jantje = {"Jantje", "5", "23452345", "nice3@nice3.com", "Nicewijk", "Niceplek", "36"};
    String[] evelien = {"Evelien", "34", "23452345", "nice2@nice2.com", "Niceweg", "Nicedorp",
        "35"};
    studentsArray.add(eric);
    studentsArray.add(evelien);
    studentsArray.add(jantje);
    return studentsArray;
  }

  /**
   * takes ArrayList<String[]> and fills it with example mentors
   *
   * @return ArrayList<String [ ]> new list with examples old contents will be gone
   */
  static ArrayList<String[]> addSampleMentors() {
    System.out.println("Er zijn voorbeeld mentoren toegevoegd.");
    ArrayList<String[]> studentsArray = new ArrayList<>();
    String[] daan = {"Daan", "55", "2345234532", "nice@school.com", "Schoolstraat", "Schoolstad",
        "55"};
    String[] david = {"David", "57", "56785867", "nice2@school2.com", "Schoolweg", "Schooldorp",
        "56"};
    String[] simone = {"Simone", "99", "96964623", "nice3@school3.com", "Schoolwijk", "Schoolplek",
        "57"};
    Student ewoud = new Student("Ewoud",23,"533533234","nice@nice.nl","straatofzo 3","plaatsofzo", 6534);
    studentsArray.add(daan);
    studentsArray.add(david);
    studentsArray.add(simone);
    return studentsArray;
  }

  /**
   * takes ArrayList<String[]> and fills it with 3 example classes
   *
   * @return ArrayList<String [ ]> new list with examples old contents will be gone
   */
  static ArrayList<String[]> addSampleClasses() {
    System.out.println("Er zijn voorbeeld klassen toegevoegd.");
    ArrayList<String[]> classesArray = new ArrayList<>();
    String[] class1 = {"Java", "Daan", "Eric", "Evelien"};
    String[] class2 = {"Python", "David", "Evelien", "Jantje"};
    String[] class3 = {"HTML", "Simone", "Eric", "Jantje"};
    classesArray.add(class1);
    classesArray.add(class2);
    classesArray.add(class3);
    return classesArray;
  }


}

class students2 {


  public static void main(String[] args) {
    String ch;
    Scanner myScanner = new Scanner(System.in);
    Student eric = new Student("Naampje", 13, "434536345344","nice@nice.nl", "straatnaam 2", "Dingetje stad", 234523);
    System.out.printf("naam: %-14s  leeftijd: %-7s  telefoonnr: %-15s e-mail: %-16s adres: %-16s woonplaats: %-16s studentnummer: %-16s ", eric.Name, eric.age, eric.telephoneNumber,eric.email, eric.adress, eric.place, eric.StudentNumber);
    System.out.println();
    ArrayList<String[]> studentsArray;
    studentsArray = examples.addSampleStudents();
//    students2.arrayPrinter(studentsArray);

    ArrayList<String[]> mentorsArray;
    mentorsArray = examples.addSampleMentors();
//    students2.arrayPrinter(mentorsArray);

    ArrayList<String[]> classesArray;
    classesArray = examples.addSampleClasses();
//    students2.arrayPrinter(classesArray);

//    System.out.println(Arrays.toString(studentsArray.get(0)));
//    String[] x = studentsArray.get(0);
//    System.out.println(Arrays.toString(x));
//    System.out.println(studentsArray.size());
//    System.out.println(studentsArray.get(0).length);

    System.out.println();
    do {
      do {
        System.out.println("""
            Welkom in het studentendatabasesysteem v2.
            1 voor studenten.
            2 voor mentoren.
            3 voor klassen.
            q om het programma af te sluiten.""");
        ch = myScanner.nextLine();
      } while ((ch == "1") | (ch == "2") | (ch == "3") & (ch != "q"));

      switch (ch) {
        case "1":
          new StudentOld().StudentChoices(studentsArray);

          break;

        case "2":
          new Mentor(mentorsArray);
          break;

        case "3":
          new Klas(classesArray);
          break;
      }
    } while (!ch.equals("q"));
  }
}