package Model;

import java.sql.Connection;
import java.sql.SQLException;

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

    public void insert() {
        try {
            String query = "insert into Person (name, sort) values ("
                    + "'" + getName() + "',"
                    + "'" + getSort() + "'"
                    + ");";
            modifyingQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int idPerson) {
        try {
            String query = "delete from Person where idPerson = " + idPerson;
            modifyingQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int idPerson) {
        try {
            String query = "update Person set "
                    + "name='" + getName() + "'"
                    + ",sort='" + getSort() + "'"
                    + " where idPerson = " + idPerson;
            modifyingQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
