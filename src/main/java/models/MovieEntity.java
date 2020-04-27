package models;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "movies", schema = "movierentdatabase")
public class MovieEntity {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Id;

    @Basic
    @Column(name ="Title")
    private String Title;

    @Basic
    @Column(name ="Date")
    private Date Date;

    @Basic
    @Column(name ="Number")
    private String Number;

    @Basic
    @Column(name ="Type")
    private String Type;

    @Basic
    @Column(name ="State")
    private String State;

    public MovieEntity() {
    }

    public MovieEntity(String title, Date date, String number, String type, String state) {
        Title = title;
        Date = date;
        Number = number;
        Type = type;
        State = state;
    }

    public int getId() { return Id; }

    public void setId(int id) { Id = id; }

    public String getTitle() { return Title; }

    public void setTitle(String title) { Title = title; }

    public Date getDate() { return Date; }

    public void setDate(Date date) { Date = date; }

    public String getNumber() { return Number; }

    public void setNumber(String number) { Number = number; }

    public String getType() { return Type; }

    public void setType(String type) { Type = type; }

    public String getState() { return State; }

    public void setState(String state) { State = state; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieEntity that = (MovieEntity) o;
        return Id == that.Id &&
                Objects.equals(Title, that.Title) &&
                Objects.equals(Date, that.Date) &&
                Objects.equals(Number, that.Number) &&
                Objects.equals(Type, that.Type) &&
                Objects.equals(State, that.State);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Title, Date, Number, Type, State);
    }

    @Override
    public String toString() {
        return "MoviesEntity{" +
                "Id=" + Id +
                ", Title='" + Title + '\'' +
                ", Date=" + Date +
                ", Number='" + Number + '\'' +
                ", Type='" + Type + '\'' +
                ", State='" + State + '\'' +
                '}';
    }
}
