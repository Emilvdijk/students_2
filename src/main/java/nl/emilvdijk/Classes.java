package nl.emilvdijk;

import java.util.ArrayList;

class Classes {

  String className;
  ArrayList<Mentor> classMentors;
  ArrayList<Student> classStudents;

  /**
   * constructor for classes
   *
   * @param className     name of the class
   * @param classMentors  arraylist<Mentor>  list of mentor class objects
   * @param classStudents arraylist<Student> list of student class objects
   */
  public Classes(String className, ArrayList<Mentor> classMentors,
      ArrayList<Student> classStudents) {
    this.className = className;
    this.classMentors = classMentors;
    this.classStudents = classStudents;
  }

  /**
   * used to add mentor to mentorlist
   *
   * @param classMentor Mentor class object to add
   */
  public void addClassMentor(Mentor classMentor) {
    this.classMentors.add(classMentor);
  }

  /**
   * used to add student to student list
   *
   * @param classStudent student class object to add
   */
  public void addClassStudent(Student classStudent) {
    this.classStudents.add(classStudent);
  }

  /**
   * used to remove mentor from mentor list
   *
   * @param classMentor mentor class object to remove from list
   */
  public void removeClassMentor(Mentor classMentor) {
    this.classMentors.remove(classMentor);
  }

  /**
   * used to remove students from studentlist
   *
   * @param classStudent student class object to remove from list
   */
  public void removeClassStudent(Student classStudent) {
    this.classStudents.remove(classStudent);
  }

  /**
   * used to print out class details
   */
  void classesPrinter() {
    System.out.printf("klasnaam: %-10s Mentoren: ", className);
    if (classMentors != null) {
      for (int i = 0; i < classMentors.size(); i++) {
        System.out.printf("%-14s", classMentors.get(i).name);
      }
    }
    System.out.println();
    if (classStudents != null) {
      System.out.print("studenten: ");
      for (int i = 0; i < classStudents.size(); i++) {
        System.out.printf("  " + classStudents.get(i).name);
      }
    }
    System.out.println("\n");
  }
}
