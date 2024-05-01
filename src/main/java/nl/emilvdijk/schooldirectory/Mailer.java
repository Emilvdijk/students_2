package nl.emilvdijk.schooldirectory;

public class Mailer {

  /**
   * private constructor to prevent instantiation
   */
  private Mailer() {
  }

  /**
   * sends a mail to a person
   * @param person          person to send mail to
   * @param emailContents   content of the mail to be sent
   */
  public static void sendMail(Person person, String emailContents){
    System.out.printf("Greetings, %s%n%n%s%n%nwith kind regards",person.getName(),emailContents);
  }

}
