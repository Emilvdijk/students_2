package nl.emilvdijk.schooldirectory;

import java.util.HashMap;
import java.util.Map;

class Student extends Person {

  private int studentNumber;
  private HashMap<Subject, Integer> subjects;

  /**
   * constructor for students class
   *
   * @param name            name of student
   * @param age             age of student
   * @param telephoneNumber telephone number  of student
   * @param email           email of student
   * @param address          address of student
   * @param place           place of residence of student
   * @param studentNumber   student number of student
   */
  Student(String name, int age, String telephoneNumber, String email, String address, String place,
      int studentNumber) {
    super(name, age, telephoneNumber, email, address, place);
    this.studentNumber = studentNumber;
    this.subjects = new HashMap<>();
  }

  /**
   * return formated string of student details
   * @return formated string of student details
   */
  @Override
  public String toString() {
    return "naam: %-14s  leeftijd: %-5s  telefoonnr: %-18s e-mail: %-26s adres: %-22s woonplaats: %-18s studentnummer: %-8s %n".formatted(
        this.getName(),
        this.getAge(),
        this.getTelephoneNumber(),
        this.getEmail(),
        this.getAddress(),
        this.getPlace(),
        this.studentNumber);
  }

  public int getStudentNumber() {
    return studentNumber;
  }

  /**
   * adds subject to subjects map
   * @param subject subject to add
   * @param grade current grade of student
   */
  public void addSubject(Subject subject,int grade){
    this.subjects.put(subject,grade);
  }

  /**
   * removes subject form subjects map
   * @param subject subject to remove
   */
  public void removeSubject(Subject subject){
    this.subjects.remove(subject);
  }

  /**
   * returns map of subjects
   * @return map of subjects
   */
  public HashMap<Subject, Integer> getSubjects() {
    return subjects;
  }

  /**
   * changes current grade of subject of student
   * @param subject subject to change grade of
   * @param grade new grade
   */
  public void setSubjectGrade(Subject subject, int grade) {
    this.subjects.remove(subject);
    this.subjects.put(subject,grade);
  }
}
