package Model;

import java.sql.Connection;

public class MDBSpecimenize extends MDatabase {
    int idSpecimenize;
    int idSpecimen;
    int idObservation;
    int idPerson;
    String date;            //varchar(11)
    String anticepticName;  //varchar(45)
    String embalmingDate;   //varchar(11)

    public MDBSpecimenize(Connection connection) {
        this.connection = connection;
        this.table_name = "Specimenize";
    }

    public int getIdSpecimenize() {
        return idSpecimenize;
    }

    public void setIdSpecimenize(int idSpecimenize) {
        this.idSpecimenize = idSpecimenize;
    }

    public int getIdSpecimen() {
        return idSpecimen;
    }

    public void setIdSpecimen(int idSpecimen) {
        this.idSpecimen = idSpecimen;
    }

    public int getIdObservation() {
        return idObservation;
    }

    public void setIdObservation(int idObservation) {
        this.idObservation = idObservation;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAnticepticName() {
        return anticepticName;
    }

    public void setAnticepticName(String anticepticName) {
        this.anticepticName = anticepticName;
    }

    public String getEmbalmingDate() {
        return embalmingDate;
    }

    public void setEmbalmingDate(String embalmingDate) {
        this.embalmingDate = embalmingDate;
    }

    public void printContents() {
        logger.info("[" + this.table_name + "]");
        logger.info("[idSpecimenize] " + idSpecimenize);
        logger.info("[idSpecimen] " + idSpecimen);
        logger.info("[idObservation] " + idObservation);
        logger.info("[idPerson] " + idPerson);
        logger.info("[date] " + date);
        logger.info("[anticepticName] " + anticepticName);
        logger.info("[embalmingDate] " + embalmingDate);
    }
}
