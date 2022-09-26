package model.DAO.Management;

import model.DAO.GenericDao;
import model.entity.management.ADMOperation;
import model.entity.management.UserManageHistory;
import model.entity.user.Administrator;
import model.entity.user.AdministratorPK;
import model.entity.user.SystemUser;

import java.sql.Timestamp;

public class UserManageHistoryDao extends GenericDao<UserManageHistory>
{
    public void create(Timestamp timestamp, String userLogin, String ADMLogin, ADMOperation operation) {
        UserManageHistory userManageHistory = new UserManageHistory();
        userManageHistory.setDate(timestamp);
        userManageHistory.setSystemUser(entityManager.getReference(SystemUser.class, userLogin));
        userManageHistory.setAdministrator(entityManager.getReference(Administrator.class, new AdministratorPK(ADMLogin)));
        userManageHistory.setOperation(operation);
        super.create(userManageHistory);
    }

    public void create(UserManageHistory userManageHistory)
    {
        userManageHistory.setSystemUser(entityManager.getReference(SystemUser.class, userManageHistory.getSystemUser().getUserLogin()));
        userManageHistory.setAdministrator(entityManager.getReference(Administrator.class, userManageHistory.getAdministrator().getAdministratorPK()));
        super.create(userManageHistory);
    }

    public void remove(Long ID)
    {
        super.remove(UserManageHistory.class, ID);
    }

    public UserManageHistory find(Long ID)
    {
        return super.find(UserManageHistory.class, ID);
    }
}
