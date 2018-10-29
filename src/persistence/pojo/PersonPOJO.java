package persistence.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Person", schema = "dbo", catalog = "Vereinsdatenbank")
public class PersonPOJO {
    private int _personId;
    private String _firstName;
    private String _lastName;
    private Date _dateOfBirth;
    private Collection<DepartmentPOJO> _departmentsByPersonId;
    private Collection<LineUpPersonPOJO> _lineUpPeopleByPersonId;
    private Collection<PersonTeamPOJO> _personTeamsByPersonId;
    private Collection<RolePersonPOJO> _rolePeopleByPersonId;
    private Collection<InternalTeamPOJO> _internalTeamsByPersonId;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "personID")
    public int getPersonId() {
        return _personId;
    }

    public void setPersonId(int personId) {
        _personId = personId;
    }

    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    @Basic
    @Column(name = "dateOfBirth")
    public Date getDateOfBirth() {
        return _dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        _dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonPOJO that = (PersonPOJO) o;
        return _personId == that._personId &&
                Objects.equals(_firstName, that._firstName) &&
                Objects.equals(_lastName, that._lastName) &&
                Objects.equals(_dateOfBirth, that._dateOfBirth);
    }

    @Override
    public int hashCode() {

        return Objects.hash(_personId, _firstName, _lastName, _dateOfBirth);
    }

    @OneToMany(mappedBy = "personByHeadOfDeptId")
    public Collection<DepartmentPOJO> getDepartmentsByPersonId() {
        return _departmentsByPersonId;
    }

    public void setDepartmentsByPersonId(Collection<DepartmentPOJO> departmentsByPersonId) {
        _departmentsByPersonId = departmentsByPersonId;
    }

    @OneToMany(mappedBy = "personByPersonId")
    public Collection<LineUpPersonPOJO> getLineUpPeopleByPersonId() {
        return _lineUpPeopleByPersonId;
    }

    public void setLineUpPeopleByPersonId(Collection<LineUpPersonPOJO> lineUpPeopleByPersonId) {
        _lineUpPeopleByPersonId = lineUpPeopleByPersonId;
    }

    @OneToMany(mappedBy = "personByPersonId")
    public Collection<PersonTeamPOJO> getPersonTeamsByPersonId() {
        return _personTeamsByPersonId;
    }

    public void setPersonTeamsByPersonId(Collection<PersonTeamPOJO> personTeamsByPersonId) {
        _personTeamsByPersonId = personTeamsByPersonId;
    }

    @OneToMany(mappedBy = "personByPersonId")
    public Collection<RolePersonPOJO> getRolePeopleByPersonId() {
        return _rolePeopleByPersonId;
    }

    public void setRolePeopleByPersonId(Collection<RolePersonPOJO> rolePeopleByPersonId) {
        _rolePeopleByPersonId = rolePeopleByPersonId;
    }

    @OneToMany(mappedBy = "personByTrainerId")
    public Collection<InternalTeamPOJO> getInternalTeamsByPersonId() {
        return _internalTeamsByPersonId;
    }

    public void setInternalTeamsByPersonId(Collection<InternalTeamPOJO> internalTeamsByPersonId) {
        _internalTeamsByPersonId = internalTeamsByPersonId;
    }
}
