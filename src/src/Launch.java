import com.semanticsquare.thrillio.DataStore;
import com.semanticsquare.thrillio.bgjobs.WebpageDownloaderTask;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.manager.BookmarkManager;
import com.semanticsquare.thrillio.manager.UserManager;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Launch {
    private static List<User> users;
    private static List<List<Bookmark>> bookmarks;


    private static void loadData() {
        System.out.println("1. Loading data ...");
        DataStore.loadData();
        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarks();

        /*System.out.println("Printing data ...");
        printUserData();
        printBookmarkData();*/
    }

    private static void printBookmarkData() {
        for (List<Bookmark> bookmarkList : bookmarks) {
            for (Bookmark bookmark : bookmarkList) {
                System.out.println(bookmark);
            }
        }
    }

    private static void printUserData() {
        for (User user : users) {
            System.out.println(user);
        }
    }


    public static void main(String[] args) {
        loadData();
        start();

        // Background Jobs
        //runDownloaderJob();
    }

    private static void runDownloaderJob() {
        WebpageDownloaderTask task = new WebpageDownloaderTask(true);
        (new Thread(task)).start();

    }

    private static void start() {
        // System.out.println("\n2. Bookmarking ...");
        for (User user : users) {
            View.browse(user, bookmarks);
        }
    }
}
