package Model;

import java.sql.Connection;

public class MDBPerson extends MDatabase {
    int idPerson;
    String name;    //varchar(45)

    public MDBPerson(Connection connection) {
        this.connection = connection;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
