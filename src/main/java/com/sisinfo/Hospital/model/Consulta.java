package com.sisinfo.Hospital.model;


import javax.persistence.*;


@Entity
@Table(name = "consulta1")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @Column(name = "tipo")
    public String tipo;

    @Column(name = "fecha")
    public Integer fecha;

    @Column(name = "descripcion")
    public String descripcion;

    @ManyToOne
    @JoinColumn(name="user_id")
    public User user;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    public Doctor doctor;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getFecha() {
        return fecha;
    }

    public void setFecha(Integer fecha) {
        this.fecha = fecha;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
