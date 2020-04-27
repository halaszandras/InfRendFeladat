package models;

import java.util.Date;
import java.util.Objects;

public class RentingByClient {

    private int Id;
    private int ClientId;
    private int MovieId;
    private String MovieTitle;
    private Date MovieDate;
    private String MovieNumber;
    private String MovieState;
    private String MovieType;
    private Date RentStart;
    private Date RentEnd;

    public RentingByClient(int id, int clientID, int movieID, String movieTitle, Date movieDate, String movieNumber, String movieState, String movieType, Date rentStart, Date rentEnd) {
        this.Id = id;
        this.ClientId = clientID;
        this.MovieId = movieID;
        this.MovieTitle = movieTitle;
        this.MovieDate = movieDate;
        this.MovieNumber = movieNumber;
        this.MovieState = movieState;
        this.MovieType = movieType;
        this.RentStart = rentStart;
        this.RentEnd = rentEnd;
    }

    public int getId() { return Id; }

    public void setId(int id) { Id = id; }

    public int getClientId() { return ClientId; }

    public void setClientId(int clientId) { ClientId = clientId; }

    public int getMovieId() { return MovieId; }

    public void setMovieId(int movieId) { MovieId = movieId; }

    public String getMovieTitle() { return MovieTitle; }

    public void setMovieTitle(String movieTitle) { MovieTitle = movieTitle; }

    public Date getMovieDate() { return MovieDate; }

    public void setMovieDate(Date movieDate) { MovieDate = movieDate; }

    public String getMovieNumber() { return MovieNumber; }

    public void setMovieNumber(String movieNumber) { MovieNumber = movieNumber; }

    public String getMovieState() { return MovieState; }

    public void setMovieState(String movieState) { MovieState = movieState; }

    public String getMovieType() { return MovieType; }

    public void setMovieType(String movieType) { MovieType = movieType; }

    public Date getRentStart() { return RentStart; }

    public void setRentStart(Date rentStart) { RentStart = rentStart; }

    public Date getRentEnd() { return RentEnd; }

    public void setRentEnd(Date rentEnd) { RentEnd = rentEnd; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentingByClient that = (RentingByClient) o;
        return Id == that.Id &&
                ClientId == that.ClientId &&
                MovieId == that.MovieId &&
                Objects.equals(MovieTitle, that.MovieTitle) &&
                Objects.equals(MovieDate, that.MovieDate) &&
                Objects.equals(MovieNumber, that.MovieNumber) &&
                Objects.equals(MovieState, that.MovieState) &&
                Objects.equals(MovieType, that.MovieType) &&
                Objects.equals(RentStart, that.RentStart) &&
                Objects.equals(RentEnd, that.RentEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, ClientId, MovieId, MovieTitle, MovieDate, MovieNumber, MovieState, MovieType, RentStart, RentEnd);
    }

    @Override
    public String toString() {
        return "RentingByClient{" +
                "Id=" + Id +
                ", ClientId=" + ClientId +
                ", MovieId=" + MovieId +
                ", MovieTitle='" + MovieTitle + '\'' +
                ", MovieDate=" + MovieDate +
                ", MovieNumber='" + MovieNumber + '\'' +
                ", MovieState='" + MovieState + '\'' +
                ", MovieType='" + MovieType + '\'' +
                ", RentStart=" + RentStart +
                ", RentEnd=" + RentEnd +
                '}';
    }
}
