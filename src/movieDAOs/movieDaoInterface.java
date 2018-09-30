/**                                                         
 * UserDaoInterface
 * 
 * Declares the methods that all UserDAO types must implement,
 * be they MySql User Daos or Oracle User Daos etc...
 * 
 * Classes from the Business Layer (users of this Dao)
 * should use reference variables of this type so that 
 * the underlying concrete classes can be changed as required.
 * More sophistocated implementations will use a factory
 * method to instantiate the Dao concrete classes.
 * 
 * Interfaces are also useful when testing, as concrete classes
 * can be replaced by mock DAO objects.
 */
package movieDAOs;

import movieDTOs.Movie;
import Exceptions.DaoException;
import java.util.List;

public interface movieDaoInterface 
{
    public List<Movie> findAllMovies() throws DaoException;
    public Movie findMovieByTitle(String title) throws DaoException ;
    public List<Movie> findMovieByDirector(String director) throws DaoException ;
    public List<Movie> findMovieByGenre(String genre) throws DaoException;
    public void addMovie(String title,String genre,String director,String runtime,String plot,String location,String rating,String format,String year,String starring,int copies,String barcode,String user_rating)throws DaoException;
    public void removeMovieByTitle(String title) throws DaoException ;
    public void removeMovieById(int id) throws DaoException ;
    public void updateMovieByTitle(String title,String genre, String director,String rating,String year) throws DaoException ;
}
