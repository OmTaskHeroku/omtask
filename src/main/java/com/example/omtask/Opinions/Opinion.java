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
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genOpinion"
    )
    @SequenceGenerator(
            name = "genOpinion",
            allocationSize = 1
    )
    Long id;

    @NotBlank
    @ManyToOne
    User judge;

    @NotBlank
    @ManyToOne
    User suspect;

    @NotBlank
    @ManyToOne
    Contract contract;

    @NotBlank
    Integer rate;

    @NotBlank
    String content;
}
