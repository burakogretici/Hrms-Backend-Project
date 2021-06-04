package burakogretici.hrmsproject.business.cloudServices.coludinary;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.ErrorDataResult;
import burakogretici.hrmsproject.core.utilities.results.SuccessDataResult;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageManager implements ImageService {
    private Environment environment;

    private Cloudinary cloudinary;

    @Autowired
    public ImageManager(Environment environment) {
        this.environment = environment;
        cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", environment.getProperty("dg53ygg5f"),
                                                        "api_key", environment.getProperty("199178955484794"), "api_secret", environment.getProperty("MwYkDgVx9a_MK_rKkFZvrVmKVlI")));
    }

    @Override
    public DataResult<?> save(final MultipartFile file) {
        Map result;
        try {
            result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        } catch (final IOException e) {
            e.printStackTrace();
            return new ErrorDataResult<Map>(e.getMessage());
        }

        return new SuccessDataResult<Map>(result);
    }

}

