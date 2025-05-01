package com.Coding.jpa.models;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper=true)
@Entity
public class Section  extends BaseEntity{

     private String name;
     private String orderSection;

     @ManyToOne
     @JoinColumn(name = "course_id")
     private Course course;

     @OneToMany(mappedBy = "sections")
     private List<Lecture> lectures;

}
