package persistence.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CompetitionTeam", schema = "dbo", catalog = "Vereinsdatenbank")
@IdClass(CompetitionTeamPOJOPK.class)
public class CompetitionTeamPOJO {
    private int _compId;
    private int _teamId;
    private CompetitionPOJO _competitionByCompId;
    private TeamPOJO _teamByTeamId;

    @Id
    @Column(name = "compID")
    public int getCompId() {
        return _compId;
    }

    public void setCompId(int compId) {
        _compId = compId;
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
        CompetitionTeamPOJO that = (CompetitionTeamPOJO) o;
        return _compId == that._compId &&
                _teamId == that._teamId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(_compId, _teamId);
    }

    @ManyToOne
    @JoinColumn(name = "compID", referencedColumnName = "compID", nullable = false, insertable = false, updatable = false)
    public CompetitionPOJO getCompetitionByCompId() {
        return _competitionByCompId;
    }

    public void setCompetitionByCompId(CompetitionPOJO competitionByCompId) {
        _competitionByCompId = competitionByCompId;
    }

    @ManyToOne
    @JoinColumn(name = "teamID", referencedColumnName = "teamID", nullable = false, insertable = false, updatable = false)
    public TeamPOJO getTeamByTeamId() {
        return _teamByTeamId;
    }

    public void setTeamByTeamId(TeamPOJO teamByTeamId) {
        _teamByTeamId = teamByTeamId;
    }
}
