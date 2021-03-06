package burakogretici.hrmsproject.business.concretes;

import burakogretici.hrmsproject.business.abstracts.PhotoService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.coludinary.ImageService;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.core.utilities.results.SuccessDataResult;
import burakogretici.hrmsproject.core.utilities.results.SuccessResult;
import burakogretici.hrmsproject.dataAccess.abstracts.PhotoDao;
import burakogretici.hrmsproject.entities.concretes.Cv;
import burakogretici.hrmsproject.entities.concretes.Photo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;


@Service
public class PhotoManager implements PhotoService {

    private PhotoDao photoDao;
    private ImageService imageService;

    public PhotoManager(PhotoDao photoDao,ImageService imageService) {
        this.photoDao = photoDao;
        this.imageService = imageService;
    }


    @Override
    public Result add(int cvId, MultipartFile multipartFile) throws IOException {
        var result = this.imageService.save(multipartFile);
        Cv cv = new Cv();
        Photo photo = new Photo();
        cv.setId(cvId);
        photo.setCv(cv);
        photo.setUrl(result.getData().get("url").toString());
        this.photoDao.save(photo);
        return new SuccessResult(Messages.photoAdded);
    }

    @Override
    public DataResult<List<Photo>> getAll() {
        return new SuccessDataResult<List<Photo>>(this.photoDao.findAll(), Messages.photoListed);

    }

    @Override
    public DataResult<Photo> getByCv_Id(int cvId) {
        return new SuccessDataResult<Photo>(this.photoDao.getByCv_Id(cvId));
    }
}
