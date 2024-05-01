package nl.emilvdijk.schooldirectory;

import java.util.Objects;

public class Subject {

  private String name;
  private Teacher teacher;
  private int maxsize;

  /**
   * constructor for subject objects
   *
   * @param name name of subject
   * @param teacher teacher of subject
   * @param maxsize maximal amount of students for subject
   */
  public Subject(String name, Teacher teacher, int maxsize) {
    this.name = name;
    this.teacher = teacher;
    this.maxsize = maxsize;
  }

  /**
   * returns subject object name
   * @return subject object name
   */
  public String getName() {
    return name;
  }

  /**
   * returns teacher object of subject object
   * @return teacher object of subject object
   */
  public Teacher getTeacher() {
    return teacher;
  }

  /**
   * returns max size of subject object
   * @return max size of subject object
   */
  public int getMaxsize() {
    return maxsize;
  }

  /**
   * returns formated string of subject details
   * @return formated string of subject details
   */
  @Override
  public String toString() {
    return "name: %-14s leraar: %-14s  max leerlingen: %-4s".formatted(this.name, this.teacher.getName(),this.maxsize);
  }


  /**
   * overide of regular equals method
   *
   * @param o object to compare to
   * @return returns true or false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Subject subject = (Subject) o;
    return maxsize == subject.maxsize && Objects.equals(name, subject.name)
        && Objects.equals(teacher, subject.teacher);
  }
}
