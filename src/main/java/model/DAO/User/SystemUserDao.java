package model.DAO.User;

import model.DAO.GenericDao;
import model.entity.user.SystemUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public ArrayList<SystemUser> findAll()
    {
        ArrayList<SystemUser> users = new ArrayList<>();
        List<?> list = super.findAll("SELECT * FROM SystemUser", SystemUser.class);
        for (Object obj : list) if (obj instanceof SystemUser) users.add((SystemUser) obj);
        return users;
    }

    public void update(SystemUser systemUser) {
        super.update(String.format("UPDATE SystemUser SET password = '%s', imageProfile = '%s' WHERE userLogin = '%s'",
                systemUser.getPassword(),
                Arrays.toString(systemUser.getImageProfile()),
                systemUser.getUserLogin()));
    }
}
