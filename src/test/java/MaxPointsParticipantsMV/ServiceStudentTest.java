package MaxPointsParticipantsMV;

import MaxPointsParticipantsMV.Domain.Student;
import MaxPointsParticipantsMV.Repository.StudentRepo;
import MaxPointsParticipantsMV.Service.ServiceStudent;
import MaxPointsParticipantsMV.Validator.StudentValidator;
import MaxPointsParticipantsMV.Validator.ValidationException;
import org.junit.Test;

public class ServiceStudentTest {
    // TC #1, EC 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 26
    @Test
    public void addStudent_success()
    {
        StudentValidator sv = new StudentValidator();
        StudentRepo sr = new StudentRepo(sv, "src/main/java/MaxPointsParticipantsMV/studenti_test.xml");
        ServiceStudent ss = new ServiceStudent(sr);

        int oldSize = sr.size();

        Student student1 = new Student(String.valueOf(oldSize + 1), "Rusu Iustin", 936, "riie2411@scs.ubbcluj.ro", "Andreea Vescan");

        Student result = ss.add(student1);

        assert(result.equals(student1));
    }

    // TC #2, EC 6, 30
    @Test
    public void addStudent_fail_idNotUnique()
    {
        StudentValidator sv = new StudentValidator();
        StudentRepo sr = new StudentRepo(sv, "src/main/java/MaxPointsParticipantsMV/studenti_test.xml");
        ServiceStudent ss = new ServiceStudent(sr);

        int oldSize = sr.size();

        Student student1 = new Student(String.valueOf(oldSize + 1), "Rusu Iustin", 936, "riie2411@scs.ubbcluj.ro", "Andreea Vescan");
        Student student2 = new Student(String.valueOf(oldSize + 1), "Serbanescu Adrian", 936, "saie2417@scs.ubbcluj.ro", "Andreea Vescan");

        ss.add(student1);
        Student result = ss.add(student2);

        assert(result == null);
    }

    // TC #3, EC 2, 26
    @Test(expected = ValidationException.class)
    public void addStudent_fail_idNull_throwsValidationException(){
        StudentValidator sv = new StudentValidator();
        StudentRepo sr = new StudentRepo(sv, "src/main/java/MaxPointsParticipantsMV/studenti_test.xml");
        ServiceStudent ss = new ServiceStudent(sr);

        Student student1 = new Student(null, "Rusu Iustin", 936, "riie2411@scs.ubbcluj.ro", "Andreea Vescan");

        ss.add(student1);
    }

    // TC #4, EC 4, 28
    @Test(expected = ValidationException.class)
    public void addStudent_fail_idEmptyString_throwsValidationException(){
        StudentValidator sv = new StudentValidator();
        StudentRepo sr = new StudentRepo(sv, "src/main/java/MaxPointsParticipantsMV/studenti_test.xml");
        ServiceStudent ss = new ServiceStudent(sr);

        Student student1 = new Student("", "Rusu Iustin", 936, "riie2411@scs.ubbcluj.ro", "Andreea Vescan");

        ss.add(student1);
    }

    // TC #5, EC 8, 28
    @Test(expected = ValidationException.class)
    public void addStudent_fail_nameNull_throwsValidationException(){
        StudentValidator sv = new StudentValidator();
        StudentRepo sr = new StudentRepo(sv, "src/main/java/MaxPointsParticipantsMV/studenti_test.xml");
        ServiceStudent ss = new ServiceStudent(sr);

        int oldSize = sr.size();

        Student student1 = new Student(String.valueOf(oldSize + 1), null, 936, "riie2411@scs.ubbcluj.ro", "Andreea Vescan");

        ss.add(student1);
    }

    // TC #6, EC 10, 28
    @Test(expected = ValidationException.class)
    public void addStudent_fail_nameEmptyString_throwsValidationException(){
        StudentValidator sv = new StudentValidator();
        StudentRepo sr = new StudentRepo(sv, "src/main/java/MaxPointsParticipantsMV/studenti_test.xml");
        ServiceStudent ss = new ServiceStudent(sr);

        int oldSize = sr.size();

        Student student1 = new Student(String.valueOf(oldSize + 1), "", 936, "riie2411@scs.ubbcluj.ro", "Andreea Vescan");

        ss.add(student1);
    }

    // TC #7, EC 12, 28
    @Test(expected = ValidationException.class)
    public void addStudent_fail_groupNegativeInteger_throwsValidationException(){
        StudentValidator sv = new StudentValidator();
        StudentRepo sr = new StudentRepo(sv, "src/main/java/MaxPointsParticipantsMV/studenti_test.xml");
        ServiceStudent ss = new ServiceStudent(sr);

        int oldSize = sr.size();

        Student student1 = new Student(String.valueOf(oldSize + 1), "Rusu Iustin", -1, "riie2411@scs.ubbcluj.ro", "Andreea Vescan");

        ss.add(student1);
    }

    // TC #8, EC 14, 28
    @Test(expected = ValidationException.class)
    public void addStudent_fail_groupInvalidFormat_throwsValidationException(){
        StudentValidator sv = new StudentValidator();
        StudentRepo sr = new StudentRepo(sv, "src/main/java/MaxPointsParticipantsMV/studenti_test.xml");
        ServiceStudent ss = new ServiceStudent(sr);

        int oldSize = sr.size();

        Student student1 = new Student(String.valueOf(oldSize + 1), "Rusu Iustin", 938, "riie2411@scs.ubbcluj.ro", "Andreea Vescan");

        ss.add(student1);
    }

    // TC #9, EC 16, 28
    @Test(expected = ValidationException.class)
    public void addStudent_fail_emailNull_throwsValidationException(){
        StudentValidator sv = new StudentValidator();
        StudentRepo sr = new StudentRepo(sv, "src/main/java/MaxPointsParticipantsMV/studenti_test.xml");
        ServiceStudent ss = new ServiceStudent(sr);

        int oldSize = sr.size();

        Student student1 = new Student(String.valueOf(oldSize + 1), "Rusu Iustin", 936, null, "Andreea Vescan");

        ss.add(student1);
    }

    // TC #10, EC 18, 28
    @Test(expected = ValidationException.class)
    public void addStudent_fail_emailEmptyString_throwsValidationException(){
        StudentValidator sv = new StudentValidator();
        StudentRepo sr = new StudentRepo(sv, "src/main/java/MaxPointsParticipantsMV/studenti_test.xml");
        ServiceStudent ss = new ServiceStudent(sr);

        int oldSize = sr.size();

        Student student1 = new Student(String.valueOf(oldSize + 1), "Rusu Iustin", 936, "", "Andreea Vescan");

        ss.add(student1);
    }

    // TC #11, EC 20, 28
    @Test(expected = ValidationException.class)
    public void addStudent_fail_emailInvalidFormat_throwsValidationException(){
        StudentValidator sv = new StudentValidator();
        StudentRepo sr = new StudentRepo(sv, "src/main/java/MaxPointsParticipantsMV/studenti_test.xml");
        ServiceStudent ss = new ServiceStudent(sr);

        int oldSize = sr.size();

        Student student1 = new Student(String.valueOf(oldSize + 1), "Rusu Iustin", 936, "saie2416scs.ubbcluj.ro", "Andreea Vescan");

        ss.add(student1);
    }

    // TC #12, EC 22, 28
    @Test(expected = ValidationException.class)
    public void addStudent_fail_professorNull_throwsValidationException(){
        StudentValidator sv = new StudentValidator();
        StudentRepo sr = new StudentRepo(sv, "src/main/java/MaxPointsParticipantsMV/studenti_test.xml");
        ServiceStudent ss = new ServiceStudent(sr);

        int oldSize = sr.size();

        Student student1 = new Student(String.valueOf(oldSize + 1), "Rusu Iustin", 936, "saie2416@scs.ubbcluj.ro", null);

        ss.add(student1);
    }

    // TC #13, EC 24, 28
    @Test(expected = ValidationException.class)
    public void addStudent_fail_professorEmptyString_throwsValidationException(){
        StudentValidator sv = new StudentValidator();
        StudentRepo sr = new StudentRepo(sv, "src/main/java/MaxPointsParticipantsMV/studenti_test.xml");
        ServiceStudent ss = new ServiceStudent(sr);

        int oldSize = sr.size();

        Student student1 = new Student(String.valueOf(oldSize + 1), "Rusu Iustin", 936, "saie2416@scs.ubbcluj.ro", "");

        ss.add(student1);
    }
}
