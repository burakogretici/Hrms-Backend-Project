package burakogretici.hrmsproject.adapters;

import burakogretici.hrmsproject.business.abstracts.UserCheckService;
import burakogretici.hrmsproject.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

@Service
public class FakeCheckService implements UserCheckService {
    @Override
    public boolean CheckIfRealPerson(JobSeeker jobSeeker) {
        if (jobSeeker.getFirstName().length() > 2 && jobSeeker.getLastName().length() >2 &&
                jobSeeker.getNationalityId().length() < 12 ){
            return true;
        }
        return false;
    }
}
