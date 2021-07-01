package com.adloid.webApp.model;

import java.io.Serializable;

public class User implements Serializable {
    
    private String name;
    private String age;
    private String emailId;
    private String occupation;

    public User(String name, String age, String emailId, String occupation){
        this.name=name;
        this.age = age;
        this.emailId = emailId;
        this.occupation = occupation;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }
    
    public String getOccupation() {
        return occupation;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString(){
        return "User{" + "name =" +name + '\''  + ", age =" + age + ", emailID =" + emailId + ", occupation =" + occupation + "}";
    }

}
