package com.jobinow.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Apply extends AbstractEntity {
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User jobSeeker;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Offre offre;
    @OneToMany
    private Set<Attachment> resumePdfs;
}
