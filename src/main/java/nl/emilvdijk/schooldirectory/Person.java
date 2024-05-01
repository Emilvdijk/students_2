package nl.emilvdijk.schooldirectory;

public class Person {

  private String name;
  private int age;
  private String telephoneNumber;
  private String email;
  private String address;
  private String place;

  /**
   * constructor for person objects
   *
   * @param name name of person
   * @param age age of person
   * @param telephoneNumber telephone number of person
   * @param email email of person
   * @param address address of person
   * @param place place of residence of person
   */
  public Person(String name, int age, String telephoneNumber, String email, String address,
      String place) {
    this.name=name;
    this.age=age;
    this.telephoneNumber=telephoneNumber;
    this.email=email;
    this.address =address;
    this.place=place;
  }

  /**
   * returns name
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * returns age
   * @return age
   */
  public int getAge() {
    return age;
  }

  /**
   * returns telephone number
   * @return telephone number
   */
  public String getTelephoneNumber() {
    return telephoneNumber;
  }

  /**
   * returns email
   * @return email
   */
  public String getEmail() {
    return email;
  }

  /**
   * returns address
   * @return address
   */
  public String getAddress() {
    return address;
  }

  /**
   * returns place
   * @return place
   */
  public String getPlace() {
    return place;
  }
}
