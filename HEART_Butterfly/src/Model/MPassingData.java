package Model;

public class MPassingData extends AbsMetaModel {
    String[] data;

    public MPassingData() {
        data = null;
    }

    public MPassingData(int size) {
        data = new String[size];
    }

    public void setData(String data, int index) {
        this.data[index] = data;
    }

    public String getData(int index) {
        return this.data[index];
    }

    public String[] getData() {
        return this.data;
    }
}
