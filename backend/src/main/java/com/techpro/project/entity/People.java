package com.techpro.project.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name = "people")
public class People {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "PersonID")
    private int personId;
    @Column(name = "FirstName")
    private  String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Email")
    private String email;



    public int getPersonId() {

        return personId;
    }

    public void setPersonId(int personId) {

        this.personId = personId;
    }

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

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }
}
