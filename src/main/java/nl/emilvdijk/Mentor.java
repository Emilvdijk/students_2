package nl.emilvdijk;

import java.util.ArrayList;
import java.util.Objects;

class Mentor {

  String Name;
  int age;
  String telephoneNumber;
  String email;
  String adress;
  String place;
  int employeeNumber;


  /**
   * constructor for mentor class
   * @param nam name of mentor
   * @param ag age of mentor
   * @param t telephone number of mentor
   * @param ema email of mentor
   * @param adr adress of mentor
   * @param pla place of recidence of mentor
   * @param enr employee number of mentor
   */
  public Mentor(String nam, int ag, String t, String ema, String adr, String pla,
      int enr) {
    Name = nam;
    age = ag;
    telephoneNumber = t;
    email = ema;
    adress = adr;
    place = pla;
    employeeNumber = enr;
  }

  /**
   * used to print out mentor details
   */
  void MentorPrinter(){
    System.out.printf("naam: %-14s  leeftijd: %-5s  telefoonnummer: %-14s e-mail: %-23s adres: %-16s woonplaats: %-16s werknemernummer: %-8s %n", Name, age, telephoneNumber,email, adress, place, employeeNumber);
  }


  /**
   * finds target in arraylist of class mentor objects and  ends its existence also prints succes or
   * failure
   *
   * @param arrayTarget ArrayList<Mentor> to search through
   * @param targetName  String what to search for
   */
  static void SearchAndDestroy(ArrayList<Mentor> arrayTarget, String targetName) {
    boolean found = false;
    for (int i = 0; i < arrayTarget.size(); i++) {
      String objectName = arrayTarget.get(i).Name;
      if (Objects.equals(objectName, targetName)) {
        arrayTarget.remove(i);
        found = true;
      }
    }
    if (found) {
      System.out.println("verwijderen gelukt!");
    } else {
      System.out.println("niet gevonden, probeer het nog eens.");
    }
  }



}

