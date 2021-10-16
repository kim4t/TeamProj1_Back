package bfs.TeamProj.domain;

import lombok.Data;


import java.time.LocalDate;
import java.util.List;

@Data
public class PersonalInformation {
    private NameSection nameSection;
    private AddressSection addressSection;
    private ContactSection contactSection;
    private EmployeeSection employeeSection;
    private List<EmergencyContact> emergencyContactList;
    private List<PersonalDocument> personalDocumentList;


    @Data
    public static class NameSection {
        private int personId;
        private String firstName;
        private String lastName;
        private String middleName;
        private String avatar;
        private String dob;
        private String gender;
        private String ssn;
    }

    @Data
    public static class AddressSection {
        private int addressId;
        private String addressLine1;
        private String addressLine2;
        private String city;
        private String stateAbbr;
        private String stateName;
        private String zipCode;
    }

    @Data
    public static class ContactSection {
        private String email;
        private String cellphone;
        private String alternatePhone;
    }

    @Data
    public static class EmployeeSection {
        private int employeeId;
        private String visaType;
        private LocalDate visaStartDate;
        private LocalDate visaEndDate;
        private LocalDate startDate;
        private LocalDate endDate;
        private String title;
    }

    @Data
    public static class EmergencyContact {
        private int PersonId;
        private String firstName;
        private String lastName;
        private String cellphone;
        private String email;
        private String relationship;
    }

    @Data
    public static class PersonalDocument {
        private int docId;
        private String path;
        private String title;
        private LocalDate createDate;
    }


}
