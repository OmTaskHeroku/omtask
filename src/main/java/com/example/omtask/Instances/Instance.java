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
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Instance {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genInstance"
    )
    @SequenceGenerator(
            name = "genInstance",
            allocationSize = 1
    )
    Long id;

    @NotBlank
    String name;

    @NotBlank
    @Column(unique = true)
    String address;

    @NotBlank
    Boolean trust;

    @JsonIgnore
    @OneToMany(
        mappedBy = "id",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    List<User> userList;

    @JsonIgnore
    @OneToMany(
            mappedBy = "creator",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    List<Contract> conCreatedList;

    @JsonIgnore
    @OneToMany(
            mappedBy = "contractor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    List<Contract> conContractorList;

    @JsonIgnore
    @OneToMany(
            mappedBy = "judge",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    List<Opinion> opinionSentList;

    @JsonIgnore
    @OneToMany(
            mappedBy = "suspect",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    List<Opinion> opinionReceivedList;
}
