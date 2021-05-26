package burakogretici.hrmsproject.adapters;

import burakogretici.hrmsproject.business.abstracts.UserCheckService;
import burakogretici.hrmsproject.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

@Service
public class FakeCheckService implements UserCheckService {
    @Override
    public boolean CheckIfRealPerson(JobSeeker jobSeeker) {
        if (jobSeeker.getFirstName().equals("Burak") && jobSeeker.getLastName().equals("Öğretici") &&
                jobSeeker.getNationalityId().equals("12345678911")  && jobSeeker.getDateOfBirth().equals("10-01-1998")){
            return true;
        }
        return false;
    }
}
