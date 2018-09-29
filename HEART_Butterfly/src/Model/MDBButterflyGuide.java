package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MDBButterflyGuide extends MDatabase {
    int idButterflyGuide;
    int idImage;
    String name;                 //varchar(45) not null
    String family;               //varchar(45)
    String scientific_name;      //varchar(45)

    public MDBButterflyGuide(Connection connection) {
        this.table_name = "ButterflyGuide";
        this.connection = connection;
        initialize();
    }

    @Override
    public void initialize() {
        this.idImage = 0;
        this.name = null;
        this.family = null;
        this.scientific_name = null;
    }

    public String getIdButterflyGuide() {
        if(idButterflyGuide == 0)
            return null;
        else
            return String.valueOf(idButterflyGuide);
    }

    public int getIdButterflyGuide_integer() {
        return idButterflyGuide;
    }

    public void setIdButterflyGuide(int idButterflyGuide) {
        this.idButterflyGuide = idButterflyGuide;
    }

    public String getIdImage() {
        if(idImage == 0)
            return null;
        else
            return String.valueOf(idImage);
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getName() {
        if(name.length() == 0) return null;
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        if(family == null || family.length() == 0) return null;
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getScientific_name() {
        if(scientific_name == null || scientific_name.length() == 0) return null;
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

    @Override
    public boolean insert() {
        String query = "insert into ButterflyGuide (idImage, name, family, scientific_name) values ("
                + db_string_formatting(getIdImage(), "int") + ","
                + db_string_formatting(getName(), "string") + ","
                + db_string_formatting(getFamily(), "string") + ","
                + db_string_formatting(getScientific_name(), "string")
                + ");";
        return modifyingQuery(query);
    }

    @Override
    public boolean delete(int idButterflyGuide) {
        String query = "delete from ButterflyGuide where idButterflyGuide = " + idButterflyGuide;
        return modifyingQuery(query);
    }

    public boolean update(int idButterflyGuide) {
        String query = "update ButterflyGuide set ";
        int initial_length = query.length();
        query += db_update_formatting(db_string_formatting(getIdImage(), "int"), "idImage");
        query += db_update_formatting(db_string_formatting(getName(), "string"), "name");
        query += db_update_formatting(db_string_formatting(getFamily(), "string"), "family");
        query += db_update_formatting(db_string_formatting(getScientific_name(), "string"), "scientific_name");
        if(query.length() == initial_length) return false;
        query = query.substring(0, query.length()-1);   // Delete last comma
        query += " where idButterflyGuide = " + idButterflyGuide;
        return modifyingQuery(query);
    }

    public int getIdButterflyGuideFromDB() {
        String query = "select idButterflyGuide from ButterflyGuide where "
                + db_where_formatting(db_string_formatting(getIdImage(), "int"), "idImage") + " and "
                + db_where_formatting(db_string_formatting(getName(), "String"), "name") + " and "
                + db_where_formatting(db_string_formatting(getFamily(), "String"), "family") + " and "
                + db_where_formatting(db_string_formatting(getScientific_name(), "String"), "scientific_name");
        ResultSet rs = selectQuery(query);
        if(rs == null) return 0;
        try {
            rs.last();
            if(rs.getRow() > 0) {
                rs.first();
                return Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException e) {
            return 0;
        }
        return 0;
    }

    @Override
    public int getIDFromDB() {
        return getIdButterflyGuideFromDB();
    }
}