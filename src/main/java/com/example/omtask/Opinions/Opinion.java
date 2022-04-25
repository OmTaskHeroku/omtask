package com.example.omtask.Opinions;

import com.example.omtask.Contracts.Contract;
import com.example.omtask.Instances.Instance;
import com.example.omtask.Users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @ManyToOne
    private User judge;

    @NotBlank
    @ManyToOne
    private User suspect;

    @NotBlank
    @ManyToOne
    private Contract contract;

    @NotBlank
    private Integer rate;

    @NotBlank
    private String content;
}
