package com.example.omtask.Contracts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ContractStatus {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String status;

    @JsonIgnore
    @OneToMany(
            mappedBy = "status",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Contract> contracts = new ArrayList<>();
}