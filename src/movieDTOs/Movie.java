package movieDTOs;

/** 
 * This POJO (Plain Old Java Object) is called the Data Transfer Object (DTO)
 * (or the Model Object or the Value Object).
 * It is used to transfer data between the DAO and the Business Objects.
 * Here, it represents a row of data from the User database table.
 * 
 */

public class Movie
{
    private int id;
    private String title;
    private String genre;
    private String director;
    private String runtime;
    private String plot;
    private String location;
    private String rating;
    private String format;
    private String starring;
    private int copies;
    private String barcode;
    private String user_rating;

    public Movie(int id, String title, String genre, String director, String runtime, String plot, String location, String rating, String format, String starring, int copies, String barcode, String user_rating)
    {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.runtime = runtime;
        this.plot = plot;
        this.location = location;
        this.rating = rating;
        this.format = format;
        this.starring = starring;
        this.copies = copies;
        this.barcode = barcode;
        this.user_rating = user_rating;
    }
    
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public String getDirector()
    {
        return director;
    }

    public void setDirector(String director)
    {
        this.director = director;
    }

    public String getRuntime()
    {
        return runtime;
    }

    public void setRuntime(String runtime)
    {
        this.runtime = runtime;
    }

    public String getPlot()
    {
        return plot;
    }

    public void setPlot(String plot)
    {
        this.plot = plot;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getRating()
    {
        return rating;
    }

    public void setRating(String rating)
    {
        this.rating = rating;
    }

    public String getFormat()
    {
        return format;
    }

    public void setFormat(String format)
    {
        this.format = format;
    }

    public String getStarring()
    {
        return starring;
    }

    public void setStarring(String starring)
    {
        this.starring = starring;
    }

    public int getCopies()
    {
        return copies;
    }

    public void setCopies(int copies)
    {
        this.copies = copies;
    }

    public String getBarcode()
    {
        return barcode;
    }

    public void setBarcode(String barcode)
    {
        this.barcode = barcode;
    }

    public String getUser_rating()
    {
        return user_rating;
    }

    public void setUser_rating(String user_rating)
    {
        this.user_rating = user_rating;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", title=" + title + ", genre=" + genre + ", director=" + director + ", runtime=" + runtime + ", plot=" + plot + ", location=" + location + ", rating=" + rating + ", format=" + format + ", starring=" + starring + ", copies=" + copies + ", barcode=" + barcode + ", user_rating=" + user_rating + '}';
    }
    
    
    
}
