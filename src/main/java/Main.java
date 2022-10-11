import com.gpti.bytego.controller.LoginController;
import com.gpti.bytego.model.DAO.Class.ClassProfessorDao;
import com.gpti.bytego.model.DAO.Class.ClassStudentDao;
import com.gpti.bytego.model.DAO.Class.ClassSubjectDao;
import com.gpti.bytego.model.DAO.Exam.ExamDao;
import com.gpti.bytego.model.DAO.Exam.ExamToTakeDao;
import com.gpti.bytego.model.DAO.User.ProfessorDao;
import com.gpti.bytego.model.DAO.User.StudentDao;
import com.gpti.bytego.model.DAO.User.SystemUserDao;
import com.gpti.bytego.model.DAO.question.QuestionAlternativeDao;
import com.gpti.bytego.model.DAO.question.QuestionAnswerDao;
import com.gpti.bytego.model.DAO.question.QuestionDao;

import java.sql.Timestamp;

public class Main
{
    public static void main(String[] args)
    {
        LoginController loginController = new LoginController();
        loginController.register("fabriciokashino@live.com", "pass123", null, "Fabricio");
        loginController.register("joao_pe_de_feijao@yahoo.com", "asda133", null, "João");
        loginController.register("maria.florentina@hotmail.com", "f09fu21", null, "Maria");
        loginController.register("acabou_jessica@gmail.com", "dfbt234", null, "Jessica");

        System.out.println(loginController.login("student1@hotmail.com", "123"));

        new SystemUserDao().create("student1@hotmail.com", "123", null);
        new SystemUserDao().create("student2@hotmail.com", "123", null);
        new SystemUserDao().create("student3@hotmail.com", "123", null);
        new SystemUserDao().create("student4@hotmail.com", "123", null);
        new SystemUserDao().create("student5@hotmail.com", "123", null);
        new SystemUserDao().create("student6@hotmail.com", "123", null);

        new SystemUserDao().create("professor1@hotmail.com", "123", null);
        new SystemUserDao().create("professor2@hotmail.com", "123", null);
        new SystemUserDao().create("professor3@hotmail.com", "123", null);

        new StudentDao().create("student1@hotmail.com", "student1");
        new StudentDao().create("student2@hotmail.com", "student2");
        new StudentDao().create("student3@hotmail.com", "student3");
        new StudentDao().create("student4@hotmail.com", "student4");
        new StudentDao().create("student5@hotmail.com", "student5");
        new StudentDao().create("student6@hotmail.com", "student5");

        new ProfessorDao().create("professor1@hotmail.com", "professor1");
        new ProfessorDao().create("professor2@hotmail.com", "professor2");
        new ProfessorDao().create("professor3@hotmail.com", "professor3");

        new ClassSubjectDao().create("computerID", "computer");
        new ClassSubjectDao().create("historyID", "history");
        new ClassProfessorDao().create("computerID", "professor1@hotmail.com");
        new ClassStudentDao().create("computerID", "student1@hotmail.com");
        new ClassStudentDao().create("computerID", "student2@hotmail.com");
        new ClassStudentDao().create("computerID", "student3@hotmail.com");
        new ClassStudentDao().create("computerID", "student4@hotmail.com");
        new ClassStudentDao().create("computerID", "student5@hotmail.com");

        new ClassStudentDao().create("historyID", "student5@hotmail.com");

        new ExamDao().create("computer-P1", 123123, 12, 2, "computerID");
        new ExamDao().create("computer-P2", 123123, 12, 2, "computerID");
        new ExamDao().create("computer-P3", 123123, 12, 2, "computerID");

        new ExamToTakeDao().create(1L, Timestamp.valueOf("2022-01-30 23:59:59"));
        new ExamToTakeDao().create(2L, Timestamp.valueOf("2022-01-30 23:59:59"));
        new ExamToTakeDao().create(3L, Timestamp.valueOf("2022-01-30 23:59:59"));

        new QuestionDao().create(1L, "Seja a funcao y = 2x. Enconter o valor de x que zera a funcao.", null, 20, "0",null);
        new QuestionDao().create(1L, "Seja a funcao y = 2x. 345345435345345345.", null, 20, "0",null);
        new QuestionDao().create(1L, "Seja a funcao y = 2x. E34534543543.", null, 20, "0",null);

        new QuestionDao().create(2L, "Seja a funcao y = 2x. Enconter o valor de x que zera a funcao.", null, 20, "0",null);
        new QuestionDao().create(2L, "Seja a funcao y = 2x. 345345435345345345.", null, 20, "0",null);
        new QuestionDao().create(2L, "Seja a funcao y = 2x. E34534543543.", null, 20, "0",null);

        new QuestionAlternativeDao().create(1L, 'a', "adasd", null);
        new QuestionAlternativeDao().create(1L, 'b', "adasd", null);
        new QuestionAlternativeDao().create(1L, 'c', "adasd", null);

        new QuestionAnswerDao().create("student1@hotmail.com", 'a', null, null, 0, 1L, "sadasda", "professor1@hotmail.com");
    }
}
