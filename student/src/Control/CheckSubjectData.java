package Control;

import Control.Interfaces.*;
import Repository.GradeRepository;
import Repository.SubjectRepository;

public class CheckSubjectData implements ICheckSubjectName, ICheckIDSubject, ICheckCredits {
    private SubjectRepository repo;

    public CheckSubjectData(SubjectRepository repository) {
        this.repo = repository;
    }

    @Override
    public CheckedResult checkSubjectName(String subjectName) {
        return ICheckSubjectName.super.checkSubjectName(subjectName);
    }

    @Override
    public CheckedResult checkIDSubject(String idSubject) {
        return ICheckIDSubject.super.checkIDSubject(idSubject);
    }

    @Override
    public CheckedResult checkCredits(String credits) {
        return ICheckCredits.super.checkCredits(credits);
    }
}

