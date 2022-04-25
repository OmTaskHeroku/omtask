package com.example.omtask.Contracts;

import com.example.omtask.Instances.Instance;
import com.example.omtask.Opinions.Opinion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @NotBlank
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    private ContractStatus status;

    @NotBlank
    @ManyToOne
    private Instance creator;

    @NotBlank
    @ManyToOne
    private Instance contractor;

    @NotBlank
    private Date expiration_date;

    @NotBlank
    @OneToMany(
            mappedBy = "contract",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Opinion> opinionList = new ArrayList<>();
}