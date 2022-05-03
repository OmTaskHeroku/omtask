package com.example.omtask.Users;

import com.example.omtask.Instances.Instance;
import com.example.omtask.Messages.Message;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    @Column(unique = true)
    private String username;

    @NotBlank
    @Email
    @Column(unique = true)
    private String mail;

    @NotBlank
    @JsonIgnore
    private String password;

    private String description;

    @ManyToOne
    @JoinColumn(name = "idRole")
    private Role role;

    @ManyToOne
    private Instance origin;

    @JsonIgnore
    @OneToMany(
        mappedBy = "sender",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private List<Message> messageSentList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(
        mappedBy = "receiver",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private List<Message> messageReceivedList = new ArrayList<>();
}


