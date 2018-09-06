package Model;

import java.sql.Connection;

public class MDBButterflyGuide extends MDatabase {
    int idButterflyGuid;
    int idImage;
    String name;        //varchar(45)
    String family;      //varchar(45)

    public MDBButterflyGuide(Connection connection) {
        this.connection = connection;
    }

    public int getIdButterflyGuid() {
        return idButterflyGuid;
    }

    public void setIdButterflyGuid(int idButterflyGuid) {
        this.idButterflyGuid = idButterflyGuid;
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
}
