package com.softwareatumedida.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Test")
public class Test implements Serializable {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int Id;
    @Column(name="Nombre")
    private String Nombre;
}
