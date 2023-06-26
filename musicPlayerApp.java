
import java.util.*;

//import javax.lang.model.util.ElementScanner14;



public class song
{
    String title;
    double duration;

    Public Song(String title, double duration)
    {
     this.title= title;
     this.duration=duration;
    }
    public Song()
    {

    }
    public String getTitle()
    {
        return title;
    }
    public double getDuration()
    {
        return duration;
    }
   public String toString()
   {
    return "Song{"+
            "title='" + title + '\'' +
            ", duration=" + duration +
            '}';
   } 
}

//// Album class

public class Album
{
  private String name;
  private String artist;
  private ArrayList<Song> songs;

  public Album(String name, String artist)
  {
    this.name = name;
    this.artist = artist;
    this.songs = new ArrayList<Song>();
  }
  public Album()
  {

  }
  public Song findSong(String title)
  {
    for(Song checkedSong : songs)
    {
        if(checkedSong.getTitle().equals(title))return checkedSong;

    }
    return null;
  }
  public boolean addSong(String title, double duration)
 {
    if(findSong(title)==null)
    {
        songs.add(new Song(title,duration));
        System.out.println(title + "Successfully added to the list");
        return true;
    }
    else{
        System.out.println("song with name"+ title+ "already exist in the list");
        return false;
    }
 }
 public boolean addToPlayList(int trackNumber, LinkedList<Song>Playlist)
 {
   int index=trackNumber-1;
   if(index>0 && index<=this.song.size())
   {
    PlayList.add(this.songs.get(index));
    return true;
   } 
   System.out.println("this album does not have song with track number");
   return false;
 }

 public boolean addToPlayList(String title, LinkedList<Song> PlayList)
 
 {
 for(Song checkedSong : this.songs)
 {
    if(checkedSong.getTitle().equals(title))
    {
        PlayList.add(checkedSong);
        return true;
    }
 }
 System.out.println(title + "there is no such song in a album");
 return false;
 }

}

public class main
{
    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main (String[] args)
    {

        
        Album album = new Album( name: "Album1",artist: "AC/DC");
        album.addSong(title: "TNT", duration: 4.5);
        album.addSong(title: "Highway To Hell", duration: 3.5);
        album.addSong(title: "ThunderStroke", duration: 5.5);
    
        album = new Album(name: "Album2", artist:"Eminem");

        album.addSong(title: "Rap god", duration: 4.5);
        album.addSong(title: "Not afraid", duration: 5.6);
        album.addSong(title: "lose yourself", duration: 7.5);
    
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList(title: "TNT", playList_1);
        albums.get(0).addToPlayList(title: "highway to hell", playList_1);
        albums.get(1).addToPlayList(title: "Rap god", playList_1);
        albums.get(1).addToPlayList(title: "Lose yourself", playList_1);
     
        play(playList_1);
    
    }
   private static void play(LinkedList<Song>playList)
   {
     Scanner sc=new Scanner(System.in);
     boolean quit = false;
     boolean forward = true;
     ListIterator<Song>listIterator = playList.listIterator();

     if(playList.size()==0)
     {
        System.out.println("this playlist have no song");

     }
     else{
        System.out.println("Now playing"+ listIterator.next().toString());
        printMenu();
     }

     while(!quit)
     {
        int action = sc.nextInt();
        sc.nextLine();

        switch(action)
        {
            case 0:
            System.out.println("playlist complete");
            quit = true;
            break;

            case 1:
            if(!forward)
            {
                if(listIterator.hasNext())
                {
                    listIterator.next();
                }
                forward = true;
            }
            if(listIterator.hasNext())
            {
                System.out.println("now playing"+ listIterator.next().toString());

            }
            else{
             System.out.println("no song available, reached to the end of a list");
             forward = false;
            
            }
            break;

            case 2:
            if(forward)
            {
                if(listIterator.hasPrevious())
                {
                    listIterator.previous();
                }
                forward=false;
            }
            if(listIterator.hasPrevious())
            {
                System.out.println("Now playing"+listIterator.previous().toString());
            }
            else{
                System.out.println("we are at the first song");
                forward=false;
            }
            break;

            case 3:
            if(forward)
            {
                if(listIterator.hasPrevious())
                {
                    System.out.println("now playing"+listIterator.Previous().toString());
                    forward=false;
                }
                else
                {
                    System.out.println("we are at the starting of the list");
                }
            }
            else{
                if(listIterator.hasNext())
                {
                    System.out.println("now playing"+listIterator.next().toString());
                    forward=true;
                }else{
                    System.out.println("we have reached to the end of the list");

                }
            }
           break;

           case 4:

           printList(playList);
           break;

           case 5:
           printMenu();
           break;

           case 6:
           if(playList.size()>0)
           {
            listIterator.remove();
            if(listIterator.hasNext())
            {
                System.out.println("now playing"+listIterator.next().toString());
                
            }
            else{
                if(listIterator.hasPrevious())
                System.out.println("now playing"+listIterator.previous().toString());
            }
           }

        }
     }
   }

   private static void printMenu()
   {
    System.out.println("Avalilable options\n press");
    System.out.println("0 - to quit\n"+
                         "1 - to play next song\n"+
                         "2 - to play previous song\n"+
                         "3 - to replay the current song\n"+
                         "4 - list of all songs\n"+
                         "5 - print all available options\n"+
                         "6 - delete current song");
 }

 private static void printList(LinkedList<Song> playList)
 {
    Iterator<Song> iterator = playList.iterator();
    System.out.println("----------------");

    while (iterator.hasNext())
    {
        System.out.println(iterator.next());

    }
    System.out.println("----------------");
 }

}