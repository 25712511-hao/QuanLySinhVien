package Control;

import Control.Interfaces.*;
import Repository.GradeRepository;

public class CheckGradeData implements ICheckIDSubject,ICheckIdStudentWithoutCase, ICheckScore {
    private GradeRepository repo;

    public CheckGradeData(GradeRepository repository) {
        this.repo = repository;
    }

    @Override
    public CheckedResult checkIDSubject(String idSubject) {
        return ICheckIDSubject.super.checkIDSubject(idSubject);
    }

    @Override
    public CheckedResult checkId(String id) {
        return ICheckIdStudentWithoutCase.super.checkId(id);
    }

    @Override
    public CheckedResult checkScore(String score) {
        return ICheckScore.super.checkScore(score);
    }
}

