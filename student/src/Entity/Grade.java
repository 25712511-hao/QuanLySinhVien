package Entity;

public class Grade {
    private String studentId;
    private String subjectId;
    private double scoreCc;
    private double scoreGk;
    private double scoreCk;

    public Grade() {}

    public Grade(String studentId, String subjectId, double scoreCc, double scoreGk, double scoreCk) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.scoreCc = scoreCc;
        this.scoreGk = scoreGk;
        this.scoreCk = scoreCk;
    }


    public String getStudentId() { return studentId; }
    public void setStudentId( String studentId ) { this.studentId = studentId; }


    public String getSubjectId() { return subjectId; }
    public void setSubjectId( String subjectId ) { this.subjectId = subjectId; }


    public double getScoreCc() { return scoreCc; }
    public void setScoreCc( double scoreCc ) { this.scoreCc = scoreCc; }


    public double getScoreGk() { return scoreGk; }
    public void setScoreGk( double scoreGk ) { this.scoreGk = scoreGk; }


    public double getScoreCk() { return scoreCk; }
    public void setScoreCk( double scoreCk ) { this.scoreCk = scoreCk; }


    public double caculTotalScore() {
        return (scoreCc * 0.2) + (scoreGk * 0.3) + (scoreCk * 0.5);
    }


    public String getGradeLetter() {
        double toTal = caculTotalScore();
        if ( toTal >= 9.0 ) return "A+";
        if ( toTal >= 8.5 ) return "A";
        if ( toTal >= 8.0 ) return "B+";
        if ( toTal >= 7.0 ) return "B";
        if ( toTal >= 6.0 ) return "C+";
        if ( toTal >= 5.5 ) return "C";
        if ( toTal >= 5.0 ) return "D+";
        if ( toTal >= 4.0 ) return "D";
        return "F";
    }

    public double gradePointAverage() {
        switch (getGradeLetter()) {
            case "A+": return 4.0;
            case "A": return 3.8;
            case "B+": return 3.5;
            case "B": return 3.0;
            case "C+": return 2.5;
            case "C": return 2.0;
            case "D+": return 1.5;
            case "D": return 1.0;
            default: return 0.0;
        }
    }

    @Override
    public String toString(){
        return "MSSV: " + studentId + " - " + "Mã môn: " +subjectId + " - " + "Điểm chuyên cần: "+scoreCc + " - " + "Điểm giữa kì: "+scoreGk + " - " + "Điểm cuối kì: "+scoreCk + " - " + "GPA: "+gradePointAverage() + "\n";
    }

}