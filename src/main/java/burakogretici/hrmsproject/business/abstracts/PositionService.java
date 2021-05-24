package burakogretici.hrmsproject.business.abstracts;

import java.util.List;

import burakogretici.hrmsproject.entities.concretes.Position;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;

public interface PositionService {

    DataResult<List<Position>> getAll();
    Result add(Position position);
}