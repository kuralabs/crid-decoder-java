package io.kuralabs.crid.decoder;

import java.util.Date;

/**
 * Created by KuraLabs S.R.L on 2/19/17.
 */

public class Person {

    private String id;
    private String familyName1;
    private String familyName2;
    private String name;
    private String gender;
    private Date birthDate;
    private Date expirationDate;

    public Person(
        String id,
        String familyName1,
        String familyName2,
        String name,
        String gender,
        Date birthDate,
        Date expirationDate
    ) {
        this.id = id;
        this.familyName1 = familyName1;
        this.familyName2 = familyName2;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.expirationDate = expirationDate;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFamilyName1() {
        return familyName1;
    }

    public void setFamilyName1(String familyName1) {
        this.familyName1 = familyName1;
    }

    public String getFamilyName2() {
        return familyName2;
    }

    public void setFamilyName2(String familyName2) {
        this.familyName2 = familyName2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
