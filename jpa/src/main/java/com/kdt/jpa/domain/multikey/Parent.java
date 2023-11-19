package com.kdt.jpa.domain.multikey;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionIdJdbcType;

@Entity
@Getter
@Setter
@IdClass(ParentId.class)
public class Parent {
    @Id
    private String id1;
    @Id
    private String id2;
}
