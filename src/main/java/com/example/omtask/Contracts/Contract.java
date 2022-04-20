package com.example.omtask.Contracts;

import com.example.omtask.Instances.Instance;
import com.example.omtask.Opinions.Opinion;
import com.example.omtask.Users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contract {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "genContract"
    )
    @SequenceGenerator(
        name = "genContract",
        allocationSize = 1
    )
    Long id;

    @NotBlank
    String title;

    String description;

    @NotBlank
    Double price;

    @NotBlank
    Enum<ContractStatus> status;

    @NotBlank
    @ManyToOne
    Instance creator;

    @NotBlank
    @ManyToOne
    Instance contractor;

    @NotBlank
    Date expiration_date;

    @NotBlank
    @OneToMany(
        mappedBy = "contract",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    List<Opinion> opinionList;
}


enum ContractStatus {

    A, B, C
}