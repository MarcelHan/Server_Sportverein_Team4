package persistence.pojo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "internalTeam", schema = "dbo", catalog = "Vereinsdatenbank")
public class InternalTeamPOJO {
    private int _trainerId;
    private int _teamId;
    private Collection<LineUpPersonPOJO> _lineUpPeopleByTeamId;
    private Collection<PersonTeamPOJO> _personTeamsByTeamId;
    private PersonPOJO _personByTrainerId;
    private TeamPOJO _teamByTeamId;

    @Basic
    @Column(name = "trainerID")
    public int getTrainerId() {
        return _trainerId;
    }

    public void setTrainerId(int trainerId) {
        _trainerId = trainerId;
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
        InternalTeamPOJO that = (InternalTeamPOJO) o;
        return _trainerId == that._trainerId &&
                _teamId == that._teamId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(_trainerId, _teamId);
    }

    @OneToMany(mappedBy = "internalTeamByTeamId")
    public Collection<LineUpPersonPOJO> getLineUpPeopleByTeamId() {
        return _lineUpPeopleByTeamId;
    }

    public void setLineUpPeopleByTeamId(Collection<LineUpPersonPOJO> lineUpPeopleByTeamId) {
        _lineUpPeopleByTeamId = lineUpPeopleByTeamId;
    }

    @OneToMany(mappedBy = "internalTeamByTeamId")
    public Collection<PersonTeamPOJO> getPersonTeamsByTeamId() {
        return _personTeamsByTeamId;
    }

    public void setPersonTeamsByTeamId(Collection<PersonTeamPOJO> personTeamsByTeamId) {
        _personTeamsByTeamId = personTeamsByTeamId;
    }

    @ManyToOne
    @JoinColumn(name = "trainerID", referencedColumnName = "personID", nullable = false, insertable = false, updatable = false)
    public PersonPOJO getPersonByTrainerId() {
        return _personByTrainerId;
    }

    public void setPersonByTrainerId(PersonPOJO personByTrainerId) {
        _personByTrainerId = personByTrainerId;
    }

    @OneToOne
    @JoinColumn(name = "teamID", referencedColumnName = "teamID", nullable = false)
    public TeamPOJO getTeamByTeamId() {
        return _teamByTeamId;
    }

    public void setTeamByTeamId(TeamPOJO teamByTeamId) {
        _teamByTeamId = teamByTeamId;
    }
}
