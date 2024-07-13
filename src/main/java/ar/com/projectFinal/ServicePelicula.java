package ar.com.projectFinal;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class ServicePelicula 
{
	
	
	private Conexion conexion;
	public ServicePelicula ()
	{
		this.conexion= new Conexion();
	}
	
	
	
	public List<Pelicula> getAllPeliculas() throws ClassNotFoundException, SQLException 
    {
		
		
        List<Pelicula> peliculas = new ArrayList();
        Connection con = conexion.getConnection();
        String sql = "SELECT * FROM peliculas";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        
        while (rs.next()) {
            Pelicula pelicula = new Pelicula
            	(
                rs.getInt("id"),
                rs.getString("titulo"),                
                rs.getString("genero"),
                rs.getString("duracion"),
                rs.getString("director"),
                rs.getString("reparto"),
                rs.getString("sinopsis")
                );
            peliculas.add(pelicula);
        }
        rs.close();
        ps.close();
        
        return peliculas;
        
        
        
    }

    public Pelicula getPeliculaById(int id) throws ClassNotFoundException ,SQLException 
    {
    	
        Pelicula pelicula = null;
        Connection con = conexion.getConnection();
        String sql = "SELECT * FROM peliculas WHERE id = ?"; //-----> signo de pregunta
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);// buscamos por id, el "1" dignifica el primer signo de pregunta... puede tener mas singos, colocar de forma ordenada
        ResultSet rs = ps.executeQuery();

        
        if (rs.next()) 
        {
            pelicula = new Pelicula(
                rs.getInt("id"),
                rs.getString("titulo"),               
                rs.getString("genero"),
                rs.getString("duracion"),
                rs.getString("director"),
                rs.getString("reparto"),
                rs.getString("sinopsis")
            );
        }
        
        rs.close();
        ps.close();
        return pelicula;
    }

    public void addPelicula(Pelicula pelicula) throws ClassNotFoundException ,SQLException 
    {
    	
    	
        Connection con = conexion.getConnection();
        String sql = "INSERT INTO peliculas (titulo,  genero, duracion, director, reparto, sinopsis) VALUES (?, ?, ?, ?, ?, ?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, pelicula.getTitulo());       
        ps.setString(2, pelicula.getGenero());
        ps.setString(3, pelicula.getDuracion());
        ps.setString(4, pelicula.getDirector());
        ps.setString(5, pelicula.getReparto());
        ps.setString(6, pelicula.getSinopsis());
        ps.executeUpdate();

        ps.close();
        con.close();
        
    }
    
    
    

    public void updatePelicula(Pelicula pelicula) throws ClassNotFoundException ,SQLException 
    {
    	
    	
        Connection con = conexion.getConnection();
        String sql = "UPDATE peliculas SET titulo=?,  genero=?, duracion=?, director=?, reparto= ?, sinopsis= ? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, pelicula.getTitulo());      
        ps.setString(3, pelicula.getGenero());
        ps.setString(4, pelicula.getDuracion());
        ps.setString(5, pelicula.getDirector());
        ps.setString(6, pelicula.getReparto());
        ps.setString(7, pelicula.getSinopsis());
        ps.setInt(8, pelicula.getId());
        ps.executeUpdate();
        ps.close();
        con.close();
        
        
    }
    
    
    

    public void deletePelicula(int id) throws ClassNotFoundException ,SQLException 
    {
    	
    	
        Connection con = conexion.getConnection();
        String sql = "DELETE FROM peliculas WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();

        ps.close();
        con.close();
        
        
    }

}
