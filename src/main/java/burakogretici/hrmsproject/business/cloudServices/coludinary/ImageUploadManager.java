package burakogretici.hrmsproject.business.cloudServices.coludinary;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.SuccessDataResult;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ImageUploadManager implements ImageService {
    private Cloudinary cloudinary;
    private Map<String, String> valuesMap = new HashMap<>();

    public ImageUploadManager() {
        valuesMap.put("cloud_name", "dg53ygg5f");
        valuesMap.put("api_key", "199178955484794");
        valuesMap.put("api_secret", "MwYkDgVx9a_MK_rKkFZvrVmKVlI");
        this.cloudinary = new Cloudinary(valuesMap);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public DataResult<Map> save(MultipartFile multipartFile) throws IOException {
        File file = fileConvert(multipartFile);
        Map resultMap = this.cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return new SuccessDataResult<>(resultMap);
    }

    private File fileConvert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();
        return file;
    }


}

