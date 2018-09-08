package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MDBButterflyGuide extends MDatabase {
    int idButterflyGuide;
    int idImage;
    String name;                 //varchar(45)
    String family;               //varchar(45)
    String scientific_name;      //varchar(45)

    public MDBButterflyGuide(Connection connection) {
        this.table_name = "ButterflyGuide";
        this.connection = connection;
        this.idImage = 0;
        this.name = null;
        this.family = null;
        this.scientific_name = null;
    }

    public int getIdButterflyGuide() { return idButterflyGuide; }

    public void setIdButterflyGuide(int idButterflyGuide) {
        this.idButterflyGuide = idButterflyGuide;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getScientific_name() {
        return scientific_name;
    }

    public void setScientific_name(String scientific_name) {
        this.scientific_name = scientific_name;
    }

    public void printContents() {
        logger.info("[" + this.table_name + "]");
        logger.info("[idButterflyGuide] " + idButterflyGuide);
        logger.info("[idImage] " + idImage);
        logger.info("[name] " + name);
        logger.info("[family] " + family);
        logger.info("[scientific_name] " + scientific_name);
    }

    public boolean insert() {
        String query = "insert into ButterflyGuide (idImage, name, family, scientific_name) values ("
                + getIdImage() + ","
                + "'" + getName() + "',"
                + "'" + getFamily() + "',"
                + "'" + getScientific_name() + "'"
                + ");";
        return modifyingQuery(query);
    }

    public boolean delete(int idButterflyGuide) {
        String query = "delete from ButterflyGuide where idButterflyGuide = " + idButterflyGuide;
        return modifyingQuery(query);
    }

    public boolean update(int idButterflyGuide) {
        String query = "update ButterflyGuide set "
                + "idImage=" + getIdImage()
                + ",name='" + getName() + "'"
                + ",family='" + getFamily() + "'"
                + ",scientific_name='" + getScientific_name() + "'"
                + " where idButterflyGuide = " + idButterflyGuide;
        return modifyingQuery(query);
    }
}
