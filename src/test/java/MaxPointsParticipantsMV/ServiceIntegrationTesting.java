package MaxPointsParticipantsMV;

import MaxPointsParticipantsMV.Domain.Student;
import MaxPointsParticipantsMV.Repository.StudentRepo;
import MaxPointsParticipantsMV.Service.ServiceStudent;
import MaxPointsParticipantsMV.Validator.StudentValidator;
import org.junit.Test;

public class ServiceIntegrationTesting {
    private class StudentValidatorStub extends StudentValidator {

        @Override
        public String validate(Student st) {
            return "";
        }
    }

    private class StudentRepositoryStub extends StudentRepo {

        public StudentRepositoryStub(StudentValidatorStub validator, String fileName) {
            super(validator, fileName);
        }

        @Override
        public Student save(Student stud) {
            if (stud.getID().equals("1")) {
                return stud;
            }

            return null;
        }
    }

    @Test()
    public void addStudentTestCase() {
        StudentRepositoryStub repo = new StudentRepositoryStub(
                new StudentValidatorStub(),
                "src/main/java/MaxPointsParticipantsMV/studenti_test.xml"
        );

        ServiceStudent service = new ServiceStudent(repo);
        Student s = new Student("1", "Whatever", 936, "", "prof");
        assert(service.add(s).getID().equals(s.getID()));

    }
}
