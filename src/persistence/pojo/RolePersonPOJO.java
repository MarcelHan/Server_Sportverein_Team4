package persistence.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "RolePerson", schema = "dbo", catalog = "Vereinsdatenbank")
@IdClass(RolePersonPOJOPK.class)
public class RolePersonPOJO {
    private int _roleId;
    private int _personId;
    private RolePOJO _roleByRoleId;
    private PersonPOJO _personByPersonId;

    @Id
    @Column(name = "roleID")
    public int getRoleId() {
        return _roleId;
    }

    public void setRoleId(int roleId) {
        _roleId = roleId;
    }

    @Id
    @Column(name = "personID")
    public int getPersonId() {
        return _personId;
    }

    public void setPersonId(int personId) {
        _personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolePersonPOJO that = (RolePersonPOJO) o;
        return _roleId == that._roleId &&
                _personId == that._personId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(_roleId, _personId);
    }

    @ManyToOne
    @JoinColumn(name = "roleID", referencedColumnName = "roleID", nullable = false, insertable = false, updatable = false)
    public RolePOJO getRoleByRoleId() {
        return _roleByRoleId;
    }

    public void setRoleByRoleId(RolePOJO roleByRoleId) {
        _roleByRoleId = roleByRoleId;
    }

    @ManyToOne
    @JoinColumn(name = "personID", referencedColumnName = "personID", nullable = false, insertable = false, updatable = false)
    public PersonPOJO getPersonByPersonId() {
        return _personByPersonId;
    }

    public void setPersonByPersonId(PersonPOJO personByPersonId) {
        _personByPersonId = personByPersonId;
    }
}
