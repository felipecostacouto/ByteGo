package model.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProfessorPK
{
    @Column(name = "professorLogin")
    private String professorLogin;

    public ProfessorPK() {}

    public ProfessorPK(String professorLogin) {
        this.professorLogin = professorLogin;
    }

    public String getProfessorLogin() {
        return professorLogin;
    }

    public void setProfessorLogin(String professorLogin) {
        this.professorLogin = professorLogin;
    }

    @Override
    public String toString() {
        return professorLogin;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ProfessorPK)
        {
            return ((ProfessorPK) obj).getProfessorLogin().equals(professorLogin);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
