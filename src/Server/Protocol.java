/**
 * This is the Model that maintains the STATE of the interaction.
 * The PROTOCOL is implemented using logic and state transitions.
 * 
 * 
 * */

package Server;

import Exceptions.DaoException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import movieDTOs.Movie;
import java.util.List;
import movieDAOs.movieDaoInterface;
import movieDAOs.movieUserDAO;

public class Protocol
{
    private static final int WAITING = 0;
    private static final int SENTMENU1 = 1;
    
    private int state = WAITING;
    
    public String processInput(String theInput) throws DaoException 
    {        
        movieDaoInterface dao = new movieUserDAO();
        Gson gson = new Gson();  
        
        String theOutput;
        
        if (state == WAITING) 
        { 
            theOutput = "";
            
            state = SENTMENU1;
            
            Type type = new TypeToken<String>(){}.getType();

            String output = gson.toJson(theOutput, type);
            
            return output;
        }
        else if (state == SENTMENU1)
        {
            String str = theInput;
            String[] input = str.split(",");
                        
            if (input[0].equalsIgnoreCase("Search All Movies")) 
            {
                List<Movie> list = dao.findAllMovies();

                Type type = new TypeToken<List<Movie>>(){}.getType();

                String output = gson.toJson(list, type);

                return output;
            }
            else if(input[0].equalsIgnoreCase("Search By Title"))
            {
                System.out.println("fdsafdsaf");
                Movie movie = dao.findMovieByTitle(input[1]);
                
                Type type = new TypeToken<Movie>(){}.getType();
                
                String output = gson.toJson(movie, type);
                
                return output;
            }
            else if(input[0].equalsIgnoreCase("Search By Director"))
            {
                List<Movie> list = dao.findMovieByDirector(input[1]);
                
                if(list == null || list.size() <= 0)
                {                 
                    String output = "null";

                    return output;
                }
                else
                {           
                    Type type = new TypeToken<List<Movie>>(){}.getType();

                    String output = gson.toJson(list, type);

                    return output;
                }
            }
            else if(input[0].equalsIgnoreCase("Search By Genre"))
            {
                List<Movie> list = dao.findMovieByGenre(input[1]);
                                
                if(list == null || list.size() <= 0)
                {                 
                    String output = "null";

                    return output;
                }
                else
                {           
                    Type type = new TypeToken<List<Movie>>(){}.getType();

                    String output = gson.toJson(list, type);

                    return output;
                }
            }
            else if(input[0].equalsIgnoreCase("Add Movie"))
            {            
                System.out.println("int" + input[11]);
                int copies = Integer.parseInt(input[11]);
                
                System.out.println("copies: " + copies);
                
                dao.addMovie(input[1],input[2],input[3],input[4],input[5],input[6],input[7],input[8],input[9],input[10],copies,input[12],input[13]);
                
                Movie movie = dao.findMovieByTitle(input[1]);
                
                Type type = new TypeToken<Movie>(){}.getType();
                
                String output = gson.toJson(movie, type);
                
                return output;
            }
            else if(input[0].equalsIgnoreCase("Remove Movie"))
            {
                Movie movie = dao.findMovieByTitle(input[1]);
                
                if(movie == null)
                {
                    String removed = "\n\n** Nothing found in the database! **";
                
                    Type type = new TypeToken<String>(){}.getType();

                    String output = gson.toJson(removed, type);

                    return output;
                }
                else
                {                
                    dao.removeMovieByTitle(input[1]);

                    String removed = "\n\n** Movie has been successfully removed from the database! **";

                    Type type = new TypeToken<String>(){}.getType();

                    String output = gson.toJson(removed, type);

                    return output;
                }
            }
            else if(input[0].equalsIgnoreCase("Update Movie"))
            {    
                Movie movie = dao.findMovieByTitle(input[1]);
                
                if(movie == null)
                {
                    String output = "null";

                    return output;
                }
                else
                { 
                    dao.updateMovieByTitle(input[1], input[2], input[3], input[4], input[5]);

                    Movie movie2 = dao.findMovieByTitle(input[1]);

                    Type type = new TypeToken<Movie>(){}.getType();

                    String output = gson.toJson(movie2, type);

                    return output;
                }
            }
            else if(input[0].equalsIgnoreCase("Recommend Movies"))
            {                
                Movie movie = dao.findMovieByTitle(input[1]);
                
                List<Movie> list = dao.findMovieByDirector(movie.getDirector());
                                
                Type type = new TypeToken<List<Movie>>(){}.getType();
                
                String output = gson.toJson(list, type);
                                
                return output;
            }
            else
            {
                theOutput =  "Check your spelling";
                
                Type type = new TypeToken<String>(){}.getType();

                String output = gson.toJson(theOutput, type);

                return output;
            }
        }
        else
        {
            return "error";
        }
    
    }
}






















