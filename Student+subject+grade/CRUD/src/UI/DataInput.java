package UI;

import java.util.Scanner;
import Control.*;
import Control.Interfaces.ITypeCasting;
import Repository.GradeRepository;
import Repository.SubjectRepository;

public class DataInput implements ITypeCasting{
    Scanner scan = new Scanner(System.in);
    String subjectName;
    String idSubject;
    String creditsSubject;
    String iD;
    String scoreCc;
    String scoreGk;
    String scoreCk;
    CheckGradeData checkGradeData;
    CheckSubjectData checkSubjectData;
    CheckedResult check;
    GradeRepository repoGrade;
    SubjectRepository repoSub;
    public DataInput(GradeRepository repoGrade, SubjectRepository repoSub) {
        this.repoGrade = repoGrade;
        this.repoSub = repoSub;
        this.checkGradeData = new CheckGradeData(repoGrade);
        this.checkSubjectData = new CheckSubjectData(repoSub);
    }

    public String setIDSubjectInput(){
        do{
            System.out.println("Nhập mã môn học:");
            idSubject = scan.nextLine();
            check = checkGradeData.checkIDSubject(idSubject);
            System.out.println(check.getNotification());
        } while(!check.isResult());
        return idSubject;
    }
    public String setIDInput() {
        do {
            System.out.println("Nhập mã số sinh viên:");
            iD = scan.nextLine();
            check = checkGradeData.checkId(iD);
            System.out.println(check.getNotification());
        } while (!check.isResult());
        return iD;
    }



    public double setScoreCcInput() {
        do {
            System.out.println("Nhập điểm chuyên cần của sinh viên:");
            scoreCc = scan.nextLine();
            check = checkGradeData.checkScore(scoreCc);
            System.out.println(check.getNotification());
        } while (!check.isResult());
        return stringToScore(scoreCc);
    }

    public double setScoreGkInput() {
        do {
            System.out.println("Nhập điểm giữa kì của sinh viên:");
            scoreGk = scan.nextLine();
            check = checkGradeData.checkScore(scoreGk);
            System.out.println(check.getNotification());
        } while (!check.isResult());
        return stringToScore(scoreGk);
    }

    public double setScoreCkInput() {
        do {
            System.out.println("Nhập điểm cuối kì của sinh viên:");
            scoreCk = scan.nextLine();
            check = checkGradeData.checkScore(scoreCk);
            System.out.println(check.getNotification());
        } while (!check.isResult());
        return stringToScore(scoreCk);
    }

    public String setSubjectNameInput() {
        do {
            System.out.println("Nhập tên môn:");
            subjectName = scan.nextLine();
            check = checkSubjectData.checkSubjectName(subjectName);
            System.out.println(check.getNotification());
        } while (!check.isResult());
        return subjectName;
    }

    public int setCreditsSubject() {
        do {
            System.out.println("Nhập số tín chỉ của môn:");
            creditsSubject = scan.nextLine();
            check =checkSubjectData.checkCredits(creditsSubject);
            System.out.println(check.getNotification());
        } while (!check.isResult());
        return stringToInt(creditsSubject);
    }
}
