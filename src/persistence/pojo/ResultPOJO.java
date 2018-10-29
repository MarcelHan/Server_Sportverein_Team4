package persistence.pojo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Result", schema = "dbo", catalog = "Vereinsdatenbank")
public class ResultPOJO {
    private int _resultId;
    private int _pointsTeam1;
    private int _pointsTeam2;
    private Collection<EncounterPOJO> _encountersByResultId;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "resultID")
    public int getResultId() {
        return _resultId;
    }

    public void setResultId(int resultId) {
        _resultId = resultId;
    }

    @Basic
    @Column(name = "pointsTeam1")
    public int getPointsTeam1() {
        return _pointsTeam1;
    }

    public void setPointsTeam1(int pointsTeam1) {
        _pointsTeam1 = pointsTeam1;
    }

    @Basic
    @Column(name = "pointsTeam2")
    public int getPointsTeam2() {
        return _pointsTeam2;
    }

    public void setPointsTeam2(int pointsTeam2) {
        _pointsTeam2 = pointsTeam2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultPOJO that = (ResultPOJO) o;
        return _resultId == that._resultId &&
                _pointsTeam1 == that._pointsTeam1 &&
                _pointsTeam2 == that._pointsTeam2;
    }

    @Override
    public int hashCode() {

        return Objects.hash(_resultId, _pointsTeam1, _pointsTeam2);
    }

    @OneToMany(mappedBy = "resultByResultId")
    public Collection<EncounterPOJO> getEncountersByResultId() {
        return _encountersByResultId;
    }

    public void setEncountersByResultId(Collection<EncounterPOJO> encountersByResultId) {
        _encountersByResultId = encountersByResultId;
    }
}
