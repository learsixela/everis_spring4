package com.everis.data.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="personas")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    //relacion 1 a 1
	@OneToOne(mappedBy="persona", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Licencia licencia;
    
    //muchos a uno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="curso_id")
	private Curso curso;
	
	
    public Persona() {};
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }



	public Long getId() {
		return id;
	}



	public String getNombre() {
		return nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Licencia getLicencia() {
		return licencia;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setLicencia(Licencia licencia) {
		this.licencia = licencia;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
