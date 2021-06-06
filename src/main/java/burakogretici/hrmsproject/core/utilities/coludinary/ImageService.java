package burakogretici.hrmsproject.core.utilities.coludinary;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface ImageService {
    @SuppressWarnings("rawtypes")
    DataResult<Map> save(MultipartFile multipartFile) throws IOException;
}
