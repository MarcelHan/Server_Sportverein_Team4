package persistence.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CompetitionTeamPOJOPK implements Serializable {
    private int _compId;
    private int _teamId;

    @Column(name = "compID")
    @Id
    public int getCompId() {
        return _compId;
    }

    public void setCompId(int compId) {
        _compId = compId;
    }

    @Column(name = "teamID")
    @Id
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
        CompetitionTeamPOJOPK that = (CompetitionTeamPOJOPK) o;
        return _compId == that._compId &&
                _teamId == that._teamId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(_compId, _teamId);
    }
}
