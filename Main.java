import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // data user
        User user = new User("fahran", "12345", "fahran@gmail.com");

        //list lagu
        new Song("Imagine", "John Lennon");
        new Song("Bohemian Rhapsody", "Queen");
        new Song("Smells Like Teen Spirit", "Nirvana");
        new Song("Hotel California", "Eagles");
        new Song("Billie Jean", "Michael Jackson");
        new Song("Hey Jude", "The Beatles");
        new Song("Shape of You", "Ed Sheeran");
        new Song("Rolling in the Deep", "Adele");
        new Song("Uptown Funk", "Mark Ronson ft. Bruno Mars");
        new Song("Blinding Lights", "The Weeknd");


        Playlist playlist = new Playlist("My Playlist");

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Welcome to Barly Music App!");
        System.out.println();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.println();


        if (user.login(username, password)) {
            System.out.println("Login successful!");
            boolean running = true;
            boolean PlaylistMode = false; // Awalnya mode song

            while (running) {
                System.out.println();
                System.out.println("Menu:");
                System.out.println("1. Play");
                System.out.println("2. Pause");
                System.out.println("3. Next");
                System.out.println("4. Previous");
                System.out.println("5. Add Current Song to Playlist");
                System.out.println("6. View Playlist");
                System.out.println("7. Logout");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                System.out.println();

                switch (choice) {
                    case 1:
                        if (PlaylistMode) {
                            playlist.play();
                        } else {
                            Song.getCurrentSong().play();
                        }
                        break;
                    case 2:
                        if (PlaylistMode) {
                            playlist.pause();
                        } else {
                            Song.getCurrentSong().pause();
                        }
                        break;
                    case 3:
                        if (PlaylistMode) {
                            playlist.next();
                        } else {
                            Song.next(); // Ganti lagu dalam mode individu
                        }
                        break;
                    case 4:
                        if (PlaylistMode) {
                            playlist.prev();
                        } else {
                            Song.prev(); // Ganti lagu dalam mode individu
                        }
                        break;
                    case 5:
                        playlist.addSong(Song.getCurrentSong());
                    break;
                    case 6:
                        playlist.viewPlaylist();
                        PlaylistMode = true; // Beralih ke mode playlist
                        break;
                    case 7:
                        user.logout();
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } else {
            System.out.println("Login failed. Please try again.");
        }

        scanner.close();
    }
}
