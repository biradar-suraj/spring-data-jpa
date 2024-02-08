package com.drogo.spring.data.jpa.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
/*@DiscriminatorValue(
        value = "VIDEO"
)*/
/*@PrimaryKeyJoinColumn(
        name = "video_id"
)*/
public class Video extends Resource{

    private int length;
}
