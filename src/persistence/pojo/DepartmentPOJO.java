package persistence.pojo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Department", schema = "dbo", catalog = "Vereinsdatenbank")
public class DepartmentPOJO {
    private String _deptName;
    private int _deptId;
    private int _headOfDeptId;
    private PersonPOJO _personByHeadOfDeptId;
    private Collection<SportPOJO> _sportsByDeptId;

    @Basic
    @Column(name = "deptName")
    public String getDeptName() {
        return _deptName;
    }

    public void setDeptName(String deptName) {
        _deptName = deptName;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "deptID")
    public int getDeptId() {
        return _deptId;
    }

    public void setDeptId(int deptId) {
        _deptId = deptId;
    }

    @Basic
    @Column(name = "headOfDeptID")
    public int getHeadOfDeptId() {
        return _headOfDeptId;
    }

    public void setHeadOfDeptId(int headOfDeptId) {
        _headOfDeptId = headOfDeptId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentPOJO that = (DepartmentPOJO) o;
        return _deptId == that._deptId &&
                _headOfDeptId == that._headOfDeptId &&
                Objects.equals(_deptName, that._deptName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(_deptName, _deptId, _headOfDeptId);
    }

    @ManyToOne
    @JoinColumn(name = "headOfDeptID", referencedColumnName = "personID", nullable = false, insertable = false, updatable = false)
    public PersonPOJO getPersonByHeadOfDeptId() {
        return _personByHeadOfDeptId;
    }

    public void setPersonByHeadOfDeptId(PersonPOJO personByHeadOfDeptId) {
        _personByHeadOfDeptId = personByHeadOfDeptId;
    }

    @OneToMany(mappedBy = "departmentByDeptId")
    public Collection<SportPOJO> getSportsByDeptId() {
        return _sportsByDeptId;
    }

    public void setSportsByDeptId(Collection<SportPOJO> sportsByDeptId) {
        _sportsByDeptId = sportsByDeptId;
    }
}
