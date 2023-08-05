package model;

public class Student {
    private String studentUserName;
    private String studentPassword;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentUserName() {
        return studentUserName;
    }

    public void setStudentUserName(String studentUserName) {
        this.studentUserName = studentUserName;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }
}
