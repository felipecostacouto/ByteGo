package model.DAO.User;

import model.DAO.GenericDao;
import model.entity.User.*;

public class AdministratorDao extends GenericDao<Administrator>
{
    public void create(String ADMlogin, String name) {
        if (isDuplicatePrimaryKey(Administrator.class, new AdministratorPK(ADMlogin))) return;
        if (!doesExistForeignKey(ADMlogin)) return;
        Administrator administrator = new Administrator(new AdministratorPK(ADMlogin), name);
        administrator.setSystemUser(entityManager.getReference(SystemUser.class, ADMlogin));
        administrator.setName(name);
        super.create(administrator);
    }

    public void create(Administrator administrator) {
        if (isDuplicatePrimaryKey(Administrator.class, administrator.getAdministratorPK())) return;
        if (!doesExistForeignKey(administrator.getAdministratorPK().getADMlogin())) return;
        super.create(administrator);
    }

    public void remove(String ADMLogin) {
        if (!doesExistForeignKey(ADMLogin)) return;
        super.remove(Administrator.class, new AdministratorPK(ADMLogin));
    }

    public void remove(Administrator administrator) {
        if (!doesExistForeignKey(administrator.getAdministratorPK().getADMlogin())) return;
        super.remove(Administrator.class, administrator.getAdministratorPK());
    }

    public Administrator find(String ADMLogin) {
        return super.find(Administrator.class, new AdministratorPK(ADMLogin));
    }

    public void update(Administrator administrator) {
        super.update(String.format("UPDATE Administrator SET name = '%s' WHERE ADMLogin = '%s'",
                administrator.getName(),
                administrator.getAdministratorPK().getADMlogin()));
    }

    private boolean doesExistForeignKey(String ADMLogin)
    {
        if (new SystemUserDao().find(ADMLogin) == null)
        {
            System.out.println("Does not exist a administrator with login " + ADMLogin +
                    " on referenced entity SystemUser");
            return false;
        }
        return true;
    }
}
