package MaxPointsParticipantsMV;

import MaxPointsParticipantsMV.Domain.Student;
import MaxPointsParticipantsMV.Repository.StudentRepo;
import MaxPointsParticipantsMV.Service.ServiceStudent;
import MaxPointsParticipantsMV.Validator.StudentValidator;
import org.junit.Test;

public class ServiceStudentTest {
    @Test
    public void addStudent_success()
    {
        StudentValidator sv = new StudentValidator();
        StudentRepo sr = new StudentRepo(sv, "src/main/java/MaxPointsParticipantsMV/studenti_test.xml");
        ServiceStudent ss = new ServiceStudent(sr);

        int oldSize = sr.size();

        Student student1 = new Student(String.valueOf(oldSize + 1), "Rusu Iustin", 936, "riie2411@scs.ubbcluj.ro", "Andreea Vescan");

        assert(ss.add(student1).equals(student1));
    }

    @Test
    public void addStudent_fail_idNotUnique_throwsValidationException()
    {
        StudentValidator sv = new StudentValidator();
        StudentRepo sr = new StudentRepo(sv, "src/main/java/MaxPointsParticipantsMV/studenti_test.xml");
        ServiceStudent ss = new ServiceStudent(sr);

        int oldSize = sr.size();

        Student student1 = new Student(String.valueOf(oldSize + 1), "Rusu Iustin", 936, "riie2411@scs.ubbcluj.ro", "Andreea Vescan");
        Student student2 = new Student(String.valueOf(oldSize + 1), "Serbanescu Adrian", 936, "saie2417@scs.ubbcluj.ro", "Andreea Vescan");

        ss.add(student1);

        assert(ss.add(student2) == null);
    }
}
