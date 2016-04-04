
package moviemanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jake Bolton
 */
public class MovieManager {

    //private static Album album;
    //private static Movie movie;
    private static ArrayList<MediaItem> MediaList;
    private static ArrayList<MediaItem> MovieList;
    private static ArrayList<MediaItem> AlbumList;
    private static ArrayList<MediaItem> SortedMediaList;
    
    //Constructor
    public MovieManager(){
        MediaList = new ArrayList<>();
        MovieList = new ArrayList<>();
        AlbumList = new ArrayList<>();
        SortedMediaList = new ArrayList<>();
    }
    
    
    public static void createCollectionFile(){
    
        try (Scanner scanner = new Scanner(new File("collection.txt"))) {
            while (scanner.hasNext()){
                if (scanner.nextLine().equals("Album")){
                    String artist = scanner.nextLine();
                    String year = scanner.nextLine();
                    String title = scanner.nextLine();
                    
                    Album album = new Album(artist, year, title);
                    MediaList.add(album);
                    AlbumList.add(album);     
                }
                else{
                    String title = scanner.nextLine();
                    String year = scanner.nextLine();
                    String format = scanner.nextLine();
                    
                    Movie movie = new Movie(title, year, format);
                    MediaList.add(movie);
                    MovieList.add(movie);
                }
            }
        }catch(FileNotFoundException e){System.err.println("Collection.txt not created");}
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        createCollectionFile();
        try {
            menu(MediaList);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MovieManager.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void menu(ArrayList<MediaItem> MediaList) throws FileNotFoundException{
    
        Scanner userInput = new Scanner(System.in);
        SortedMediaList = new ArrayList<>();
        PrintWriter outFile = new PrintWriter(new File("collection.txt"));
        for (MediaItem item : MediaList){
        if (item.getClass().equals(Album.class)) {
                           outFile.println("Album");
                           outFile.println(item.getMediaInfo());
                           outFile.println(item.getYear());
                           outFile.println(item.getTitle());
                        } 
                         else {
                           outFile.println("Movie");
                           outFile.println(item.getTitle());
                           outFile.println(item.getYear());
                           outFile.println(item.getMediaInfo());
                        }}

        int choice = 0;
        String stringInput = "";
        
        System.out.print("Would you like to: \n-------------------\n"
                + "1. Search by artist, title, year, or movie format\n"
                + "2. Enter new item into collection\n"
                + "3. Remove an item from collection\n"
                + "Enter your option as a number: ");
        
        choice = userInput.nextInt();
        
        
        // for searching
        switch (choice) {
            case 1:  
                System.out.print("Would you like to search for:\n"
                        + "--------------------------\n"
                        + "1. Artist (Albums Only)\n"
                        + "2. Title\n"
                        + "3. Release year\n"
                        + "4. Format (Movies Only)\n"
                        + "Enter your option as a number: ");

                int SearchOption = userInput.nextInt();

                switch (SearchOption) {
                    case 1:
                        System.out.println("Enter the Artist's name: ");
                        String artistName = userInput.next();
                        for(MediaItem item : MediaList)
                            if(item.getClass().equals(Album.class)){
                                if(item.getMediaInfo().equals(artistName)) {
                                    System.out.println("The artist " + item.getMediaInfo()
                                            + ", has album titled " + item.getTitle() +
                                            " and it was released in the year " + 
                                            item.getYear() + ".");
                                }

                            }
                        break;
                    case 2:
                        System.out.println("Enter a title: ");
                        stringInput = userInput.next();
                        for(MediaItem item : MediaList)
                            if(item.getTitle().equals(stringInput))
                            {

                                if(item.getClass().equals(Album.class)){
                                    System.out.println("The artist " + item.getMediaInfo()
                                            + ", has album titled " + item.getTitle() +
                                            " and it was released in the year " + 
                                            item.getYear() + ".");
                                }
                                else if (item.getClass().equals(Movie.class)){
                                    System.out.println("The movie " + item.getTitle()
                                            + ", was released as a " + item.getMediaInfo() +
                                            " and it was released in the year " + 
                                            item.getYear() + ".");
                                }

                            }
                            else{

                            }
                        break;
                    case 3:
                        System.out.println("Enter a release year: ");
                        stringInput = userInput.next();
                        for(MediaItem item : MediaList)
                            if(item.getYear().equals(stringInput))
                            {

                                if(item.getClass().equals(Album.class)){
                                    System.out.println("The artist " + item.getMediaInfo()
                                            + ", has album titled " + item.getTitle() +
                                            " and it was released in the year " +
                                            item.getYear() + ".");
                                }
                                else if (item.getClass().equals(Movie.class)){
                                    System.out.println("The movie " + item.getTitle()
                                            + ", was released as a " + item.getMediaInfo() +
                                            " and it was released in the year " + 
                                            item.getYear() + ".");
                                }

                            }
                            else{

                            }
                        break;
                    case 4:
                        System.out.println("Enter a format: ");
                        stringInput = userInput.next();
                        for(MediaItem item : MediaList)
                            if(item.getMediaInfo().equals(stringInput))
                            {

                                if(item.getClass().equals(Album.class)){
                                    System.out.println("The artist " + item.getMediaInfo()
                                            + ", has album titled " + item.getTitle() +
                                            " and it was released in the year " +
                                            item.getYear() + ".");
                                }
                                else if (item.getClass().equals(Movie.class)){
                                    System.out.println("The movie " + item.getTitle()
                                            + ", was released as a " + item.getMediaInfo() +
                                            " and it was released in the year " + 
                                            item.getYear() + ".");
                                }

                            }
                            else{

                            }
                        break;
                    default:
                        System.out.println("Invalid Input");
                        menu(MediaList);
                        break;
                }
                break;
            //add media
            case 2:
                //Determine if it is a movie or an Album
                System.out.println("Did you want to add an (1)Album or a (2)Movie:");
                int choice3 = userInput.nextInt();
                //Handle for a album
                if (choice3 == 1){
                    System.out.println("Enter the artist's name:");
                    String artist = userInput.nextLine();
                    artist = userInput.nextLine();
                    System.out.println("Enter the album's release year:");
                    String year = userInput.nextLine();
                    System.out.println("Enter the album's title:");
                    String title = userInput.nextLine();
                    
                    Album media = new Album(artist, year, title);
                    MediaList.add(media);
                    
                    AlbumList = new ArrayList<>();
                    for (MediaItem item: MediaList){
                        if (item.getClass().equals(Album.class)){
                            AlbumList.add(item);
                        }
                     
                    }
                    Collections.sort(AlbumList);
                    for(MediaItem item : AlbumList){
                    System.out.println(item.getTitle());}
                    
                    for (MediaItem item: AlbumList){
                        SortedMediaList.add(item);      
                    }
                    for(MediaItem item : MovieList){
                        SortedMediaList.add(item);
                    }
                    
                            
//                    
                    
                }
                //Handle for an movie
                else if(choice ==2){
                    System.out.println("Enter the movie's title:");
                    String title = userInput.nextLine();
                    title = userInput.nextLine();
                    System.out.println("Enter the movie's release year:");
                    String year = userInput.nextLine();
                    System.out.println("Enter the movie's format:");
                    String format = userInput.nextLine();
                    
                    Movie media = new Movie(title, year, format);
                    MediaList.add(media);
                    
                    MovieList = new ArrayList<>();
                    for (MediaItem item: MediaList){
                        if (item.getClass().equals(Movie.class)){
                            MovieList.add(item);
                        }
                    }
                    Collections.sort(MovieList);
                    
                    for (MediaItem item : AlbumList){
                        SortedMediaList.add(item);
                }  
                    for (MediaItem item: MovieList){
                        SortedMediaList.add(item);
                    }
                }
                //Error case
                else {
                    System.out.println("Invalid Input");
                    menu(MediaList);
                } 
                
                for (MediaItem item : SortedMediaList){
                    if(item.getClass().equals(Album.class)){
                        outFile.println("Album");
                        outFile.println(item.getMediaInfo());
                        outFile.println(item.getYear());
                        outFile.println(item.getTitle());
                    }
                    else{
                        outFile.println("Movie");
                        outFile.println(item.getTitle());
                        outFile.println(item.getYear());
                        outFile.println(item.getMediaInfo());
                    }
                }
                outFile.close();
                
                break;
                
            //remove media
            case 3:
                
                for(MediaItem item : MediaList){
                    System.out.println(item.getTitle());
                }
                System.out.println("Enter the Item you want removed (List above): ");
                 
                stringInput = userInput.nextLine();
                        
                if(userInput.hasNext()){  
                    stringInput = stringInput + userInput.nextLine();
                }
                        
               
                System.out.println(stringInput);
                
                for(MediaItem item : MediaList){
                    if (item.getTitle().equals(stringInput)){
                        System.out.println(item.getTitle());
                        System.out.println(stringInput);
                        
                        System.out.println("Removed: "+ stringInput);
                    }
                    else{
                        System.out.println("Not the title");
                        if (item.getClass().equals(Album.class)) {
                           outFile.println("Album");
                           outFile.println(item.getMediaInfo());
                           outFile.println(item.getYear());
                           outFile.println(item.getTitle());
                        } 
                         else {
                           outFile.println("Movie");
                           outFile.println(item.getTitle());
                           outFile.println(item.getYear());
                           outFile.println(item.getMediaInfo());
                        }
                    }
                }
                outFile.close();
                break;
            default:
                System.out.println("Invalid Input");
                menu(MediaList);
                break;
        }
    }
    
//    public int compareTo(MediaItem other) {
//        if (other.getClass().equals(Album.class)) {
//           int result = getMediaInfo().compareTo(other.getMediaInfo());
//            
//        } 
//        else {
//            // code to handle when other is a Movie
//        }
//    }
    
    
    
    
    public void Searching(int SearchOption, Scanner userInput)
    {
        switch (SearchOption) {
        case 1:
            System.out.println("Enter the Artist's name: ");
            String artistName = userInput.next();
            for(MediaItem item : MediaList)
                if(item.getClass().equals(Album.class)){
                    if(item.getMediaInfo().equals(artistName)) {
                        System.out.println("The artist " + item.getMediaInfo()
                                + ", has album titled " + item.getTitle() +
                                " and it was released in the year " + 
                                item.getYear() + ".");
                    }
                }
            break;

        case 2:
            System.out.println("Enter a title: ");
            String title = userInput.next();
            for(MediaItem item : MediaList)
                if(item.getTitle().equals(title))
                {

                    if(item.getClass().equals(Album.class)){
                        System.out.println("The artist " + item.getMediaInfo()
                                + ", has album titled " + item.getTitle() +
                                " and it was released in the year " + 
                                item.getYear() + ".");
                    }
                    else if (item.getClass().equals(Movie.class)){
                        System.out.println("The movie " + item.getTitle()
                                + ", was released as a " + item.getMediaInfo() +
                                " and it was released in the year " + 
                                item.getYear() + ".");
                    }

                }
                else{

                }
            break;

        case 3:
            System.out.println("Enter a release year: ");
            String year = userInput.next();
            for(MediaItem item : MediaList)
                if(item.getYear().equals(year))
                {

                    if(item.getClass().equals(Album.class)){
                        System.out.println("The artist " + item.getMediaInfo()
                                + ", has album titled " + item.getTitle() +
                                " and it was released in the year " +
                                item.getYear() + ".");
                    }
                    else if (item.getClass().equals(Movie.class)){
                        System.out.println("The movie " + item.getTitle()
                                + ", was released as a " + item.getMediaInfo() +
                                " and it was released in the year " + 
                                item.getYear() + ".");
                    }

                }
                else{

                }
            break;

        case 4:
            System.out.println("Enter a format: ");
            String format = userInput.next();
            for(MediaItem item : MediaList)
                if(item.getMediaInfo().equals(format))
                {

                    if(item.getClass().equals(Album.class)){
                        System.out.println("The artist " + item.getMediaInfo()
                                + ", has album titled " + item.getTitle() +
                                " and it was released in the year " +
                                item.getYear() + ".");
                    }
                    else if (item.getClass().equals(Movie.class)){
                        System.out.println("The movie " + item.getTitle()
                                + ", was released as a " + item.getMediaInfo() +
                                " and it was released in the year " + 
                                item.getYear() + ".");
                    }

                }
                else{

                }
        }
}
}
