package burakogretici.hrmsproject.business.abstracts;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.Cv;


import java.util.List;

public interface CvService {
    Result add(Cv cv);
    DataResult<List<Cv>> getAll();

    DataResult<List<Cv>> getByJobSeeker_Id(int jobSeekerId);
}
