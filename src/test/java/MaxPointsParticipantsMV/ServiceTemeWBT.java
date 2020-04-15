package MaxPointsParticipantsMV;

import MaxPointsParticipantsMV.Domain.Teme;
import MaxPointsParticipantsMV.Repository.TemeRepo;
import MaxPointsParticipantsMV.Service.ServiceTeme;
import MaxPointsParticipantsMV.Validator.TemeValidator;
import MaxPointsParticipantsMV.Validator.ValidationException;
import org.junit.Test;

public class ServiceTemeWBT {
    // TC #1
    @Test(expected = ValidationException.class)
    public void addAssignment_fail_nrNull_throwsValidationException() {
        TemeValidator tv = new TemeValidator();
        TemeRepo tr = new TemeRepo(tv, "src/main/java/MaxPointsParticipantsMV/teme_test.xml");
        ServiceTeme st = new ServiceTeme(tr);

        Teme tema1 = new Teme(null, "Assignment", 1, 2);

        st.add(tema1);
    }

    // TC #2
    @Test(expected = ValidationException.class)
    public void addAssignment_fail_nrLessThanOne_throwsValidationException() {
        TemeValidator tv = new TemeValidator();
        TemeRepo tr = new TemeRepo(tv, "src/main/java/MaxPointsParticipantsMV/teme_test.xml");
        ServiceTeme st = new ServiceTeme(tr);

        Teme tema1 = new Teme(0, "Assignment", 1, 2);

        st.add(tema1);
    }

    // TC #3
    @Test(expected = ValidationException.class)
    public void addAssignment_fail_deadlineGreaterThanFourteen_throwsValidationException() {
        TemeValidator tv = new TemeValidator();
        TemeRepo tr = new TemeRepo(tv, "src/main/java/MaxPointsParticipantsMV/teme_test.xml");
        ServiceTeme st = new ServiceTeme(tr);

        int oldSize = tr.size();

        Teme tema1 = new Teme(oldSize + 1, "Assignment", 1, 15);

        st.add(tema1);
    }

    // TC #4
    @Test(expected = ValidationException.class)
    public void addAssignment_fail_deadlineLessThanOne_throwsValidationException() {
        TemeValidator tv = new TemeValidator();
        TemeRepo tr = new TemeRepo(tv, "src/main/java/MaxPointsParticipantsMV/teme_test.xml");
        ServiceTeme st = new ServiceTeme(tr);

        int oldSize = tr.size();

        Teme tema1 = new Teme(oldSize + 1, "Assignment", 1, 0);

        st.add(tema1);
    }

    // TC #5
    @Test(expected = ValidationException.class)
    public void addAssignment_fail_sapt_primireLessThanOne_throwsValidationException() {
        TemeValidator tv = new TemeValidator();
        TemeRepo tr = new TemeRepo(tv, "src/main/java/MaxPointsParticipantsMV/teme_test.xml");
        ServiceTeme st = new ServiceTeme(tr);

        int oldSize = tr.size();

        Teme tema1 = new Teme(oldSize + 1, "Assignment", -1, 2);

        st.add(tema1);
    }

    // TC #6
    @Test(expected = ValidationException.class)
    public void addAssignment_fail_sapt_primireGreaterThanFourteen_throwsValidationException() {
        TemeValidator tv = new TemeValidator();
        TemeRepo tr = new TemeRepo(tv, "src/main/java/MaxPointsParticipantsMV/teme_test.xml");
        ServiceTeme st = new ServiceTeme(tr);

        int oldSize = tr.size();

        Teme tema1 = new Teme(oldSize + 1, "Assignment", 15, 2);

        st.add(tema1);
    }

    // TC #7
    @Test(expected = ValidationException.class)
    public void addAssignment_fail_nrNull_deadlineGreaterThanFourteen_throwsValidationException() {
        TemeValidator tv = new TemeValidator();
        TemeRepo tr = new TemeRepo(tv, "src/main/java/MaxPointsParticipantsMV/teme_test.xml");
        ServiceTeme st = new ServiceTeme(tr);

        Teme tema1 = new Teme(null, "Assignment", 1, 15);

        st.add(tema1);
    }

    // TC #8
    @Test(expected = ValidationException.class)
    public void addAssignment_fail_nrNull_sapt_primireGreaterThanFourteen_deadlineGreaterThanFourteen_throwsValidationException() {
        TemeValidator tv = new TemeValidator();
        TemeRepo tr = new TemeRepo(tv, "src/main/java/MaxPointsParticipantsMV/teme_test.xml");
        ServiceTeme st = new ServiceTeme(tr);

        Teme tema1 = new Teme(null, "Assignment", 15, 15);

        st.add(tema1);
    }

    // TC #9
    @Test(expected = ValidationException.class)
    public void addAssignment_fail_sapt_primireGreaterThanFourteen_deadlineGreaterThanFourteen_throwsValidationException() {
        TemeValidator tv = new TemeValidator();
        TemeRepo tr = new TemeRepo(tv, "src/main/java/MaxPointsParticipantsMV/teme_test.xml");
        ServiceTeme st = new ServiceTeme(tr);

        int oldSize = tr.size();

        Teme tema1 = new Teme(oldSize + 1, "Assignment", 15, 15);

        st.add(tema1);
    }

    // TC #10
    @Test(expected = ValidationException.class)
    public void addAssignment_fail_nrNull_sapt_primireGreaterThanFourteen_throwsValidationException() {
        TemeValidator tv = new TemeValidator();
        TemeRepo tr = new TemeRepo(tv, "src/main/java/MaxPointsParticipantsMV/teme_test.xml");
        ServiceTeme st = new ServiceTeme(tr);

        Teme tema1 = new Teme(null, "Assignment", 15, 2);

        st.add(tema1);
    }

    // TC #11
    @Test(expected = ValidationException.class)
    public void addAssignment_fail_deadlineLessThanSapt_primire_throwsValidationException() {
        TemeValidator tv = new TemeValidator();
        TemeRepo tr = new TemeRepo(tv, "src/main/java/MaxPointsParticipantsMV/teme_test.xml");
        ServiceTeme st = new ServiceTeme(tr);

        int oldSize = tr.size();

        Teme tema1 = new Teme(oldSize + 1, "Assignment", 10, 5);

        st.add(tema1);
    }

    // TC #12
    @Test
    public void addAssignment_success(){
        TemeValidator tv = new TemeValidator();
        TemeRepo tr = new TemeRepo(tv, "src/main/java/MaxPointsParticipantsMV/teme_test.xml");
        ServiceTeme st = new ServiceTeme(tr);

        int oldSize = tr.size();

        Teme tema1 = new Teme(oldSize + 1, "Assignment", 1, 2);

        Teme result = st.add(tema1);

        assert(result.equals(tema1));
    }
}
