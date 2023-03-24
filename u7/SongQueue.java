///name:    date:
//first program on queues.
import java.io.*;
import java.util.*;

public class SongQueue {
	private static Scanner keyboard;
	private static Queue<String> songQueue;

	public static void main(String[] args) throws Exception {
		keyboard = new Scanner(System.in);

		fillPlayList();
		printSongList();

		String prompt = "\tAdd song (A), Play song (P), Delete song (D), Quit (Q):  ";
		System.out.print(prompt);

		String str = keyboard.nextLine().toUpperCase();
		while (!str.equals("Q")) {
			processRequest(str);
			System.out.print(prompt);
			str = keyboard.nextLine().toUpperCase();
		}

		System.out.println();
		System.out.println("No more music for you today.  Goodbye!");
		keyboard.close();
	}

	public static void fillPlayList() throws IOException {
		Scanner inFile = new Scanner(new File("songs.txt"));
		songQueue = new LinkedList<String>();
		while (inFile.hasNextLine())
			songQueue.add(inFile.nextLine());
	}

	public static void processRequest(String str) {
		switch (str) {
			case "A":
				add();
				break;
			case "P":
				play();
				break;
			case "D":
				delete();
				break;
			default:
				System.err.println("Something has gone wrong.");
		}
		printSongList();
	}

	public static void add() {
		System.out.print("Enter a song to add: ");
		songQueue.add(keyboard.nextLine());
	}

	public static void play() {
		System.out.print("Enter a song to play: ");
		String dSong = keyboard.nextLine();
		Queue<String> tmp = new LinkedList<String>();
		for (String i : songQueue) {
			if (!(i.equals(dSong))) {
				tmp.add(i);
			} else {
				System.out.println("Now playing: " + dSong);
			}
		}

		songQueue = tmp;
	}

	public static void delete() {
		System.out.print("Enter a song to delete: ");
		String dSong = keyboard.nextLine();
		Queue<String> tmp = new LinkedList<String>();
		while (songQueue.size() > 0) {
			if (songQueue.peek().equals(dSong))
				songQueue.remove();
			else
				tmp.add(songQueue.remove());
		}
		songQueue = tmp;
	}

	public static void printSongList() {
		System.out.println("Your music queue: " + songQueue);
	}
}
