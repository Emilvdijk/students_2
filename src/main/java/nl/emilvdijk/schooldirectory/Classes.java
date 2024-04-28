package nl.emilvdijk.schooldirectory;

import java.util.ArrayList;

class Classes {

  private String className;
  private ArrayList<Mentor> classMentors;
  private ArrayList<Student> classStudents;

  /**
   * constructor for classes
   *
   * @param className     name of the class
   * @param classMentors  arraylist<Mentor>  list of mentor class objects
   * @param classStudents arraylist<Student> list of student class objects
   */
  Classes(String className, ArrayList<Mentor> classMentors,
      ArrayList<Student> classStudents) {
    this.className = className;
    this.classMentors = classMentors;
    this.classStudents = classStudents;
  }

  public String getClassName() {
    return className;
  }

  public ArrayList<Mentor> getClassMentors() {
    return classMentors;
  }

  public ArrayList<Student> getClassStudents() {
    return classStudents;
  }

  /**
   * used to add mentor to mentorlist
   *
   * @param classMentor Mentor class object to add
   */
  void addClassMentor(Mentor classMentor) {
    this.classMentors.add(classMentor);
  }

  /**
   * used to add student to student list
   *
   * @param classStudent student class object to add
   */
  void addClassStudent(Student classStudent) {
    this.classStudents.add(classStudent);
  }

  /**
   * used to remove mentor from mentor list
   *
   * @param classMentor mentor class object to remove from list
   */
  void removeClassMentor(Mentor classMentor) {
    this.classMentors.remove(classMentor);
  }

  /**
   * used to remove students from studentlist
   *
   * @param classStudent student class object to remove from list
   */
  void removeClassStudent(Student classStudent) {
    this.classStudents.remove(classStudent);
  }

  /**
   * used to print out class details
   */
  void classesPrinter() {
    System.out.printf("klasnaam: %-10s Mentoren: ", className);

    for (Mentor classMentor : classMentors) {
      System.out.printf("%-14s", classMentor.getName());
    }
    System.out.println();
    System.out.print("studenten: ");
    for (Student classStudent : classStudents) {
      System.out.printf("  " + classStudent.getName());
    }
    System.out.println("\n");
  }
}
