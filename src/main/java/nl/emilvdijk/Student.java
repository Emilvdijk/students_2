package nl.emilvdijk;

class Student {
  String Name;
  int age;
  String telephoneNumber;
  String email;
  String adress;
  String place;
  int StudentNumber;


  public Student(String nam, int ag, String t,String ema, String adr, String pla,
      int snr) {
    Name = nam;
    age = ag;
    telephoneNumber = t;
    email = ema;
    adress = adr;
    place = pla;
    StudentNumber = snr;
  }
}
