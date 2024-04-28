package nl.emilvdijk.schooldirectory;

public class Teacher extends Person{

  private int employeeNumber;

  public Teacher(String name, int age, String telephoneNumber, String email, String adress,
      String place,int employeeNumber) {
    super(name, age, telephoneNumber, email, adress, place);
    this.employeeNumber=employeeNumber;
  }

  public int getEmployeeNumber() {
    return employeeNumber;
  }
}
