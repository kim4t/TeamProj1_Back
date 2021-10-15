package bfs.TeamProj.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OnBoardDataHolder {
    private String email;
    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;
    private String cellphone;
    private String alternatePhone;
    private String dob;
    private String ssn;
    private String avatar;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String stateAbbr;
    private String stateName;
    private String zipCode;
    private String car;
    private String visaType;
    private LocalDate visaStartDate;
    private LocalDate visaEndDate;
    private String visaDocumentPath;
    private String driverLicense;
    private LocalDate driverLicenseExpirationDate;
    private LocalDate driverLicenseDocumentPath;
    private String firstNameRef;
    private String lastNameRef;
    private String middleNameRef;
    private String cellphoneRef;
    private String emailRef;
    private String relationshipRef;
    private String addressLine1Ref;
    private String addressLine2Ref;
    private String cityRef;
    private String stateAbbrRef;
    private String stateNameRef;
    private String zipCodeRef;
    private List<EmergencyContact> emergencyContact;
}

@Data
class EmergencyContact {
    private String firstName;
    private String lastName;
    private String middleName;
    private String cellphone;
    private String email;
    private String relationship;
}
