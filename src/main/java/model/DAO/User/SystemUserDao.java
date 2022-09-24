package model.DAO.User;

import model.DAO.GenericDao;
import model.entity.User.SystemUser;

import java.util.Arrays;

public class SystemUserDao extends GenericDao<SystemUser>
{
    // TODO: Testar inserir imagem (testado apenas passando null)
    public void create(String userLogin, String password, byte[] imageProfile) {
        if (find(userLogin) != null)
        {
            System.out.println("Tried to create a SystemUser row with userLogin " + userLogin + " but it already exist.");
            return;
        }
        super.create(new SystemUser(userLogin, password, imageProfile));
    }

    public void create(SystemUser systemUser) {
        super.create(systemUser);
    }

    public void remove(String userLogin) {
        super.remove(SystemUser.class, userLogin);
    }

    public void remove(SystemUser systemUser) {
        super.remove(SystemUser.class, systemUser.getUserLogin());
    }

    public SystemUser find(String userLogin) {
        return super.find(SystemUser.class, userLogin);
    }

    public void update(SystemUser systemUser) {
        super.update(String.format("UPDATE SystemUser SET password = '%s', imageProfile = '%s' WHERE userLogin = '%s'",
                systemUser.getPassword(),
                Arrays.toString(systemUser.getImageProfile()),
                systemUser.getUserLogin()));
    }
}
