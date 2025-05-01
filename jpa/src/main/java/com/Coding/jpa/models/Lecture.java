package com.Coding.jpa.models;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
@EqualsAndHashCode(callSuper=true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Lecture   extends BaseEntity {

    private String name;

   @ManyToOne
   @JoinColumn(name = "section_id")
   private Section sections;


    @OneToOne
    @JoinColumn(name = "resources_id")
    private Resource resource;
}
