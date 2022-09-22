import model.dao.Exam.DoneExamDao;
import model.dao.Exam.ExamDao;
import model.dao.Exam.ExamToTakeDao;
import model.dao.Exam.QuestionDao;
import model.entity.Exam.Question;
import model.entity.Management.ADMOperation;

import java.sql.Date;
import java.sql.Timestamp;

public class Main
{
    public static void main(String[] args)
    {
//        PersonView personView = new PersonView(new PersonService());

//        Server server = new Server(InetAddress.getByName("localhost").getHostAddress(), 8888);
//        server.addResponseForPath(personView.getHandlers());
//        server.startListening();

//        new SystemUserDao().create("fabriciokashino@live.com", "12345", null);
//        new SystemUserDao().create("usuario@live.com", "12345", null);
//        new AdministratorDao().create("fabriciokashino@live.com", "fabricio");

//
//        TableTestttDao tableTestttDao = new TableTestttDao();
//        tableTestttDao.create("fabriciokashino@live.com");

//        new ExamDao().create("Prova I", 1000, 6, 4);
//        new ExamDao().create("Prova II", 1300, 2, 4);
//        new SystemUserDao().create("aluno1@hotmail.com", "password1231", null);
//        new SystemUserDao().create("aluno2@hotmail.com", "password1231", null);
//        new SystemUserDao().create("aluno3@hotmail.com", "password1231", null);
//        new SystemUserDao().create("aluno4@hotmail.com", "password1231", null);
//        new SystemUserDao().create("aluno5@hotmail.com", "password1231", null);
//        new StudentDao().create("aluno1@hotmail.com", "Fernando");
//        new DoneExamDao().create(2L, "aluno1@hotmail.com", 12.23F);
//        ExamToTake examToTake = new ExamToTakeDao().find(2L);
//        System.out.println(examToTake.getLimitDate());
//        System.out.println(examToTake.getStudent().getStudentPK().getStudentLogin());
//        examToTake.setLimitDate(new Timestamp(123123L));
//        new ExamToTakeDao().update(examToTake);
        //new QuestionDao().create(1L, "seja x tal que x < 1 sen", null, 2);
        Question question = new QuestionDao().find(1L);
        question.setDifficulty(123);
        new QuestionDao().update(question);
    }
}