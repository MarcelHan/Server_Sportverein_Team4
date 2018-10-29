package persistence.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PersonTeam", schema = "dbo", catalog = "Vereinsdatenbank")
@IdClass(PersonTeamPOJOPK.class)
public class PersonTeamPOJO {
    private int _personId;
    private int _teamId;
    private PersonPOJO _personByPersonId;
    private InternalTeamPOJO _internalTeamByTeamId;

    @Id
    @Column(name = "personID")
    public int getPersonId() {
        return _personId;
    }

    public void setPersonId(int personId) {
        _personId = personId;
    }

    @Id
    @Column(name = "teamID")
    public int getTeamId() {
        return _teamId;
    }

    public void setTeamId(int teamId) {
        _teamId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonTeamPOJO that = (PersonTeamPOJO) o;
        return _personId == that._personId &&
                _teamId == that._teamId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(_personId, _teamId);
    }

    @ManyToOne
    @JoinColumn(name = "personID", referencedColumnName = "personID", nullable = false, insertable=false, updatable = false)
    public PersonPOJO getPersonByPersonId() {
        return _personByPersonId;
    }

    public void setPersonByPersonId(PersonPOJO personByPersonId) {
        _personByPersonId = personByPersonId;
    }

    @ManyToOne
    @JoinColumn(name = "teamID", referencedColumnName = "teamID", nullable = false, insertable = false, updatable = false)
    public InternalTeamPOJO getInternalTeamByTeamId() {
        return _internalTeamByTeamId;
    }

    public void setInternalTeamByTeamId(InternalTeamPOJO internalTeamByTeamId) {
        _internalTeamByTeamId = internalTeamByTeamId;
    }
}
