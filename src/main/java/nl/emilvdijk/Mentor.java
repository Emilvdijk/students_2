package nl.emilvdijk;


class Mentor {

  String Name;
  int age;
  long telephoneNumber;
  String email;
  String adress;
  String place;
  int employeeNumber;


  /**
   * constructor for mentor class
   *
   * @param nam name of mentor
   * @param ag  age of mentor
   * @param t   telephone number of mentor
   * @param ema email of mentor
   * @param adr adress of mentor
   * @param pla place of recidence of mentor
   * @param enr employee number of mentor
   */
  public Mentor(String nam, int ag, long t, String ema, String adr, String pla,
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
  void MentorPrinter() {
    System.out.printf(
        "naam: %-14s  leeftijd: %-5s  telefoonnummer: %-18s e-mail: %-23s adres: %-16s woonplaats: %-16s werknemernummer: %-8s %n",
        Name, age, telephoneNumber, email, adress, place, employeeNumber);
  }

}

