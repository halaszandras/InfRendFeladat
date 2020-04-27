package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "clients", schema = "movierentdatabase")
public class ClientEntity {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Id;

    @Basic
    @Column(name = "Name")
    private String Name;

    @Basic
    @Column(name = "Mobile")
    private String Mobile;

    @Basic
    @Column(name = "IdCard")
    private String IdCard;

    @Basic
    @Column(name = "Address")
    private String Address;

    @Basic
    @Column(name = "Active")
    private boolean Active = true;

    public ClientEntity() {
    }

    public ClientEntity(String name, String mobile, String idCard, String address) {
        Name = name;
        Mobile = mobile;
        IdCard = idCard;
        Address = address;
    }

    public int getId() { return Id; }

    public void setId(int id) { Id = id; }

    public String getName() { return Name; }

    public void setName(String name) { Name = name; }

    public String getMobile() { return Mobile; }

    public void setMobile(String mobile) { Mobile = mobile; }

    public String getIdCard() { return IdCard; }

    public void setIdCard(String idCard) { IdCard = idCard; }

    public String getAddress() { return Address; }

    public void setAddress(String address) { Address = address; }

    public boolean isActive() { return Active; }

    public void setActive(boolean active) { Active = active; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return Id == that.Id &&
                Active == that.Active &&
                Objects.equals(Name, that.Name) &&
                Objects.equals(Mobile, that.Mobile) &&
                Objects.equals(IdCard, that.IdCard) &&
                Objects.equals(Address, that.Address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Name, Mobile, IdCard, Address, Active);
    }

    @Override
    public String toString() {
        return "ClientsEntity{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", IdCard='" + IdCard + '\'' +
                ", Address='" + Address + '\'' +
                ", Active=" + Active +
                '}';
    }
}
