package nl.emilvdijk.schooldirectory;


class Mentor {

  String name;
  int age;
  private String telephoneNumber;
  String email;
  String adress;
  String place;
  int employeeNumber;


  /**
   * constructor for mentor class
   *
   * @param name name of mentor
   * @param age  age of mentor
   * @param telephoneNumber   telephone number of mentor
   * @param email email of mentor
   * @param adress adress of mentor
   * @param place place of recidence of mentor
   * @param employeeNumber employee number of mentor
   */
  Mentor(String name, int age, String telephoneNumber, String email, String adress, String place,
      int employeeNumber) {
    this.name = name;
    this.age = age;
    this.telephoneNumber = telephoneNumber;
    this.email = email;
    this.adress = adress;
    this.place = place;
    this.employeeNumber = employeeNumber;
  }



  /**
   * used to print out mentor details
   */
  void mentorPrinter() {
    System.out.printf(
        "naam: %-14s  leeftijd: %-5s  telefoonnummer: %-18s e-mail: %-23s adres: %-16s woonplaats: %-16s werknemernummer: %-8s %n",
        name, age, telephoneNumber, email, adress, place, employeeNumber);
  }

}

