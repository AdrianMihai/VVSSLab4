package MaxPointsParticipantsMV;

import MaxPointsParticipantsMV.Domain.Teme;
import MaxPointsParticipantsMV.Repository.TemeRepo;
import MaxPointsParticipantsMV.Service.ServiceTeme;
import MaxPointsParticipantsMV.Validator.TemeValidator;
import MaxPointsParticipantsMV.Validator.ValidationException;
import org.junit.Test;

public class ServiceTemeWBT {
    @Test
    public void addAssignment_success(){
        TemeValidator tv = new TemeValidator();
        TemeRepo tr = new TemeRepo(tv, "src/main/java/MaxPointsParticipantsMV/teme_test.xml");
        ServiceTeme st = new ServiceTeme(tr);

        int oldSize = tr.size();

        Teme tema1 = new Teme(oldSize + 1, "Tema 1", 10, 11);

        Teme result = st.add(tema1);

        assert(result.equals(tema1));
    }

    @Test(expected = ValidationException.class)
    public void addAssignment_fail_invalidDeadline_throwsValidationException(){
        TemeValidator tv = new TemeValidator();
        TemeRepo tr = new TemeRepo(tv, "src/main/java/MaxPointsParticipantsMV/teme_test.xml");
        ServiceTeme st = new ServiceTeme(tr);

        int oldSize = tr.size();

        Teme tema1 = new Teme(oldSize + 1, "Tema 1", 14, 15);

        st.add(tema1);
    }
}
