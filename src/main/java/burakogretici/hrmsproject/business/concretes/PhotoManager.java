package burakogretici.hrmsproject.business.concretes;

import burakogretici.hrmsproject.business.cloudServices.coludinary.ImageService;
import burakogretici.hrmsproject.business.abstracts.PhotoService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.core.utilities.results.SuccessDataResult;
import burakogretici.hrmsproject.core.utilities.results.SuccessResult;
import burakogretici.hrmsproject.dataAccess.abstracts.PhotoDao;
import burakogretici.hrmsproject.entities.concretes.Photo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
import java.util.Map;

@Service
public class PhotoManager implements PhotoService {

    private PhotoDao photoDao;
    private ImageService imageService;

    public PhotoManager(PhotoDao photoDao,ImageService imageService) {
        this.photoDao = photoDao;
        this.imageService = imageService;
    }


    @Override
    public Result addAndSave(Photo photo, MultipartFile file) {
        Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
        photo.setUrl(result.get("url"));

        return add(photo);
    }

    @Override
    public Result add(Photo photo) {
        photoDao.save(photo);
        return new SuccessResult(Messages.photoAdded);
    }

    @Override
    public DataResult<List<Photo>> getAll() {
        List<Photo> photos = photoDao.findAll();

        return new SuccessDataResult<List<Photo>>(photos);
    }

    @Override
    public DataResult<List<Photo>> getAllByCv_Id(int cvId) {
        List<Photo> photos = photoDao.findAllByCv_Id(cvId);

        return new SuccessDataResult<List<Photo>>(photos);
    }
}
