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
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "genMessage"
    )
    @SequenceGenerator(
        name = "genMessage",
        allocationSize = 1
    )
    Long id;

    @NotBlank
    String text;

    @NotBlank
    @Temporal(TemporalType.TIMESTAMP)
    Date date = new Date();

    @NotBlank
    @ManyToOne
    User sender;

    @NotBlank
    @ManyToOne
    User receiver;
}
