package com.kdt.jpa.domain.multikey;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class ParentId implements Serializable {
    private String id1;
    private String id2;
}
