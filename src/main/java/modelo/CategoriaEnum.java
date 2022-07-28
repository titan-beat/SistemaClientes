package modelo;

public enum CategoriaEnum {
    ACTIVO ("Activo"),
    INACTIVO ("Inactivo");
    private final String estado;
    CategoriaEnum(String estado) {
        this.estado = estado;
    }
    public String getEstado() {
        return estado;
    }  
}
