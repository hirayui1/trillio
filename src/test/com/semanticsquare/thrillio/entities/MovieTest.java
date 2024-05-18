package com.semanticsquare.thrillio.entities;

import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.manager.BookmarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void isKidFriendlyEligible() {
        //1 Test movie genre HORROR -- false
        Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941, new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles"}, MovieGenre.HORROR, 8.5);
        boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();

        assertFalse(isKidFriendlyEligible, "For Horror in movie genre, isKidFriendlyEligible must return false");

        //1 Test movie genre THRILLERS -- false
        movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941, new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles"}, MovieGenre.THRILLERS, 8.5);
        isKidFriendlyEligible = movie.isKidFriendlyEligible();

        assertFalse(isKidFriendlyEligible, "For Thrillers in movie genre, isKidFriendlyEligible must return false");
    }
}