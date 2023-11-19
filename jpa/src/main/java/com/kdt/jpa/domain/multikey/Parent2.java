package com.kdt.jpa.domain.multikey;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.repository.cdi.Eager;

@Entity
@Getter
@Setter
public class Parent2 {
    @EmbeddedId
    private ParentId2 id;
}
