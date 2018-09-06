package Model;

import java.sql.Connection;

public class MDBPerson extends MDatabase {
    int idPerson;
    String name;    //varchar(45)
    String sort;    //varchar(5)

    public MDBPerson(Connection connection) {
        this.connection = connection;
        this.table_name = "Person";
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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void printContents() {
        logger.info("[" + this.table_name + "]");
        logger.info("[idPerson] " + idPerson);
        logger.info("[name] " + name);
        logger.info("[sort] " + sort);
    }
}
