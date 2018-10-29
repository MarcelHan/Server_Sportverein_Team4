package persistence.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PersonTeamPOJOPK implements Serializable {
    private int _personId;
    private int _teamId;

    @Column(name = "personID")
    @Id
    public int getPersonId() {
        return _personId;
    }

    public void setPersonId(int personId) {
        _personId = personId;
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
        PersonTeamPOJOPK that = (PersonTeamPOJOPK) o;
        return _personId == that._personId &&
                _teamId == that._teamId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(_personId, _teamId);
    }
}
