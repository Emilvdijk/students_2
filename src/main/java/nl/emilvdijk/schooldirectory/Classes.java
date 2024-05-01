package nl.emilvdijk.schooldirectory;

import java.util.ArrayList;

class Classes {

  private String className;
  private ArrayList<Person> classMentors;
  private ArrayList<Person> classStudents;

  /**
   * constructor for classes
   *
   * @param className     name of the class
   * @param classMentors  arraylist<Mentor>  list of mentor class objects
   * @param classStudents arraylist<Student> list of student class objects
   */
  Classes(String className, ArrayList<Person> classMentors,
      ArrayList<Person> classStudents) {
    this.className = className;
    this.classMentors = classMentors;
    this.classStudents = classStudents;
  }

  public String getClassName() {
    return className;
  }

  public ArrayList<Person> getClassMentors() {
    return classMentors;
  }

  public ArrayList<Person> getClassStudents() {
    return classStudents;
  }

  /**
   * used to add mentor to mentorlist
   *
   * @param classMentor Mentor class object to add
   */
  void addClassMentor(Person classMentor) {
    this.classMentors.add(classMentor);
  }

  /**
   * used to add student to student list
   *
   * @param classStudent student class object to add
   */
  void addClassStudent(Person classStudent) {
    this.classStudents.add(classStudent);
  }

  /**
   * used to remove mentor from mentor list
   *
   * @param classMentor mentor class object to remove from list
   */
  void removeClassMentor(Person classMentor) {
    this.classMentors.remove(classMentor);
  }

  /**
   * used to remove students from studentlist
   *
   * @param classStudent student class object to remove from list
   */
  void removeClassStudent(Person classStudent) {
    this.classStudents.remove(classStudent);
  }

  /**
   * used to print out class details
   */
  void classesPrinter() {
    System.out.printf("klasnaam: %-10s Mentoren: ", className);

    for (Person classMentor : classMentors) {
      System.out.printf("%-14s", classMentor.getName());
    }
    System.out.println();
    System.out.print("studenten: ");
    for (Person classStudent : classStudents) {
      System.out.printf("  " + classStudent.getName());
    }
    System.out.println("\n");
  }
}
