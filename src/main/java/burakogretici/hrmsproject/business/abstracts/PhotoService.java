package burakogretici.hrmsproject.business.abstracts;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PhotoService {

    Result addAndSave(Photo photo, MultipartFile file);

    Result add(Photo photo);

    DataResult<List<Photo>> getAll();

    DataResult<List<Photo>> getAllByCv_Id(int cvId);
}
