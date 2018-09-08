package Model;

import java.sql.Connection;
import java.sql.SQLException;

public class MDBSpecimenIO extends MDatabase {
    int idSpecimenIO;
    int idSpecimen;
    int idGiver;
    int idTaker;
    String date;    //varchar(11)
    int cost;

    public MDBSpecimenIO(Connection connection) {
        this.connection = connection;
        this.table_name = "SpecimenIO";
    }

    public int getIdSpecimenIO() {
        return idSpecimenIO;
    }

    public void setIdSpecimenIO(int idSpecimenIO) {
        this.idSpecimenIO = idSpecimenIO;
    }

    public int getIdSpecimen() {
        return idSpecimen;
    }

    public void setIdSpecimen(int idSpecimen) {
        this.idSpecimen = idSpecimen;
    }

    public int getIdGiver() {
        return idGiver;
    }

    public void setIdGiver(int idGiver) {
        this.idGiver = idGiver;
    }

    public int getIdTaker() {
        return idTaker;
    }

    public void setIdTaker(int idTaker) {
        this.idTaker = idTaker;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void printContents() {
        logger.info("[" + this.table_name + "]");
        logger.info("[idSpecimenIO] " + idSpecimenIO);
        logger.info("[idSpecimen] " + idSpecimen);
        logger.info("[idGiver] " + idGiver);
        logger.info("[idTaker] " + idTaker);
        logger.info("[date] " + date);
        logger.info("[cost] " + cost);
    }

    public boolean insert() {
        String query = "insert into SpecimenIO (idSpecimen, idGiver, idTaker, date, cost) values ("
                + getIdSpecimen() + ","
                + getIdGiver() + ","
                + getIdTaker() + ","
                + "'" + getDate() + "',"
                + getCost()
                + ");";
        return modifyingQuery(query);
    }

    public boolean delete(int idSpecimenIO) {
        String query = "delete from SpecimenIO where idSpecimenIO = " + idSpecimenIO;
        return modifyingQuery(query);
    }

    public boolean update(int idSpecimenIO) {
        String query = "update SpecimenIO set "
                + "idSpecimen=" + getIdSpecimen()
                + ",idGiver=" + getIdGiver()
                + ",idTaker=" + getIdTaker()
                + ",date='" + getDate() + "'"
                + ",cost='" + getCost()
                + " where idSpecimenIO = " + idSpecimenIO;
        return modifyingQuery(query);
    }
}