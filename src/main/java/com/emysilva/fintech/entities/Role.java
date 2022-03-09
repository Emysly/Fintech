package com.emysilva.fintech.entities;

import lombok.*;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role extends BaseEntity {
    private String name;
}
