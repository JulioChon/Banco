package dominio;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase que representa al cliente
 * @author esteb
 */
public class Cliente {

    private Integer id;                 // Identificador del cliente
    private String nombre;              // Nombre del cliente
    private String apellidoPaterno;     // Apellido paterno del cliente
    private String apellidoMaterno;     // Apellido materno del cliente
    private Date fechaNacimiento;       // Fecha de nacimiento del cliente
    private Integer edad;               // Edad del cliente
    private String correoElectronico;   // Correo electrónico del cliente
    private String contrasena;          // Contraseña del cliente
    private Integer idDireccion;        // Identificador de la dirección del cliente

    /**
     * Constructor vacío. Inicializa todos los atributos con valores por
     * defecto.
     */
    public Cliente() {
        this.nombre = "";
        this.apellidoPaterno = "";
        this.apellidoMaterno = "";
        this.fechaNacimiento = Date.valueOf(LocalDate.now());
        this.edad = 0;
        this.correoElectronico = "";
        this.contrasena = "";
        this.idDireccion = 0;
    }

    /**
     * Constructor que recibe todos los atributos.
     *
     * @param nombre Nombre del cliente
     * @param apellidoPaterno Apellido paterno del cliente
     * @param apellidoMaterno Apellido materno del cliente
     * @param fechaNacimiento Fecha de nacimiento del cliente
     * @param edad Edad del cliente
     * @param correoElectronico Correo electrónico del cliente
     * @param contrasena Contraseña del cliente
     * @param idDireccion Identificador de la dirección del cliente
     */
    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, Integer edad, String correoElectronico, String contrasena, Integer idDireccion) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.idDireccion = idDireccion;
    }

    /**
     * Constructor que recibe todos los atributos, incluyendo el identificador
     * del cliente.
     *
     * @param id Identificador del cliente
     * @param nombre Nombre del cliente
     * @param apellidoPaterno Apellido paterno del cliente
     * @param apellidoMaterno Apellido materno del cliente
     * @param fechaNacimiento Fecha de nacimiento del cliente
     * @param edad Edad del cliente
     * @param correoElectronico Correo electrónico del cliente
     * @param contrasena Contraseña del cliente
     * @param idDireccion Identificador de la dirección del cliente
     */
    public Cliente(Integer id, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, Integer edad, String correoElectronico, String contrasena, Integer idDireccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.idDireccion = idDireccion;
    }

    /**
     * Constructor que crea un cliente con un identificador, correo electrónico
     * y contraseña.
     *
     * @param id el identificador del cliente.
     * @param correoElectronico el correo electrónico del cliente.
     * @param contrasena la contraseña del cliente.
     */
    public Cliente(Integer id, String correoElectronico, String contrasena) {
        this.id = id;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    /**
     * Constructor que crea un cliente con un correo electrónico y contraseña.
     *
     * @param correoElectronico el correo electrónico del cliente.
     * @param contrasena la contraseña del cliente.
     */
    public Cliente(String correoElectronico, String contrasena) {
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    /**
     * Método que devuelve el identificador del cliente.
     *
     * @return el identificador del cliente.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método que establece el identificador del cliente.
     *
     * @param id el identificador del cliente.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método que devuelve el nombre del cliente.
     *
     * @return el nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que establece el nombre del cliente.
     *
     * @param nombre el nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve el apellido paterno del cliente.
     *
     * @return el apellido paterno del cliente.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Método que establece el apellido paterno del cliente.
     *
     * @param apellidoPaterno el apellido paterno del cliente.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Método que devuelve el apellido materno del cliente.
     *
     * @return el apellido materno del cliente.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Método que establece el apellido materno del cliente.
     *
     * @param apellidoMaterno el apellido materno del cliente.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Método que devuelve la fecha de nacimiento del cliente.
     *
     * @return la fecha de nacimiento del cliente.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método que establece la fecha de nacimiento del cliente.
     *
     * @param fechaNacimiento la fecha de nacimiento del cliente.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Metodo que devuelve la edad del cliente
     *
     * @return la edad del cliente
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     *
     * Método que establece la edad del cliente.
     *
     * @param edad la edad del cliente a establecer.
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     *
     * Método que obtiene el correo electrónico del cliente.
     *
     * @return el correo electrónico del cliente.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     *
     * Método que establece el correo electrónico del cliente.
     *
     * @param correoElectronico el correo electrónico del cliente a establecer.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     *
     * Método que obtiene la contraseña del cliente.
     *
     * @return la contraseña del cliente.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     *
     * Método que establece la contraseña del cliente.
     *
     * @param contrasena la contraseña del cliente a establecer.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     *
     * Método que obtiene el ID de la dirección del cliente.
     *
     * @return el ID de la dirección del cliente.
     */
    public Integer getIdDireccion() {
        return idDireccion;
    }

    /**
     *
     * Método que establece el ID de la dirección del cliente.
     *
     * @param idDireccion el ID de la dirección del cliente a establecer.
     */
    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    /**
     *
     * Método que calcula el valor hash del objeto Cliente.
     *
     * @return el valor hash del objeto Cliente.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     *
     * Método que comprueba si un objeto es igual al objeto Cliente.
     *
     * @param obj el objeto a comparar con el objeto Cliente.
     * @return true si el objeto es igual al objeto Cliente, false en caso
     * contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     *
     * Método que devuelve una cadena de texto que representa al objeto Cliente.
     *
     * @return una cadena de texto que representa al objeto Cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + ", correoElectronico=" + correoElectronico + ", contrasena=" + contrasena + ", idDireccion=" + idDireccion + '}';
    }
}
