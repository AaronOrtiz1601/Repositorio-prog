package prog.unidad06.re.ejercicio01;

public class Usuario {
    private String nombre;
    private String telefono;
    private String codigoPostal;
    private String usuario;
    private String password;

    public Usuario(String nombre, String telefono, String codigoPostal, String usuario, String password) {
        comprobarNombre(nombre);
        comprobarTfn(telefono);
        comprobarCodPostal(codigoPostal);
        comprobarUsuario(usuario);
        comprobarContraseña(password);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        comprobarNombre(nombre);
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        comprobarTfn(telefono);
        this.telefono = telefono;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        comprobarCodPostal(codigoPostal);
        this.codigoPostal = codigoPostal;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        comprobarUsuario(usuario);
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        comprobarContraseña(password);
        this.password = password;
    }

    private void comprobarNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede ser nulo o vacío");
        }
        String expresion = "^[A-Z]{1}[A-Za-züñ_\\s-]{1,99}+$";
        if (!nombre.matches(expresion)) {
            throw new IllegalArgumentException("Nombre no cumple con el formato permitido");
        }
    }

    private void comprobarTfn(String telefono) {
        if (telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException("Teléfono no puede ser nulo o vacío");
        }
        String expresion = "^[6-9]\\d{8}$";
        if (!telefono.matches(expresion)) {
            throw new IllegalArgumentException("Teléfono no cumple con el formato permitido");
        }
    }

    private void comprobarCodPostal(String codigoPostal) {
        if (codigoPostal == null || codigoPostal.isEmpty()) {
            throw new IllegalArgumentException("Código Postal no puede ser nulo o vacío");
        }
        String expresion = "^(0[1-9]|[1-4][0-9]|5[0-2])\\d{3}$";
        if (!codigoPostal.matches(expresion)) {
            throw new IllegalArgumentException("Código Postal no cumple con el formato permitido");
        }
    }

    private void comprobarUsuario(String usuario) {
        if (usuario == null || usuario.isEmpty()) {
            throw new IllegalArgumentException("Usuario no puede ser nulo o vacío");
        }
        String expresion = "^[a-zA-Z][a-zA-Z0-9-_]{1,9}$";
        if (!usuario.matches(expresion)) {
            throw new IllegalArgumentException("Usuario no cumple con el formato permitido");
        }
    }

    private void comprobarContraseña(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Contraseña no puede ser nula o vacía");
        }
        String expresion = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[.,;:/\\*&%$()])[A-Za-z0-9.,;:/\\*&%$()]{8,16}$";
        if (!password.matches(expresion)) {
            throw new IllegalArgumentException("Contraseña no cumple con el formato permitido");
        }
    }
}
