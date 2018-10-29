package persistence.pojo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Encounter", schema = "dbo", catalog = "Vereinsdatenbank")
public class EncounterPOJO {
    private int _encounterId;
    private int _resultId;
    private int _team1Id;
    private int _team2Id;
    private ResultPOJO _resultByResultId;
    private TeamPOJO _teamByTeam1Id;
    private TeamPOJO _teamByTeam2Id;
    private Collection<LineUpPersonPOJO> _lineUpPeopleByEncounterId;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "encounterID")
    public int getEncounterId() {
        return _encounterId;
    }

    public void setEncounterId(int encounterId) {
        _encounterId = encounterId;
    }

    @Basic
    @Column(name = "resultID")
    public int getResultId() {
        return _resultId;
    }

    public void setResultId(int resultId) {
        _resultId = resultId;
    }

    @Basic
    @Column(name = "team1ID")
    public int getTeam1Id() {
        return _team1Id;
    }

    public void setTeam1Id(int team1Id) {
        _team1Id = team1Id;
    }

    @Basic
    @Column(name = "team2ID")
    public int getTeam2Id() {
        return _team2Id;
    }

    public void setTeam2Id(int team2Id) {
        _team2Id = team2Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncounterPOJO that = (EncounterPOJO) o;
        return _encounterId == that._encounterId &&
                _resultId == that._resultId &&
                _team1Id == that._team1Id &&
                _team2Id == that._team2Id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(_encounterId, _resultId, _team1Id, _team2Id);
    }

    @ManyToOne
    @JoinColumn(name = "resultID", referencedColumnName = "resultID", nullable = false, insertable = false, updatable = false)
    public ResultPOJO getResultByResultId() {
        return _resultByResultId;
    }

    public void setResultByResultId(ResultPOJO resultByResultId) {
        _resultByResultId = resultByResultId;
    }

    @ManyToOne
    @JoinColumn(name = "team1ID", referencedColumnName = "teamID", nullable = false, insertable = false, updatable = false)
    public TeamPOJO getTeamByTeam1Id() {
        return _teamByTeam1Id;
    }

    public void setTeamByTeam1Id(TeamPOJO teamByTeam1Id) {
        _teamByTeam1Id = teamByTeam1Id;
    }

    @ManyToOne
    @JoinColumn(name = "team2ID", referencedColumnName = "teamID", nullable = false, insertable = false, updatable = false)
    public TeamPOJO getTeamByTeam2Id() {
        return _teamByTeam2Id;
    }

    public void setTeamByTeam2Id(TeamPOJO teamByTeam2Id) {
        _teamByTeam2Id = teamByTeam2Id;
    }

    @OneToMany(mappedBy = "encounterByEncId")
    public Collection<LineUpPersonPOJO> getLineUpPeopleByEncounterId() {
        return _lineUpPeopleByEncounterId;
    }

    public void setLineUpPeopleByEncounterId(Collection<LineUpPersonPOJO> lineUpPeopleByEncounterId) {
        _lineUpPeopleByEncounterId = lineUpPeopleByEncounterId;
    }
}
