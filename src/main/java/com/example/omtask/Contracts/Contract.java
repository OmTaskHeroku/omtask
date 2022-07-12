package com.example.omtask.Contracts;

import com.example.omtask.Instances.Instance;
import com.example.omtask.Opinions.Opinion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String title;

    private String description;

    @NotNull
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    private ContractStatus status;

    @NotNull
    @ManyToOne
    private Instance creator;

    @NotNull
    @ManyToOne
    private Instance contractor;

    @NotNull
    private Date expiration_date;

//    @NotBlank
    @JsonIgnore
    @OneToMany(
            mappedBy = "contract",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Opinion> opinionList = new ArrayList<>();
}