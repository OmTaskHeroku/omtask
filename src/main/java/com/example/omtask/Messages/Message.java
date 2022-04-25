package com.example.omtask.Messages;

import com.example.omtask.Users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    private String text;

    @NotBlank
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    @NotBlank
    @ManyToOne
    private User sender;

    @NotBlank
    @ManyToOne
    private User receiver;
}
