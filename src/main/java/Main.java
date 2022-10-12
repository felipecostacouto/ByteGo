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
//        loginController.register("fabriciokashino@live.com", "pass123", null, "Fabricio");
//        loginController.register("joao_pe_de_feijao@yahoo.com", "asda133", null, "João");
//        loginController.register("maria.florentina@hotmail.com", "f09fu21", null, "Maria");
//        loginController.register("acabou_jessica@gmail.com", "dfbt234", null, "Jessica");
//
        System.out.println(loginController.login("student1@hotmail.com", "123"));
//
//        // Users
//        new SystemUserDao().create("student1@hotmail.com", "123", null);
//        new SystemUserDao().create("professor1@hotmail.com", "123", null);
//
//        new StudentDao().create("student1@hotmail.com", "student1");
//        new ProfessorDao().create("professor1@hotmail.com", "professor1");
//
//        // Class
//        new ClassSubjectDao().create("computerID", "computer");
//
//        new ClassStudentDao().create("computerID", "student1@hotmail.com");
//        new ClassProfessorDao().create("computerID", "professor1@hotmail.com");
//
//        // Exam
//        new ExamDao().create("computer-P1", 123123, 12, 2, "computerID");
//
//        new ExamToTakeDao().create(1L, Timestamp.valueOf("2022-01-30 23:59:59"));
//
//        // Question
//        new QuestionDao().create(1L, "Enunciado da questao 1", null, 20, "0",null);
//        new QuestionDao().create(1L, "Enunciado da questao 2", null, 10, "123",null);
//        new QuestionDao().create(1L, "Enunciado da questao 3", null, 15, "546asd",null);
//
//        new QuestionAlternativeDao().create(1L, 'a', "adasd", null);
//        new QuestionAlternativeDao().create(1L, 'b', "adasd", null);
//        new QuestionAlternativeDao().create(1L, 'c', "adasd", null);
//
//        new QuestionAnswerDao().create("student1@hotmail.com", 'a', null, null, 0, 1L, "sadasda", "professor1@hotmail.com");
//
    }
}
