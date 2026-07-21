package Entity;
public class Student extends Person{
    private String schoolClass;

    public Student(String name, String id, int birthYear, String schoolClass) {
        super(name, id, birthYear);
        this.schoolClass = schoolClass;
    }

    public String getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(String schoolClass) {
        this.schoolClass = schoolClass;
    }

    @Override
    public String toString(){
        return ("Tên: "+getName() + ", MSSV: " +getId() + ", Năm sinh: "+getBirthYear()+ ", Lớp: "+getSchoolClass()+"\n");
    }
}
