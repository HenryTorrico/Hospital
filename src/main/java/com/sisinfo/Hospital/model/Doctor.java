package com.sisinfo.Hospital.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nombreDoc")
    private String nombreDoc;

    @Column(name = "especialidadDoc")
    public String especialidadDoc;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private Set<Consulta> consultasDoc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreDoc() {
        return nombreDoc;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public String getEspecialidadDoc(){
        return especialidadDoc;
    }
    public void setEspecialidadDoc(String especialidadDoc){
        this.especialidadDoc=especialidadDoc;
    }


    public Set<Consulta> getConsultasDoc() {
        return consultasDoc;
    }

    public void setConsultasDoc(Set<Consulta> consultasDoc) {
        this.consultasDoc = consultasDoc;
    }
}
