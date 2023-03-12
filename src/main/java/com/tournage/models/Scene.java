package com.tournage.models;

import javax.persistence.*;

@Entity
@Table(name = "scene")
public class Scene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false, referencedColumnName = "idscene")
    private Action actions;

    @Column(name = "idplateau")
    private Integer idPlateau;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Action getActions() {
        return actions;
    }

    public void setActions(Action actions) {
        this.actions = actions;
    }

    public Integer getIdPlateau() {
        return idPlateau;
    }

    public void setIdPlateau(Integer idPlateau) {
        this.idPlateau = idPlateau;
    }

}