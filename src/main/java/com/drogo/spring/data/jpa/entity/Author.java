package com.drogo.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@NamedQuery(
        name="Author.findAllAgeByNamedQuery",
        query="select a from Author a where a.age>= :age"
)
/*@Table(
        name = "AUTHOR_TBL"
)*/
public class Author extends BaseEntity {
    /*  It's recommended to use wrappers over primitives
     *  The default value for `int` is  0, while for `Integer`, it is `null` */
    /*@Id
    @GeneratedValue(
            strategy = GenerationType.TABLE,
             generator = "author_id_gen"
    )*/
    /*@SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1)*/
    /*@TableGenerator(name = "author_id_gen",
            table = "id_generator",
            pkColumnName = "id_name",
            valueColumnName = "id_value",
            allocationSize = 1)*/
   /* private Integer id;*/

    @Column(
            name = "f_name",
            length = 35
    )
    private String firstName;

    private String lastName;

    @Column(
            unique = true,
            nullable = false
    )
    private String email;

    private int age;

/*    @Column(
            updatable = false,
            nullable = false
    )
    private LocalDateTime createdAt;

    @Column(
            insertable = false
    )
    private LocalDateTime lastModified;*/

    @ManyToMany(
            mappedBy = "authors",
            fetch = FetchType.EAGER
    )
    private List<Course> courses;


}
