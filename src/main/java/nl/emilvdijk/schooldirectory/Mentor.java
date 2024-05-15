package nl.emilvdijk.schooldirectory;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

class Mentor extends Teacher {

  /**
   * constructor for mentor class
   *
   * @param name            name of mentor
   * @param age             age of mentor
   * @param telephoneNumber telephone number of mentor
   * @param email           email of mentor
   * @param adress          adress of mentor
   * @param place           place of recidence of mentor
   * @param employeeNumber  employee number of mentor
   */
  public Mentor(String name, int age, String telephoneNumber, String email, String adress,
      String place, int employeeNumber) {
    super(name, age, telephoneNumber, email, adress, place, employeeNumber);
  }

  /**
   * JsonCreator constructor for loading Mentor objects from JSON file
   *
   * @param name
   * @param age
   * @param telephoneNumber
   * @param email
   * @param address
   * @param place
   * @param employeeNumber
   * @param hoursDeclared
   */
  @JsonCreator
  public Mentor(
      @JsonProperty("name") String name,
      @JsonProperty("age") int age,
      @JsonProperty("telephoneNumber") String telephoneNumber,
      @JsonProperty("email") String email,
      @JsonProperty("address") String address,
      @JsonProperty("place") String place,
      @JsonProperty("employeeNumber") int employeeNumber,
      @JsonProperty("hoursDeclared") Map hoursDeclared) {
    super(
        name,
        age,
        telephoneNumber,
        email,
        address,
        place,
        employeeNumber,
        hoursDeclared);
  }


  /**
   * returns formated string of mentor details
   *
   * @return formated string of mentor details
   */
  @Override
  public String toString() {
    return "naam: %-14s  leeftijd: %-5s  telefoonnr: %-18s e-mail: %-26s adres: %-22s woonplaats: %-18s werknemernummer: %-8s %n".formatted(
        this.getName(),
        this.getAge(),
        this.getTelephoneNumber(),
        this.getEmail(),
        this.getAddress(),
        this.getPlace(),
        this.getEmployeeNumber());
  }


}

