package com.kdt.jpa.domain.multikey;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Embeddable
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ParentId2 implements Serializable {
    private String id1;
    private String id2;
}
