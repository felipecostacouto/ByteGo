package com.gpti.bytego.model.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AdministratorPK
{
    @Column(name = "ADMlogin")
    private String ADMlogin;

    public AdministratorPK() {}

    public AdministratorPK(String ADMlogin) {
        this.ADMlogin = ADMlogin;
    }

    public String getADMlogin() {
        return ADMlogin;
    }

    public void setADMlogin(String ADMlogin) {
        this.ADMlogin = ADMlogin;
    }

    @Override
    public String toString() {
        return ADMlogin;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AdministratorPK)
        {
            return ((AdministratorPK) obj).getADMlogin().equals(ADMlogin);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
