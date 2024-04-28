package nl.emilvdijk.schooldirectory;

public class Person {

  private String name;
  private int age;
  private String telephoneNumber;
  private String email;
  private String adress;
  private String place;

  public Person(String name, int age, String telephoneNumber, String email, String adress,
      String place) {
    this.name=name;
    this.age=age;
    this.telephoneNumber=telephoneNumber;
    this.email=email;
    this.adress=adress;
    this.place=place;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getTelephoneNumber() {
    return telephoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public String getAdress() {
    return adress;
  }

  public String getPlace() {
    return place;
  }
}
