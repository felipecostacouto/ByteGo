package com.gpti.bytego.model.DAO.Exam;


import com.gpti.bytego.model.entity.exam.Exam;
import com.gpti.bytego.model.entity.exam.SpecificExamInterface;

import java.util.ArrayList;

public interface SpecificExamDaoInterface
{
    ArrayList<SpecificExamInterface> findAllExamByUserLogin(String login);

    Exam findParentExamByID(Long examID);
}
