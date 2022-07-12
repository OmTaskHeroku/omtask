package com.example.omtask.Opinions;

import com.example.omtask.Contracts.Contract;
import com.example.omtask.Instances.Instance;
import com.example.omtask.Users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @ManyToOne
    private User judge;

    @NotNull
    @ManyToOne
    private User suspect;

    @NotNull
    @ManyToOne
    private Contract contract;

    @NotBlank
    private String content;

    @NotNull
    private Integer rate;
}
