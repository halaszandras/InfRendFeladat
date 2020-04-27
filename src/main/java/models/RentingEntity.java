package models;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "renting", schema = "movierentdatabase")
public class RentingEntity {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Id;

    @Basic
    @Column(name ="ClientId")
    private int ClientId;

    @Basic
    @Column(name ="MoviesId")
    private int MovieId;

    @Basic
    @Column(name = "Start")
    private Date Start;

    @Basic
    @Column(name = "End")
    private Date End;

    public RentingEntity() {
    }

    public RentingEntity(int clientId, int movieID, Date start, Date end) {
        ClientId = clientId;
        MovieId = movieID;
        Start = start;
        End = end;
    }

    public int getId() { return Id; }

    public void setId(int id) { Id = id; }

    public int getClientId() { return ClientId; }

    public void setClientId(int clientId) { ClientId = clientId; }

    public int getMovieId() { return MovieId; }

    public void setMovieId(int movieId) { MovieId = movieId; }

    public Date getStart() { return Start; }

    public void setStart(Date start) { Start = start; }

    public Date getEnd() { return End; }

    public void setEnd(Date end) { End = end; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentingEntity that = (RentingEntity) o;
        return Id == that.Id &&
                ClientId == that.ClientId &&
                MovieId == that.MovieId &&
                Objects.equals(Start, that.Start) &&
                Objects.equals(End, that.End);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, ClientId, MovieId, Start, End);
    }

    @Override
    public String toString() {
        return "RentingEntity{" +
                "Id=" + Id +
                ", ClientId=" + ClientId +
                ", MovieId=" + MovieId +
                ", Start=" + Start +
                ", End=" + End +
                '}';
    }
}
