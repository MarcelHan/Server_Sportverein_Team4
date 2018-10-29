package persistence.pojo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Team", schema = "dbo", catalog = "Vereinsdatenbank")
public class TeamPOJO {
    private int _teamId;
    private int _teamName;
    private int _sportId;
    private int _leagueId;
    private Collection<CompetitionTeamPOJO> _competitionTeamsByTeamId;
    private Collection<EncounterPOJO> _encountersByTeamId;
    private Collection<EncounterPOJO> _encountersByTeamId_0;
    private SportPOJO _sportBySportId;
    private LeaguePOJO _leagueByLeagueId;
    private Collection<TeamCompResultPOJO> _teamCompResultsByTeamId;
    private InternalTeamPOJO _internalTeamByTeamId;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "teamID")
    public int getTeamId() {
        return _teamId;
    }

    public void setTeamId(int teamId) {
        _teamId = teamId;
    }

    @Basic
    @Column(name = "teamName")
    public int getTeamName() {
        return _teamName;
    }

    public void setTeamName(int teamName) {
        _teamName = teamName;
    }

    @Basic
    @Column(name = "sportID")
    public int getSportId() {
        return _sportId;
    }

    public void setSportId(int sportId) {
        _sportId = sportId;
    }

    @Basic
    @Column(name = "leagueID")
    public int getLeagueId() {
        return _leagueId;
    }

    public void setLeagueId(int leagueId) {
        _leagueId = leagueId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamPOJO teamPOJO = (TeamPOJO) o;
        return _teamId == teamPOJO._teamId &&
                _teamName == teamPOJO._teamName &&
                _sportId == teamPOJO._sportId &&
                _leagueId == teamPOJO._leagueId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(_teamId, _teamName, _sportId, _leagueId);
    }

    @OneToMany(mappedBy = "teamByTeamId")
    public Collection<CompetitionTeamPOJO> getCompetitionTeamsByTeamId() {
        return _competitionTeamsByTeamId;
    }

    public void setCompetitionTeamsByTeamId(Collection<CompetitionTeamPOJO> competitionTeamsByTeamId) {
        _competitionTeamsByTeamId = competitionTeamsByTeamId;
    }

    @OneToMany(mappedBy = "teamByTeam1Id")
    public Collection<EncounterPOJO> getEncountersByTeamId() {
        return _encountersByTeamId;
    }

    public void setEncountersByTeamId(Collection<EncounterPOJO> encountersByTeamId) {
        _encountersByTeamId = encountersByTeamId;
    }

    @OneToMany(mappedBy = "teamByTeam2Id")
    public Collection<EncounterPOJO> getEncountersByTeamId_0() {
        return _encountersByTeamId_0;
    }

    public void setEncountersByTeamId_0(Collection<EncounterPOJO> encountersByTeamId_0) {
        _encountersByTeamId_0 = encountersByTeamId_0;
    }

    @ManyToOne
    @JoinColumn(name = "sportID", referencedColumnName = "sportID", nullable = false, insertable = false, updatable = false)
    public SportPOJO getSportBySportId() {
        return _sportBySportId;
    }

    public void setSportBySportId(SportPOJO sportBySportId) {
        _sportBySportId = sportBySportId;
    }

    @ManyToOne
    @JoinColumn(name = "leagueID", referencedColumnName = "leagueID", nullable = false, insertable = false, updatable = false)
    public LeaguePOJO getLeagueByLeagueId() {
        return _leagueByLeagueId;
    }

    public void setLeagueByLeagueId(LeaguePOJO leagueByLeagueId) {
        _leagueByLeagueId = leagueByLeagueId;
    }

    @OneToMany(mappedBy = "teamByTeamId")
    public Collection<TeamCompResultPOJO> getTeamCompResultsByTeamId() {
        return _teamCompResultsByTeamId;
    }

    public void setTeamCompResultsByTeamId(Collection<TeamCompResultPOJO> teamCompResultsByTeamId) {
        _teamCompResultsByTeamId = teamCompResultsByTeamId;
    }

    @OneToOne(mappedBy = "teamByTeamId")
    public InternalTeamPOJO getInternalTeamByTeamId() {
        return _internalTeamByTeamId;
    }

    public void setInternalTeamByTeamId(InternalTeamPOJO internalTeamByTeamId) {
        _internalTeamByTeamId = internalTeamByTeamId;
    }
}
