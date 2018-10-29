package persistence.pojo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Role", schema = "dbo", catalog = "Vereinsdatenbank")
public class RolePOJO {
    private int _roleId;
    private String _roleName;
    private Collection<RolePersonPOJO> _rolePeopleByRoleId;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "roleID")
    public int getRoleId() {
        return _roleId;
    }

    public void setRoleId(int roleId) {
        _roleId = roleId;
    }

    @Basic
    @Column(name = "roleName")
    public String getRoleName() {
        return _roleName;
    }

    public void setRoleName(String roleName) {
        _roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolePOJO rolePOJO = (RolePOJO) o;
        return _roleId == rolePOJO._roleId &&
                Objects.equals(_roleName, rolePOJO._roleName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(_roleId, _roleName);
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<RolePersonPOJO> getRolePeopleByRoleId() {
        return _rolePeopleByRoleId;
    }

    public void setRolePeopleByRoleId(Collection<RolePersonPOJO> rolePeopleByRoleId) {
        _rolePeopleByRoleId = rolePeopleByRoleId;
    }
}
