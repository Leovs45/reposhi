package logica;
import javax.persistence.*;


import java.util.Date;

import datatypes.DtUsuario;



@MappedSuperclass
//@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Usuario")
public abstract class Usuario {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nickname_id")
    private String nickname;
	@Column
    private String nombre;
	@Column
    private String apellido;
	@Column
    private String correoElectronico;
	@Column
    private Date fechaNacimiento;
    
    //cosntructor vacio
    public Usuario() {};
    
    
    
    //Constructor
    public Usuario(String nickname, String nombre, String apellido, String correoElectronico, Date fechaNacimiento) {
    	super();
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
    }

    //Getters & Setters
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public DtUsuario getDtUsuario() {
		return new DtUsuario(getNickname(), getNombre(), getApellido(), getCorreoElectronico(), getFechaNacimiento());
	}

}
