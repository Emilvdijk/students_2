package nl.emilvdijk.schooldirectory;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
public class Teacher extends Person{

  private int employeeNumber;
  private HashMap<Month, Boolean> hoursDeclared;

  /**
   * constructor for teacher objects
   *
   * @param name name of teacher
   * @param age age of teacher
   * @param telephoneNumber telephone number of teacher
   * @param email email of teacher
   * @param address address of teacher
   * @param place place of residence of teacher
   * @param employeeNumber employee number of teacher
   */
  public Teacher(String name, int age, String telephoneNumber, String email, String address,
      String place,int employeeNumber) {
    super(name, age, telephoneNumber, email, address, place);
    this.employeeNumber=employeeNumber;
    this.hoursDeclared= new HashMap<>();
  }

  /**
   *  returns employee number
   * @return employee number
   */
  public int getEmployeeNumber() {
    return employeeNumber;
  }

  /**
   * returns hasmhap of declared hours
   * @return hasmhap of declared hours
   */
  public HashMap<Month, Boolean> getHoursDeclared(){
    return hoursDeclared;
  }

  /**
   * returns boolean of whether this month's hours are declared
   * @return boolean of whether this month's hours are declared
   */
  public boolean getCurrentMonthDeclaration(){
    return hoursDeclared.get(LocalDate.now().getMonth());
  }

  /**
   * sets boolean of month declared to given data
   * @param month month to set
   * @param isDeclared boolean to set to
   */
  public void setHoursDeclared(Month month,boolean isDeclared){
    this.hoursDeclared.put(month,isDeclared);
  }
}