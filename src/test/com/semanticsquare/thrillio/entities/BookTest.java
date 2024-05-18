package com.semanticsquare.thrillio.entities;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.manager.BookmarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void isKidFriendlyEligible() {
        //1 Test - return false if philosophy
        Book book = BookmarkManager.getInstance().createBook(4000, "Walden", "", 1854, "Wilder Publications", new String[]{"Henry David", "Thoreau"}, BookGenre.PHILOSOPHY, 4.3);
        boolean isKidFriendlyEligible = book.isKidFriendlyEligible();

        assertFalse(isKidFriendlyEligible, "For Philosophy in Book, isKidFriendlyEligible must be false.");

        //2 test - return false if self-help
        book = BookmarkManager.getInstance().createBook(4003, "Head First Design Patterns", "", 2004, "O'Reilly Media", new String[]{"Eric Freeman", "Bert Bates", "Kathy Sierra", "Elisabeth Robson"}, BookGenre.SELF_HELP, 4.5);
        isKidFriendlyEligible = book.isKidFriendlyEligible();

        assertFalse(isKidFriendlyEligible, "For Self Help in Book, isKidFriendlyEligible must be false.");


    }
}