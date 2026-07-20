package Entity;
public class Student extends Person{
    private String schoolClass;
    private String email;
    private int intakeNumber;

    public Student(String name, String id, int birthYear, String schoolClass, String email, int intakeNumber) {
        super(name, id, birthYear);
        this.schoolClass = schoolClass;
        this.email = email;
        this.intakeNumber = intakeNumber;
    }

    public String getSchoolClass() {
        return schoolClass;
    }

    public String getEmail() {
        return email;
    }

    public int getIntakeNumber() {
        return intakeNumber;
    }


    public void setSchoolClass(String schoolClass) {
        this.schoolClass = schoolClass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIntakeNumber(int intakeNumber) {
        this.intakeNumber = intakeNumber;
    }

    @Override
    public String toString(){
        return ("Tên: "+getName() + ", MSSV: " +getId() + ", Năm sinh: "+getBirthYear()+ ", Lớp: "+getSchoolClass()+ ", Email: "+getEmail()+ ", Khóa: "+getIntakeNumber()+"\n");
    }

    @Override
    String getInfo() {
        return "";
    }
}
