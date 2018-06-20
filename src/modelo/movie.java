package modelo;

/**
 *
 * @author LN710Q
 */
public class movie {
   private int id;
    private String nombre;
    private String director;
        private String pais;
    private String clasificacion;

      private int anio;
    private boolean en_proyeccion;
  

    public movie() {
    }

    public movie(int id, String nombre, String director, String pais, String clasificacion, int anio, boolean en_proyeccion) {
        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.pais = pais;
        this.clasificacion = clasificacion;
        this.anio = anio;
        this.en_proyeccion = en_proyeccion;
    }

    public movie(String nombre, String director, String pais, String clasificacion, int anio, boolean en_proyeccion) {
        this.nombre = nombre;
        this.director = director;
        this.pais = pais;
        this.clasificacion = clasificacion;
        this.anio = anio;
        this.en_proyeccion = en_proyeccion;
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