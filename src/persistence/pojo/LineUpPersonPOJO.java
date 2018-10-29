package persistence.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LineUpPerson", schema = "dbo", catalog = "Vereinsdatenbank")
@IdClass(LineUpPersonPOJOPK.class)
public class LineUpPersonPOJO {
    private int _personId;
    private int _teamId;
    private int _encId;
    private PersonPOJO _personByPersonId;
    private InternalTeamPOJO _internalTeamByTeamId;
    private EncounterPOJO _encounterByEncId;

    @Id
    @Column(name = "personID")
    public int getPersonId() {
        return _personId;
    }

    public void setPersonId(int personId) {
        _personId = personId;
    }

    @Basic
    @Column(name = "teamID")
    public int getTeamId() {
        return _teamId;
    }

    public void setTeamId(int teamId) {
        _teamId = teamId;
    }

    @Id
    @Column(name = "encID")
    public int getEncId() {
        return _encId;
    }

    public void setEncId(int encId) {
        _encId = encId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineUpPersonPOJO that = (LineUpPersonPOJO) o;
        return _personId == that._personId &&
                _teamId == that._teamId &&
                _encId == that._encId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(_personId, _teamId, _encId);
    }

    @ManyToOne
    @JoinColumn(name = "personID", referencedColumnName = "personID", nullable = false, insertable = false, updatable = false)
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

    @ManyToOne
    @JoinColumn(name = "encID", referencedColumnName = "encounterID", nullable = false, insertable = false, updatable = false)
    public EncounterPOJO getEncounterByEncId() {
        return _encounterByEncId;
    }

    public void setEncounterByEncId(EncounterPOJO encounterByEncId) {
        _encounterByEncId = encounterByEncId;
    }
}
