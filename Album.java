
package moviemanager;

/**
 *
 * @author Jake Bolton
 */
public class Album extends MediaItem {
    
    private String artist;
    
    public Album( String maker, String releaseYear, String name){
        this.artist = maker;
        this.year = releaseYear;
        this.title = name;
        
    }
    
    public Album(MediaItem item)
    {
        this.artist = item.getMediaInfo();
        this.year = item.year;
        this.title = item.title;
    }
    
    public String getArtist() {
        return this.artist;
    }
    
    public String getMediaInfo()
    {
        return this.artist;
    }
    
    public void SetClass(){
        
    }
    
    public void setMediaInfo(String input){
        this.artist = input;
    }
}
