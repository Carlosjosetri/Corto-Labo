package modelo;

/**
 *
 * @author LN710Q
 */
public class movie {
   private int id;
    private String nombre;
    private String director;
    private String clasificacion;
    private String pais;
    private boolean en_proyeccion;
    private int anio;

    public movie() {
    }

    public movie(int id, String nombre, String director, String clasificacion, String pais, boolean en_proyeccion, int anio) {
        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.clasificacion = clasificacion;
        this.pais = pais;
        this.en_proyeccion = en_proyeccion;
        this.anio = anio;
    }

    public movie(String nombre, String director, String clasificacion, String pais, boolean en_proyeccion, int anio) {
        this.nombre = nombre;
        this.director = director;
        this.clasificacion = clasificacion;
        this.pais = pais;
        this.en_proyeccion = en_proyeccion;
        this.anio = anio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public boolean getEn_proyeccion() {
        return en_proyeccion;
    }

    public void setEn_proyeccion(boolean en_proyeccion) {
        this.en_proyeccion = en_proyeccion;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    


  
   
     
}