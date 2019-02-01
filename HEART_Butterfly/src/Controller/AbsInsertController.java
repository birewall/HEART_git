package Controller;

public abstract class AbsInsertController extends AbsMetaController {
    public void passing_address(String country, String location, String locationDetail, String section, String alias) {
        /* For Overriding */
    }

    public void passing_person(String prev_button, String name) {
        /* For Overriding */
    }

    public void passing_collection_info(String date, String country, String location, String locationDetail,
                                        String section, String sectionDetail, String loc_alias, String butter_name,
                                        String butter_family, String butter_sci, String method, String person_name) {
        /* For Overriding */
    }

    public void passing_specimen_info(String date, String country, String loc_alias, String butter_name, String butter_family, String person_name) {
        /* For Overriding */
    }

    public void passing_section_info(String nowSection, String maxSection) {
        /* For Overriding */
    }
}