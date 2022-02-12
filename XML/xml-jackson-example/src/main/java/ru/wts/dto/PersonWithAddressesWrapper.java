package ru.wts.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import ru.wts.Address;

import java.util.ArrayList;
import java.util.List;

public class PersonWithAddressesWrapper {
    private String firstName;
    private String lastName;
    //@JacksonXmlElementWrapper(localName = "phoneNumbers")
    private List<String> phoneNumbers = new ArrayList<>();
    //@JacksonXmlElementWrapper(localName = "addresses")
    private List<Address> addresses; // will be empty list

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
