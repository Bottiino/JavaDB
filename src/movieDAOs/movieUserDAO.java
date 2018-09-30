
package movieDAOs;

// look at update



import movieDTOs.Movie;
import Exceptions.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class movieUserDAO extends movieDAO implements movieDaoInterface
{
    public List<Movie> findAllMovies() throws DaoException 
    {
    	Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Movie> movies = new ArrayList<Movie>();
        
        try 
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "SELECT * FROM movies ORDER BY id";
            ps = con.prepareStatement(query);
            
            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next()) 
            {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String director = rs.getString("director");
                String runtime = rs.getString("runtime");
                String plot = rs.getString("plot");
                String location = rs.getString("location");
                String rating = rs.getString("rating");
                String format = rs.getString("format");
                String starring= rs.getString("starring");
                int copies = rs.getInt("copies");
                String barcode = rs.getString("barcode");
                String user_rating = rs.getString("user_rating");
                Movie u = new Movie(id, title, genre, director, runtime, plot, location, rating, format, starring,copies, barcode,user_rating);
                movies.add(u);
            }
        } 
        catch (SQLException e) 
        {
            throw new DaoException("findAllMovies() " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                throw new DaoException("findAllMovies() " + e.getMessage());
            }
        }
        return movies;     // may be empty
    }

    public Movie findMovieByTitle(String title) throws DaoException 
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Movie m = null;
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM movies WHERE title LIKE ?";
            ps = con.prepareStatement(query);
            ps.setString(1, title);
            
            rs = ps.executeQuery();
            if (rs.next()) 
            {
                int id = rs.getInt("id");
                title = rs.getString("title");
                String genre = rs.getString("genre");
                String director = rs.getString("director");
                String runtime = rs.getString("runtime");
                String plot = rs.getString("plot");
                String location = rs.getString("location");
                String rating = rs.getString("rating");
                String format = rs.getString("format");
                String starring= rs.getString("starring");
                int copies = rs.getInt("copies");
                String barcode = rs.getString("barcode");
                String user_rating = rs.getString("user_rating");
                m = new Movie(id, title, genre, director, runtime, plot, location, rating, format, starring,copies, barcode,user_rating);                
            }
        } 
        catch (SQLException e) 
        {
            throw new DaoException("findMovieByTitle()" + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                throw new DaoException("findMovieByTitle()" + e.getMessage());
            }
        }
        return m;     // u may be null 
    }  
    public List<Movie> findMovieByDirector(String directors) throws DaoException 
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Movie m = null;
        List<Movie> movies = new ArrayList<Movie>();
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM movies WHERE director LIKE '%" + directors + "%'";
            ps = con.prepareStatement(query);
            
            rs = ps.executeQuery();
            while (rs.next()) 
            {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                directors = rs.getString("director");
                String runtime = rs.getString("runtime");
                String plot = rs.getString("plot");
                String location = rs.getString("location");
                String rating = rs.getString("rating");
                String format = rs.getString("format");
                String starring= rs.getString("starring");
                int copies = rs.getInt("copies");
                String barcode = rs.getString("barcode");
                String user_rating = rs.getString("user_rating");
                Movie u = new Movie(id, title, genre, directors, runtime, plot, location, rating, format, starring,copies, barcode,user_rating);
                movies.add(u);
            }               
            
        } 
        catch (SQLException e) 
        {
            throw new DaoException("findMovieByDirector()" + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                throw new DaoException("findMovieByDirector()" + e.getMessage());
            }
        }
        return movies;     // u may be null 
    }
    public List<Movie> findMovieByGenre(String genre) throws DaoException 
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Movie> movies = new ArrayList<Movie>();
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM movies WHERE genre LIKE '%" + genre + "%'";
            ps = con.prepareStatement(query);
            
            rs = ps.executeQuery();
            while (rs.next()) 
            {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                genre = rs.getString("genre");
                String directors = rs.getString("director");
                String runtime = rs.getString("runtime");
                String plot = rs.getString("plot");
                String location = rs.getString("location");
                String rating = rs.getString("rating");
                String format = rs.getString("format");
                String starring= rs.getString("starring");
                int copies = rs.getInt("copies");
                String barcode = rs.getString("barcode");
                String user_rating = rs.getString("user_rating");
                Movie u = new Movie(id, title, genre, directors, runtime, plot, location, rating, format, starring,copies, barcode,user_rating);
                movies.add(u);
            }               
            
        } 
        catch (SQLException e) 
        {
            throw new DaoException("findMovieByGenre()" + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                throw new DaoException("findMovieByGenre()" + e.getMessage());
            }
        }
        return movies;     // u may be null 
    }
    public void addMovie(String title,String genre,String director,String runtime,String plot,String location,String rating,String format,String year,String starring,int copies,String barcode,String user_rating) throws DaoException 
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = this.getConnection();
            String query = "INSERT INTO movies(title,genre,director,runtime,plot,location,rating,format,year,starring,copies,barcode,user_rating) VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query); 
            ps.setString(1,title);
            ps.setString(2,genre);
            ps.setString(3,director);
            ps.setString(4,runtime);
            ps.setString(5,plot);
            ps.setString(6,location);
            ps.setString(7,rating);
            ps.setString(8,format);
            ps.setString(9,year);
            ps.setString(10,starring);
            ps.setInt(11,copies);
            ps.setString(12,barcode);
            ps.setString(13,user_rating);

            ps.executeUpdate();     //Problem with add here
        } 
        catch (SQLException e) 
        {
            throw new DaoException("addMovie()" + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                throw new DaoException("addMovie()" + e.getMessage());
            }
        }
    }
    public void removeMovieByTitle(String title) throws DaoException 
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;  
                
        try {
            con = this.getConnection();
            
            String query = "DELETE FROM movies WHERE title = ?";
            ps = con.prepareStatement(query); 
            ps.setString(1,title);
            ps.executeUpdate();
            
        } 
        catch (SQLException e) 
        {
            throw new DaoException("removeMovieByTitle()" + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                throw new DaoException("removeMovieByTitle()" + e.getMessage());
            }
        }
        
    }
    public void removeMovieById(int id) throws DaoException 
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;  
                
        try {
            con = this.getConnection();
            
            String query = "DELETE FROM movies WHERE id = ?";
            ps = con.prepareStatement(query); 
            ps.setInt(1,id);
            ps.executeUpdate();
            
        } 
        catch (SQLException e) 
        {
            throw new DaoException("removeMovieById()" + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                throw new DaoException("removeMovieById()" + e.getMessage());
            }
        }
    }
    public void updateMovieByTitle(String title,String genre, String director,String rating,String year) throws DaoException 
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;  
                
        try {
            con = this.getConnection();
            
            String query = "UPDATE movies SET genre = ?, director = ?, rating = ?, year = ? WHERE title = ?";
            ps = con.prepareStatement(query); 
            ps.setString(1,genre);
            ps.setString(2,director);
            ps.setString(3,rating);
            ps.setString(4,year);
            ps.setString(5,title);
            //executeUpdate() is what we need to update/insert but dont know how it works
            ps.executeUpdate();
            
        } 
        catch (SQLException e) 
        {
            throw new DaoException("updateMemberByTitle()" + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                throw new DaoException("updateMemberByTitle()" + e.getMessage());
            }
        }
    }    
}