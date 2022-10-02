package com.gpti.bytego.model.DAO.Class;

import com.gpti.bytego.model.entity.classroom.ClassroomIndicator;

import java.util.ArrayList;

public interface ClassDao
{
    ArrayList<ClassroomIndicator> findAllByUser(String username);
}
