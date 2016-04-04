
package MovieManager;

/**
 *
 * @author Jake Bolton
 */
public class Movie extends MediaItem {
    
    private String format;
    
    
    public Movie(String name, String releaseYear, String type) {
        this.title = name;
        this.year = releaseYear;
        this.format = type;
    }
    
    public String getFormat(){
        return this.format;
    }
    
    public String getMediaInfo()
    {
        return this.format;
    }
    public void setMediaInfo(String input){
        this.format = input;
    }
    
}
