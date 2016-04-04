
package MovieManager;

/**
 *
 * @author Jake Bolton
 */
public abstract class MediaItem implements Comparable<MediaItem> {
    
    
    protected String title;
    protected String year;
   
    
    public String getTitle(){
        return this.title;
    }
    
    public String getYear(){
        return this.year;
    }
    
    public abstract String getMediaInfo();
    
    //public abstract void SetClass();
    
    public void setYear(String input){
        this.year = input;
        
    }
    public void setTitle(String input){
        this.title = input;
    }
    public abstract void setMediaInfo(String input);
    
    
    public int compareTo(MediaItem other){
         
        if (other.getClass().equals(Album.class)) {
            System.out.println("It is a Album");
            

           int result = getMediaInfo().compareTo(other.getMediaInfo());
           if (result < 0) {
               return -1;//before
           }
           else if(result >0){
               return 1; // after
           }
           else{
               result = getYear().compareTo(other.getYear());
               if (result < 0) {
               return -1;//before
                }
                else if(result >0){
                    return 1; // after
                }
                else{
                    result = getTitle().compareTo(other.getTitle());
                    if (result < 0) {
                        return -1;//before
                    }
                    else if(result >0){
                        return 1; // after
                    }
                    else{
                        return 0;
                
                    }
                }
           }
         }
         
        
        else {
            // code to handle when other is a Movie
           System.out.println("It is a Movie");
           int result = getTitle().compareTo(other.getTitle());
           if (result < 0) {
               return -1;//before
           }
           else if(result >0){
               return 1; // after
           }
           else{
               result = getYear().compareTo(other.getYear());
               if (result < 0) {
               return -1;//before
                }
                else if(result >0){
                    return 1; // after
                }
                else{
                    result = getMediaInfo().compareTo(other.getMediaInfo());
                    if (result < 0) {
                        return -1;//before
                    }
                    else if(result >0){
                        return 1; // after
                    }
                    else{
                        return 0;
                
                    }
                }
           }
        }
    
    }
}
