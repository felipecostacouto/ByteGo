package com.gpti.bytego.model.entity.user;

import jakarta.persistence.*;

@Entity
@Table(name = "Administrator")
public class Administrator implements User
{
    @EmbeddedId
    private AdministratorPK administratorPK;
    @MapsId(value = "ADMlogin")
    @JoinColumn(name = "ADMlogin", referencedColumnName = "userLogin")
    @Transient
    private SystemUser systemUser;
    @Column(name = "name", nullable = false, length = 200)
    private String name;

    public Administrator() {}

    public Administrator(AdministratorPK administratorPK, String name) {
        this.administratorPK = administratorPK;
        this.name = name;
    }

    public AdministratorPK getAdministratorPK() {
        return administratorPK;
    }

    public void setAdministratorPK(AdministratorPK administratorPK) {
        this.administratorPK = administratorPK;
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public UserType getUserType() {
        return UserType.ADMINISTRATOR;
    }
}
