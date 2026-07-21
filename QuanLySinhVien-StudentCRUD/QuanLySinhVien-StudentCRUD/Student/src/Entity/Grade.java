package Entity;

public class Grade {
    private int studentId;
    private String subjectId;
    private double scoreCc;
    private double scoreGk;
    private double scoreCk;

    public Grade() {}

    public Grade(int studentId, String subjectId, double scoreCc, double scorGk, double scoreCk) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.scoreCc = scoreCc;
        this.scoreGk = scoreGk;
        this.scoreCk = scoreCk;
    }

    public int getStudentId() { return studentId; }
    public void setStudentId( int studentId ) { this.studentId = studentId; }


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
        if ( caculTotalScore() >= 9.0 ) return "A+";
        if ( caculTotalScore() >= 8.5 ) return "A";
        if ( caculTotalScore() >= 8.0 ) return "B+";
        if ( caculTotalScore() >= 7.0 ) return "B";
        if ( caculTotalScore() >= 6.0 ) return "C+";
        if ( caculTotalScore() >= 5.5 ) return "C";
        if ( caculTotalScore() >= 5.0 ) return "D+";
        if ( caculTotalScore() >= 4.0 ) return "D";
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

}