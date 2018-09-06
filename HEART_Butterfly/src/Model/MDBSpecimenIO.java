package Model;

import java.sql.Connection;

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
}
