
package MovieObjects;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.net.*;
import java.util.List;
import movieDTOs.Movie;

public class MovieClient
{
    public static void main( String [] args) throws IOException
    {
        String hostName = "localhost";
        int portNumber = 4443;
        
        System.out.println("+++ This is the Movie Server program...");
        System.out.println("+++ Connecting to SERVER... ");
        
        try (                  
                Socket socket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));                
            ) 
        {
            
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));            
            String userInput;
            String fromServer;
            boolean quit = false;
                        
            while ((fromServer = in.readLine()) != null)// keep reading from stream
            {  
                while(!quit)
                {
                    boolean retry = true;

                    printStart();
                    System.out.println("\nPlease Enter Option: ");
                    userInput = stdIn.readLine();

                    if(userInput.equalsIgnoreCase("Search Movies"))
                    {
                        while(retry == true)
                        {
                            printSearchMenu();
                            System.out.println("\nPlease Enter Option: ");
                            userInput = stdIn.readLine();  

                            if(userInput.equalsIgnoreCase("Search All Movies"))
                            {
                                out.println(userInput);

                                fromServer = in.readLine();

                                Gson gson = new Gson();
                                Type type = new TypeToken<List<Movie>>(){}.getType();
                                List<Movie> movies = gson.fromJson(fromServer, type);

                                for(Movie movie :  movies)
                                {
                                   System.out.println(movie.toString()); 
                                }
                            }
                            else if(userInput.equalsIgnoreCase("Search By Title"))
                            {
                                System.out.println("\nPlease Enter Title: ");
                                String title = stdIn.readLine(); 

                                String sendData = userInput + "," + title;

                                out.println(sendData);

                                fromServer = in.readLine();

                                if(fromServer.equalsIgnoreCase("null"))
                                {
                                    System.out.println("\n\n** Nothing found in the database! **");
                                }
                                else
                                {
                                    Gson gson = new Gson();
                                    Type type = new TypeToken<Movie>(){}.getType();

                                    Movie movie = gson.fromJson(fromServer, type);

                                    System.out.println(movie.toString());
                                }
                            }
                            else if(userInput.equalsIgnoreCase("Search By Director"))
                            {
                                System.out.println("\nPlease Enter Director: ");
                                String director = stdIn.readLine(); 

                                String sendData = userInput + "," + director;

                                out.println(sendData);

                                fromServer = in.readLine();
                                                               
                                if(fromServer.equalsIgnoreCase("null"))
                                {
                                    System.out.println("\n\n** Nothing found in the database! **");
                                }
                                else
                                {
                                    Gson gson = new Gson();
                                    Type type = new TypeToken<List<Movie>>(){}.getType();

                                    List<Movie> movies = gson.fromJson(fromServer, type);

                                    for(Movie movie :  movies)
                                    {
                                       System.out.println(movie.toString()); 
                                    }
                                }
                            }
                            else if(userInput.equalsIgnoreCase("Search By Genre"))
                            {
                                System.out.println("\nPlease Enter Genre: ");
                                String genre = stdIn.readLine(); 

                                String sendData = userInput + "," + genre;

                                out.println(sendData);

                                fromServer = in.readLine();

                                if(fromServer.equalsIgnoreCase("null"))
                                {
                                    System.out.println("\n\n** Nothing found in the database! **");
                                }
                                else
                                {
                                    Gson gson = new Gson();
                                    Type type = new TypeToken<List<Movie>>(){}.getType();

                                    List<Movie> movies = gson.fromJson(fromServer, type);

                                    for(Movie movie :  movies)
                                    {
                                       System.out.println(movie.toString()); 
                                    }
                                }
                            }
                            else if(userInput.equalsIgnoreCase("Back"))
                            {                                
                                retry = false;
                            }
                            else
                            {
                                System.out.println("\n\n** Careful! Please Check Your Spelling! **");
                            }
                        }
                    }
                    else if(userInput.equalsIgnoreCase("Add Movie"))
                    {                        
                        String[] details = { "title", "genre", "director", "runtime", "plot", "location", "rating", "format", "year", "starring", "copies", "barcode", "user_rating"};
                        
                        System.out.println("\n Please Enter The Required Details Of The New Movie You Would Like To Add:");
                        
                        String sendData = userInput;
                                
                        for(String detail : details)
                        {
                            System.out.println("\nEnter " + detail + ":");
                            if(detail.equals("user_rating"))
                            {
                                System.out.println("** Please Ensure Input Between 0-10 **");
                                String addOn = stdIn.readLine();
                                while(!addOn.matches("[1-9]|10")){
                                    System.out.println("** Please Ensure Input Between 0-10 **");
                                    addOn = stdIn.readLine();
                                }
                                sendData = sendData + "," + addOn;
                            }
                            else if(detail.equals("rating"))
                            {                                
                                System.out.println("** Please Ensure Input Is Either G , PG , PG-13 or R **");
                                String addOn = stdIn.readLine();
                                while(!addOn.matches("G|PG|PG-13|R")){
                                    System.out.println("** Please Ensure Input Is Either G , PG , PG-13 or R **");
                                    addOn = stdIn.readLine();
                                }
                                sendData = sendData + "," + addOn;
                                
                            }
                            else if(detail.equals("format"))
                            {                                
                                System.out.println("** Please Ensure Format Is Either DVD OR BLU-RAY **");
                                String addOn = stdIn.readLine();
                                while(!addOn.matches("DVD|BLU-RAY")){
                                    System.out.println("** Please Ensure Format Is Either DVD OR BLU-RAY **");
                                    addOn = stdIn.readLine();
                                }
                                sendData = sendData + "," + addOn;
                                
                            }
                            else if(detail.equals("year"))
                            {
                                System.out.println("** Please Ensure Year Is Between 1900-2018 **");
                                String addOn = stdIn.readLine();
                                while(!addOn.matches("19\\d\\d|20[01][012345678]")){
                                    System.out.println("** Please Ensure Year Is Between 1900-2018 **");
                                    addOn = stdIn.readLine();
                                }
                                sendData = sendData + "," + addOn;
                            }
                            else if(detail.equals("copies"))
                            {
                                System.out.println("** Please Ensure Input Is Numeric **");
                                String addOn = stdIn.readLine();
                                while(!addOn.matches("^\\d+")){
                                    System.out.println("** Please Ensure Input Is Numeric **");
                                    addOn = stdIn.readLine();
                                }
                                sendData = sendData + "," + addOn;
                            }
                            else
                            {
                                String addOn = stdIn.readLine(); 

                                sendData = sendData + "," + addOn;
                            }
                        }
                        
                        System.out.println("send: " + sendData);
                        
                        out.println(sendData);
                        
                        fromServer = in.readLine();
                        System.out.println("Server: " + fromServer);
                            
                        Gson gson = new Gson();
                        Type type = new TypeToken<Movie>(){}.getType();

                        Movie movie = gson.fromJson(fromServer, type);
                            
                        System.out.println("\n** Success! Your New Movie Has Been Added **");
                        System.out.println(movie.toString());
                    }
                    else if(userInput.equalsIgnoreCase("Remove Movie"))
                    {                        
                        System.out.println("\nPlease Enter Title: ");
                        String title = stdIn.readLine(); 

                        String sendData = userInput + "," + title;

                        out.println(sendData);

                        fromServer = in.readLine();

                        Gson gson = new Gson();
                        Type type = new TypeToken<String>(){}.getType();

                        String s = gson.fromJson(fromServer, type);

                        System.out.println(s);
                    }
                    else if(userInput.equalsIgnoreCase("Update Movie"))
                    {                        
                        String[] details = { "title", "genre", "director", "rating", "year"};
                        
                        System.out.println("\nUpdate the details of your desired movie");
                        
                        String sendData = userInput;
                                
                        for(String detail : details)
                        {
                            System.out.println("\nEnter " + detail + ":");
                            if(detail.equals("year"))
                            {
                                System.out.println("** Please Ensure Year Is Between 1900-2018 **");
                                String addOn = stdIn.readLine();
                                while(!addOn.matches("19\\d\\d|20[01][012345678]")){
                                    System.out.println("** Please Ensure Year Is Between 1900-2018 **");
                                    addOn = stdIn.readLine();
                                }
                                sendData = sendData + "," + addOn;
                            }
                            else if(detail.equals("rating"))
                            {                                
                                System.out.println("** Please Ensure Input Is Either G , PG , PG-13 or R **");
                                String addOn = stdIn.readLine();
                                while(!addOn.matches("G|PG|PG-13|R")){
                                    System.out.println("** Please Ensure Input Is Either G , PG , PG-13 or R **");
                                    addOn = stdIn.readLine();
                                }
                                sendData = sendData + "," + addOn;
                                
                            }
                            else
                            {
                                String addOn = stdIn.readLine(); 
                            
                                sendData = sendData + "," + addOn;
                            }
                        }
                        
                        out.println(sendData);
                                               
                        fromServer = in.readLine();
                        
                        if(fromServer.equalsIgnoreCase("null"))
                        {
                            System.out.println("\n\n** Nothing found in the database by that title! **");
                        }
                        else
                        {
                            Gson gson = new Gson();
                            Type type = new TypeToken<Movie>(){}.getType();

                            Movie movie = gson.fromJson(fromServer, type);

                            System.out.println("\n ** Success! Movie Has Been Updated With New Information **");
                            System.out.println(movie.toString());
                        }
                    }  
                    else if(userInput.equalsIgnoreCase("My Recommended Movies"))
                    {                        
                        System.out.println("\n Please Enter Title Of Movie You Like: ");
                        String title = stdIn.readLine(); 

                        String sendData = userInput + "," + title;

                        out.println(sendData);

                        fromServer = in.readLine();

                        Gson gson = new Gson();

                        Type type = new TypeToken<List<Movie>>(){}.getType();
                        List<Movie> movies = gson.fromJson(fromServer, type);

                        for(Movie movie :  movies)
                        {
                           System.out.println(movie); 
                        }
                    }
                    else if(userInput.equalsIgnoreCase("Exit"))
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("\n\n** Careful! Please Check Your Spelling! **");
                    }  
                }
                break;
            }                
        } catch (UnknownHostException e) {
            System.err.println("Don't Know About Host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't Get I/O For The Connection To "
                    + hostName);
            System.err.println(e.toString());
            System.exit(1);
        }
    }
    
    public static void printStart()
    {
        System.out.println("\n\nWhat Would You Like To Do? \nOption 1: Search Movies \nOption 2: Add Movie \nOption 3: Remove Movie \nOption 4: Update Movie \nOption 5: My Recommended Movies \nOption 6: Exit");
                    
    }
    
    public static void printSearchMenu()
    {
        System.out.println("\n\nHow Would You Like To Search? \nOption 1: Search All Movies \nOption 2: Search By Title \nOption 3: Search By Director \nOption 4: Search By Genre \nOption 5: Back");
                    
    }
}