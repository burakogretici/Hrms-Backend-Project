package burakogretici.hrmsproject.business.abstracts;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.Talent;

import java.util.List;

public interface TalentService {
    Result add(Talent talent);

    DataResult<List<Talent>> getAll();

    DataResult<List<Talent>> getAllByCv_Id(int cvId);

}
