package ar.com.projectFinal;


public class Pelicula
{
	
    private int id;
    private String titulo;
    private LocalDate fecha_lanzamiento;
    private String genero;
    private String duracion;
    private String director; 
    private String reparto;
    private String sinopsis;

   
   
    public Pelicula() {}

   
   
    public Pelicula(int id, String titulo, LocalDate fecha_lanzamiento, String genero, String duracion, String director,
    		String reparto, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.director = director;
        this.reparto = reparto;
        this.sinopsis = sinopsis;
    }

    
    
	public int getId() 
	{
		return id;
	}

	
	
	public void setId(int id) 
	{
		this.id = id;
	}

	
	
	public String getTitulo()
	{
		return titulo;
	}

	
	
	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}
	
	
	
	public LocalDate getFecha_lanzamiento() 
	{
		return fecha_lanzamiento;
	}
	
	
	
	public void setFecha_lanzamiento(LocalDate fecha_lanzamiento) {
		this.fecha_lanzamiento = fecha_lanzamiento;
	}

	
	
	public String getGenero() 
	{
		return genero;
	}

	
	
	public void setGenero(String genero) 
	{
		this.genero = genero;
	}

	
	
	public String getDuracion()
	{
		return duracion;
	}

	
	
	public void setDuracion(String duracion)
	{
		this.duracion = duracion;
	}

	
	
	public String getDirector()
	{
		return director;
	}

	
	
	public void setDirector(String director) 
	{
		this.director = director;
	}

	
	
	public String getReparto()
	{
		return reparto;
	}

	
	
	public void setReparto(String reparto) 
	{
		this.reparto = reparto;
	}

	
	
	public String getSinopsis() 
	{
		return sinopsis;
	}

	
	
	public void setSinopsis(String sinopsis) 
	{
		this.sinopsis = sinopsis;
	}
    
}
