package persistence.pojo;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TeamCompResult", schema = "dbo", catalog = "Vereinsdatenbank")
public class TeamCompResultPOJO {
    private int _teamCompResultId;
    private int _points;
    private int _compId;
    private int _teamId;
    private CompetitionPOJO _competitionByCompId;
    private TeamPOJO _teamByTeamId;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "teamCompResultID")
    public int getTeamCompResultId() {
        return _teamCompResultId;
    }

    public void setTeamCompResultId(int teamCompResultId) {
        _teamCompResultId = teamCompResultId;
    }

    @Basic
    @Column(name = "points")
    public int getPoints() {
        return _points;
    }

    public void setPoints(int points) {
        _points = points;
    }

    @Basic
    @Column(name = "compID")
    public int getCompId() {
        return _compId;
    }

    public void setCompId(int compId) {
        _compId = compId;
    }

    @Basic
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
        TeamCompResultPOJO that = (TeamCompResultPOJO) o;
        return _teamCompResultId == that._teamCompResultId &&
                _points == that._points &&
                _compId == that._compId &&
                _teamId == that._teamId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(_teamCompResultId, _points, _compId, _teamId);
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
