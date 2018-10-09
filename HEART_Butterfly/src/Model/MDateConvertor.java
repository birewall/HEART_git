package Model;

public class MDateConvertor extends AbsMetaModel {
    public MDateConvertor() {

    }

    /*
    *   2000. 1. 10 to 2000-01-10
    * */
    public static String convert2DBFormat(String date) {
        /* Tokenize */
        String[] token = date.split(". ");

        /* Hour */
        String result = token[0];

        /* Minute */
        if(token[1].length() == 1) result += "0";
        result += token[1];

        /* Second */
        if(token[2].length() == 1) result += "0";
        result += token[2];

        return result;
    }
}
