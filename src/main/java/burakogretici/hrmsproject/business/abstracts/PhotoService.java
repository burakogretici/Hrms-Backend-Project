package burakogretici.hrmsproject.business.abstracts;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PhotoService {

    Result add(int cvId, MultipartFile file) throws IOException;

    DataResult<List<Photo>> getAll();

    DataResult<Photo> getByCv_Id(int cvId);
}
