package Entity;

public class StudentReport {
    private Student stu;
    private Grade gra;
    private Subject sub;

    public StudentReport(Student stu, Grade gra, Subject sub) {
        this.stu = stu;
        this.gra = gra;
        this.sub = sub;
    }

    public Student getStu() {
        return stu;
    }

    public Grade getGra() {
        return gra;
    }

    public Subject getSub() {
        return sub;
    }

    @Override
    public String toString() {
        return getStu().toString() + getSub().toString() +" Điểm chuyên cần: " +getGra().getScoreCc() + " điểm giữa kỳ: "+getGra().getScoreGk()+ " điểm cuối kì: "+getGra().getScoreCk()+ " GPA: "+getGra().gradePointAverage()+ "("+getGra().getGradeLetter()+")\n";
    }
}
