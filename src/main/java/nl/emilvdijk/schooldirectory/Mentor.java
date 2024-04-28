package nl.emilvdijk.schooldirectory;


class Mentor extends Teacher{

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
  public Mentor(String name, int age, String telephoneNumber, String email, String adress,
      String place, int employeeNumber) {
    super(name, age, telephoneNumber, email, adress, place, employeeNumber);
  }


  /**
   * returns mentor details
   * @return mentor details
   */
  String getMentorDetails(){
    return "naam: %-14s  leeftijd: %-5s  telefoonnummer: %-18s e-mail: %-23s adres: %-16s woonplaats: %-16s werknemernummer: %-8s %n".formatted(this.getName(),this.getAge(),this.getTelephoneNumber(),this.getEmail(),this.getAdress(),this.getPlace(),this.getEmployeeNumber());
  }

}

