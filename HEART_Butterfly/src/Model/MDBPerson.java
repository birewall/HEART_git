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

    public boolean insert() {
        String query = "insert into Person (name, sort) values ("
                + "'" + getName() + "',"
                + "'" + getSort() + "'"
                + ");";
        return modifyingQuery(query);
    }

    public boolean delete(int idPerson) {
        String query = "delete from Person where idPerson = " + idPerson;
        return modifyingQuery(query);
    }

    public boolean update(int idPerson) {
        String query = "update Person set "
                + "name='" + getName() + "'"
                + ",sort='" + getSort() + "'"
                + " where idPerson = " + idPerson;
        return modifyingQuery(query);
    }

    /* Modified Function */
    public boolean delete_by_type(String type) {
        String query = "delete from Person where sort = '" + type + "'";
        return modifyingQuery(query);
    }
}
