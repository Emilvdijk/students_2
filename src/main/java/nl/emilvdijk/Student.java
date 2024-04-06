package nl.emilvdijk;

import java.util.ArrayList;
import java.util.Objects;

class Student {
  String Name;
  int age;
  String telephoneNumber;
  String email;
  String adress;
  String place;
  int StudentNumber;


  /**
   * constructor for students class
   * @param nam name of student
   * @param ag age of student
   * @param t telephone number  of student
   * @param ema email of student
   * @param adr adress of student
   * @param pla place of recidence of student
   * @param snr student number of student
   */
  public Student(String nam, int ag, String t,String ema, String adr, String pla,
      int snr) {
    Name = nam;
    age = ag;
    telephoneNumber = t;
    email = ema;
    adress = adr;
    place = pla;
    StudentNumber = snr;
  }

  /**
   * used for printing out student details
   */
  void StudentPrinter(){
    System.out.printf("naam: %-14s  leeftijd: %-5s  telefoonnr: %-14s e-mail: %-23s adres: %-16s woonplaats: %-16s studentnummer: %-8s \n", Name, age, telephoneNumber,email, adress, place, StudentNumber);
  }

  /**
   * finds target in arraylist of student class objects and  ends its existence also prints succes
   * or failure
   *
   * @param arrayTarget ArrayList<Student> to search through
   * @param targetName  String what to search for
   */
  static void SearchAndDestroy(ArrayList<Student> arrayTarget, String targetName) {
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
