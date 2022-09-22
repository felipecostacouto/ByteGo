package model.entity.User;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import static jakarta.persistence.InheritanceType.JOINED;

@Entity
@Inheritance(strategy = JOINED)
@Table(name = "SystemUser")
public class SystemUser
{
    @Id
    @Column(name = "userLogin", nullable = false, length = 40)
    private String userLogin;
    @Column(name = "password", nullable = false, length = 40)
    private String password;
    @Column(name = "imageProfile")
    private byte[] imageProfile;

    public SystemUser() {}

    public SystemUser(String userLogin, String password, byte[] imageProfile) {
        this.userLogin = userLogin;
        this.password = password;
        this.imageProfile = imageProfile;
    }

    protected SystemUser(String userLogin)
    {
        this.userLogin = userLogin;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(byte[] imageProfile) {
        this.imageProfile = imageProfile;
    }
}
