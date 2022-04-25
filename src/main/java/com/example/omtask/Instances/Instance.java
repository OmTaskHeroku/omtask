package com.example.omtask.Instances;

import com.example.omtask.Contracts.Contract;
import com.example.omtask.Opinions.Opinion;
import com.example.omtask.Users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Instance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Column(unique = true)
    private String address;

    @NotBlank
    private Boolean trust;

    @JsonIgnore
    @OneToMany(
        mappedBy = "id",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private List<User> userList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(
            mappedBy = "creator",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Contract> conCreatedList = new ArrayList<>();
    @JsonIgnore
    @OneToMany(
            mappedBy = "contractor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Contract> conContractorList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(
            mappedBy = "judge",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Opinion> opinionSentList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(
            mappedBy = "suspect",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Opinion> opinionReceivedList = new ArrayList<>();
}
