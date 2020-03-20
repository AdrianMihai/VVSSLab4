package MaxPointsParticipantsMV;

import MaxPointsParticipantsMV.Domain.Student;
import MaxPointsParticipantsMV.Repository.StudentRepo;
import MaxPointsParticipantsMV.Service.ServiceStudent;
import MaxPointsParticipantsMV.Validator.StudentValidator;
import MaxPointsParticipantsMV.Validator.ValidationException;
import org.junit.Test;

public class ServiceStudentTest {
    @Test
    public void addStudent_addSuccessfulTest()
    {
        StudentValidator sv = new StudentValidator();
        StudentRepo sr = new StudentRepo(sv, "src/main/java/MaxPointsParticipantsMV/studenti_test.xml");
        ServiceStudent ss = new ServiceStudent(sr);

        int oldSize = sr.size();

        Student student1 = new Student(String.valueOf(oldSize + 1), "Rusu Iustin", 936, "riie2411@scs.ubbcluj.ro", "Andreea Vescan");
        ss.add(student1);

        assert(sr.size() == oldSize + 1);
        assert(sr.findOne("1").getNume().equals("Rusu Iustin"));
    }

    @Test(expected = ValidationException.class)
    public void addStudent_ThrowsValidationException()
    {
        StudentValidator sv = new StudentValidator();
        StudentRepo sr = new StudentRepo(sv, "src/main/java/MaxPointsParticipantsMV/studenti_test.xml");
        ServiceStudent ss = new ServiceStudent(sr);

        int oldSize = sr.size();

        Student student1 = new Student(String.valueOf(oldSize + 1), "Rusu Iustin", 400, "riie2411@scs.ubbcluj.ro", "Andreea Vescan");

        ss.add(student1);
    }
}
