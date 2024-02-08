package com.drogo.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Inheritance(
       /* strategy = InheritanceType.SINGLE_TABLE*/
        /*strategy = InheritanceType.JOINED*/
        strategy = InheritanceType.TABLE_PER_CLASS
)
/*@DiscriminatorColumn(
        name = "resource_type"
)*/
public class Resource {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private int size;

    private String url;

    @OneToOne
    @JoinColumn(
            name = "lecture_id"
    )
    private Lecture lecture;
}
