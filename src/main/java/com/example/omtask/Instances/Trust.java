package com.example.omtask.Instances;

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
public class Trust {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "trust", cascade = CascadeType.ALL)
    private List<Instance> instanceList = new ArrayList<>();

}
