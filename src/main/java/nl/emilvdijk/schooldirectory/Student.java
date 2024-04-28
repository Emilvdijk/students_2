package nl.emilvdijk.schooldirectory;

class Student extends Person {

  private int studentNumber;

  /**
   * constructor for students class
   *
   * @param name            name of student
   * @param age             age of student
   * @param telephoneNumber telephone number  of student
   * @param email           email of student
   * @param adress          adress of student
   * @param place           place of recidence of student
   * @param studentNumber   student number of student
   */
  Student(String name, int age, String telephoneNumber, String email, String adress, String place,
      int studentNumber) {
    super(name, age, telephoneNumber, email, adress, place);
    this.studentNumber = studentNumber;
  }

  /**
   * returns student details
   *
   * @return student details
   */
  String getStudentDetails() {
    return "naam: %-14s  leeftijd: %-5s  telefoonnr: %-18s e-mail: %-23s adres: %-16s woonplaats: %-16s studentnummer: %-8s %n".formatted(
        this.getName(), this.getAge(), this.getTelephoneNumber(), this.getEmail(), this.getAdress(),
        this.getPlace(), this.studentNumber);
  }

}
