package com.johand3v.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "paciente")
public class Paciente {

@Id
@GeneratedValue(strategy =  GenerationType.IDENTITY)
private Integer idPaciente;

@Size(min=3 ,max=70, message = "Minimo 3 y Maximo 70 digitos")
@Column(name = "nombres", nullable = false, length = 70)
private String nombres;

@Size(min=3,max=70, message = "Minimo 3 y Maximo 70 digitos")
@Column(name = "apellidos", nullable = false, length = 70)
private String apellidos;

@Size(min=8, max=8, message = "Es necesario 8 digitos")
@Column(name = "dni", nullable = false, length = 8)
private String dni;

@Size(max=150, message = "Maximo 150 digitos")
@Column(name = "direccion", nullable = true, length = 150)
private String direccion;

@Size(max=9, message = "Maximo 9 digitos")
@Column(name = "telefono", nullable = true, length = 9)
private String telefono;

@Size(max=50, message = "Maximo 50 digitos")
@Email
@Column(name = "email", nullable = true, length = 55)
private String email;

public Integer getIdPaciente() {
	return idPaciente;
}
public void setIdPaciente(Integer idPaciente) {
	this.idPaciente = idPaciente;
}
public String getNombres() {
	return nombres;
}
public void setNombres(String nombres) {
	this.nombres = nombres;
}
public String getApellidos() {
	return apellidos;
}
public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}
public String getDni() {
	return dni;
}
public void setDni(String dni) {
	this.dni = dni;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


}