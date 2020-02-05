package ua.site.model;

public class User {


    private int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private int subjectId;
    private String subject_col;
    private int specializationId;
    private String specialization;
    private int mark;


    public User(int id, String login, String password, String name, String surname, int subjectId, int specializationId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.subjectId = subjectId;
        this.specializationId = specializationId;
        this.mark = mark;

    }

    public User(int id, String login, String password, String name, String surname, int subjectId, int specializationId, int mark) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.subjectId = subjectId;
        this.specializationId = specializationId;
        this.mark = mark;

    }

    public User() {

    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String name, String surname) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getSubject_col() {
        return subject_col;
    }

    public void setSubject_col(String subject_col) {
        this.subject_col = subject_col;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
