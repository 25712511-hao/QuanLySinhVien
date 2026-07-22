package Control;

import Control.Interfaces.*;
import Repository.StudentRepository;

public class CheckData implements ICheckName, ICheckYear, ICheckIdStudent, ICheckClass{
    private StudentRepository repo;
    public CheckData(StudentRepository repository) {
        this.repo = repository;
    }

    @Override
    public CheckedResult checkName(String name) {
        return ICheckName.super.checkName(name);
    }

    @Override
    public CheckedResult checkId(String id) {
        return ICheckIdStudent.super.checkId(id, repo);
    }

    @Override
    public CheckedResult checkYear(String year){
        return ICheckYear.super.checkYear(year);
    }

    @Override
    public CheckedResult checkSchoolClass(String schoolClass) {
        return ICheckClass.super.checkSchoolClass(schoolClass);
    }
}
