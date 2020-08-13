package com.trivago.magazine.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//@JacksonXmlRootElement(localName = "ProjectObject")
@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true, allowSetters = true)
public class ContactForm {

    @JsonProperty("message")
    String message;

    @JsonProperty("fullname")
    String fullname;

    @JsonProperty("email")
    String email;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
