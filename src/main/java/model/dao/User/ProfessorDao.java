package model.dao.User;

import model.dao.GenericDao;
import model.entity.User.*;

public class ProfessorDao extends GenericDao<Professor>
{
    public void create(String professorLogin, String name) {
        if (isDuplicatePrimaryKey(Professor.class, new ProfessorPK(professorLogin))) return;
        if (!doesExistForeignKey(professorLogin)) return;
        Professor professor = new Professor(new ProfessorPK(professorLogin), name);
        professor.setSystemUser(entityManager.getReference(SystemUser.class, professorLogin));
        professor.setName(name);
        super.create(professor);
    }

    public void create(Professor professor) {
        if (isDuplicatePrimaryKey(Professor.class, professor.getProfessorPK())) return;
        if (!doesExistForeignKey(professor.getProfessorPK().getProfessorLogin())) return;
        super.create(professor);
    }

    public void remove(String professorLogin) {
        if (!doesExistForeignKey(professorLogin)) return;
        super.remove(Professor.class, new ProfessorPK(professorLogin));
    }

    public void remove(Professor professor) {
        if (!doesExistForeignKey(professor.getProfessorPK().getProfessorLogin())) return;
        super.remove(Professor.class, professor.getProfessorPK());
    }

    public Professor find(String professorLogin) {
        return super.find(Professor.class, new ProfessorPK(professorLogin));
    }

    public void update(Professor professor) {
        super.update(String.format("UPDATE Professor SET name = '%s' WHERE professorLogin = '%s'",
                professor.getName(),
                professor.getProfessorPK().getProfessorLogin()));
    }

    private boolean doesExistForeignKey(String professorLogin)
    {
        if (new SystemUserDao().find(professorLogin) == null)
        {
            System.out.println("Does not exist a professor with login " + professorLogin +
                    " on referenced entity SystemUser");
            return false;
        }
        return true;
    }
}
