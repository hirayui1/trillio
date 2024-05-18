package com.semanticsquare.thrillio.entities;

import com.semanticsquare.thrillio.manager.BookmarkManager;

import static org.junit.jupiter.api.Assertions.*;

class WebLinkTest {

    @org.junit.jupiter.api.Test
    void isKidFriendlyEligible() {
        //1 Test porn in url -- false
        WebLink webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html", "http://www.javaworld.com");

        boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();

        assertFalse(isKidFriendlyEligible, "For porn in url - isKidFriendlyEligible() must return false.");
        //2 Test porn in title -- false
        webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming porn Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com");

        isKidFriendlyEligible = webLink.isKidFriendlyEligible();

        assertFalse(isKidFriendlyEligible, "For porn in title - isKidFriendlyEligible() must return false.");
        //3 Test adult in host -- false
        webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.adult.com");

        isKidFriendlyEligible = webLink.isKidFriendlyEligible();

        assertFalse(isKidFriendlyEligible, "For adult in host - isKidFriendlyEligible() must return false.");

        //4 Test adult in url && not in host -- true
        webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html", "http://www.javaworld.com");

        isKidFriendlyEligible = webLink.isKidFriendlyEligible();

        assertTrue(isKidFriendlyEligible, "For adult in url - isKidFriendlyEligible() must return true.");

        //5 Test adult in title only -- true
        webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming adult Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com");

        isKidFriendlyEligible = webLink.isKidFriendlyEligible();

        assertTrue(isKidFriendlyEligible, "For adult in title - isKidFriendlyEligible() must return true.");



    }
}