package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MDBButterflyGuide extends MDatabase {
    int idButterflyGuide;
    int idImage;
    String name;        //varchar(45)
    String family;      //varchar(45)

    public MDBButterflyGuide(Connection connection) {
        this.table_name = "ButterflyGuide";
        this.connection = connection;
        this.idImage = 0;
        this.name = null;
        this.family = null;
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

    public void printContents() {
        logger.info("[" + this.table_name + "]");
        logger.info("[idButterflyGuide] " + idButterflyGuide);
        logger.info("[idImage] " + idImage);
        logger.info("[name] " + name);
        logger.info("[family] " + family);
    }

    public void insert() {
        try {
            String query = "insert into ButterflyGuide (idImage, name, family) values ("
                    + getIdImage() + ","
                    + "'" + getName() + "',"
                    + "'" + getFamily() + "'"
                    + ");";
            modifyingQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int idButterflyGuide) {
        try {
            String query = "delete from ButterflyGuide where idButterflyGuide = " + idButterflyGuide;
            modifyingQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int idButterflyGuide) {
        try {
            String query = "update ButterflyGuide set "
                    + "idImage=" + getIdImage()
                    + ",name='" + getName() + "'"
                    + ",family='" + getFamily() + "'"
                    + " where idButterflyGuide = " + idButterflyGuide;
            modifyingQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
