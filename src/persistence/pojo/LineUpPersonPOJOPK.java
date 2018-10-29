package persistence.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class LineUpPersonPOJOPK implements Serializable {
    private int _personId;
    private int _encId;

    @Column(name = "personID")
    @Id
    public int getPersonId() {
        return _personId;
    }

    public void setPersonId(int personId) {
        _personId = personId;
    }

    @Column(name = "encID")
    @Id
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
        LineUpPersonPOJOPK that = (LineUpPersonPOJOPK) o;
        return _personId == that._personId &&
                _encId == that._encId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(_personId, _encId);
    }
}
