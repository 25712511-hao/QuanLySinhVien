package Control;

import Entity.Grade;
import Entity.Student;
import Entity.StudentReport;
import Entity.Subject;
import Repository.GradeRepository;
import Repository.StudentRepository;
import Repository.SubjectRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileOutput {
    StudentRepository stuSto;
    GradeRepository graSto;
    SubjectRepository subSto;

    GradeBusinessLogic findScore;
    StudentBusinessLogic findStu;
    SubjectBusinessLogic findSub;

    List<StudentReport> list = new ArrayList<>();
    public FileOutput(StudentBusinessLogic findStu, GradeBusinessLogic findScore, SubjectBusinessLogic findSub) {
        this.findStu = findStu;
        this.findScore = findScore;
        this.findSub = findSub;
        this.stuSto = findStu.getStorage();
        this.graSto = findScore.getStorage();
        this.subSto = findSub.getStorage();
    }

    public List<StudentReport> retakeStudent(){
        list.clear();
        for (Student stu : stuSto.getStudents()) {
            Grade stuGra = findScore.getGradeById(stu.getId());
            if(stuGra == null){
                continue;
            }
            if (stuGra.caculTotalScore() < 4 || stuGra.getScoreCk() < 3 || stuGra.getScoreGk() == 0) {
                Subject sub = findSub.getSubjectById(stuGra.getSubjectId());
                list.add(new StudentReport(stu, stuGra, sub));
            }
        }
        return list;
    }

    public boolean writeToFile() {
        retakeStudent();
        try ( BufferedWriter write = new BufferedWriter(new FileWriter("Test.txt"))){
            for(StudentReport stuRep : list){
                write.write(stuRep.toString());
                write.newLine();
            }

        }catch (IOException e){
            return false;
        }
        return true;
    }
}
