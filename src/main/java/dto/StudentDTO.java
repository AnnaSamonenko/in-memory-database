package dto;

public class StudentDTO {

    private String name;
    private String surname;
    private String university;
    private String faculty;
    private String group;
    private String course;

    public StudentDTO(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUniversity() {
        return university;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getGroup() {
        return group;
    }

    public String getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
