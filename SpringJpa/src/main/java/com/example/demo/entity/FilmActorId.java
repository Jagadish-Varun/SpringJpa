package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
class FilmActorId implements java.io.Serializable {
    @Column(name = "actor_id", nullable = false, columnDefinition = "SMALLINT UNSIGNED")
    private Integer actorId;

    @Column(name = "film_id", nullable = false, columnDefinition = "SMALLINT UNSIGNED")
    private Integer filmId;
}
