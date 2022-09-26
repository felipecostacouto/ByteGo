package model.DAO.Exam;

import model.entity.exam.Exam;
import model.entity.exam.SpecificExamInterface;

import java.util.ArrayList;

public interface SpecificExamDaoInterface
{
    ArrayList<SpecificExamInterface> findAllExamByUserLogin(String login);

    Exam findParentExamByID(Long examID);
}
