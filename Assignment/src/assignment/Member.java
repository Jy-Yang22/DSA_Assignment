/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author User10
 */
public class Member implements Comparable<Member> {
    private String id;
    private String name;
    private String email;
    private int age;
    private char gender;
    private String noTel;
    private String noIC;
    
    public Member(String id, String name, String email, int age, char gender, String noTel, String noIC){
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.noTel = noTel;
        this.noIC = noIC;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public String getNoTel() {
        return noTel;
    }

    public String getNoIC() {
        return noIC;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setNoTel(String noTel) {
        this.noTel = noTel;
    }

    public void setNoIC(String noIC) {
        this.noIC = noIC;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-20s%-30s%-15d%-15s%-20s%-20s", id, name, email, age, gender, noTel, noIC);
    }
    
    
    
    @Override
    public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Member other = (Member) obj;
    if (this.name != other.name) {
      return false;
    }
    return true;
  } 
    
    

    @Override
    public int compareTo(Member mem) {
        return(int)this.name.toLowerCase().compareTo(mem.name.toLowerCase());
    }
    
}


