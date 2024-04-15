package nl.emilvdijk.schooldirectory;

class Student {

  String name;
  int age;
  String telephoneNumber;
  String email;
  String adress;
  String place;
  int studentNumber;


  /**
   * constructor for students class
   *
   * @param name name of student
   * @param age  age of student
   * @param telephoneNumber   telephone number  of student
   * @param email email of student
   * @param adress adress of student
   * @param place place of recidence of student
   * @param studentNumber student number of student
   */
  Student(String name, int age, String telephoneNumber, String email, String adress, String place,
      int studentNumber) {
    this.name = name;
    this.age = age;
    this.telephoneNumber = telephoneNumber;
    this.email = email;
    this.adress = adress;
    this.place = place;
    this.studentNumber = studentNumber;
  }

  /**
   * used for printing out student details
   */
  void studentPrinter() {
    System.out.printf(
        "naam: %-14s  leeftijd: %-5s  telefoonnr: %-18s e-mail: %-23s adres: %-16s woonplaats: %-16s studentnummer: %-8s %n",
        name, age, telephoneNumber, email, adress, place, studentNumber);
  }


}
