package com.example.omtask.Users;

import com.example.omtask.Contracts.Contract;
import com.example.omtask.Instances.Instance;
import com.example.omtask.Messages.Message;
import com.example.omtask.Opinions.Opinion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genUser"
    )
    @SequenceGenerator(
            name = "genUser",
            allocationSize = 1
    )
    Long id;

    @NotBlank
    String name;

    @NotBlank
    String surname;

    @NotBlank
    String nickname;

    @NotBlank
    @Email
    @Column(unique = true)
    String mail;

    @NotBlank
    Enum<UserRole> role;

    @NotBlank
    @JsonIgnore
    String password;

    String description;

    @NotBlank
    @ManyToOne
    Instance origin;

    Boolean isLeader;

    @JsonIgnore
    @OneToMany(
        mappedBy = "sender",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    List<Message> messageSentList;

    @JsonIgnore
    @OneToMany(
        mappedBy = "receiver",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    List<Message> messageReceivedList;
}


enum UserRole {

    A, B, C
}