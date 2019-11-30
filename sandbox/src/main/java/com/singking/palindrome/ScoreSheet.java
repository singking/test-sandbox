package com.singking.palindrome;

import java.util.Date;

public class ScoreSheet {

    private String user;
    private String palindrome;
    private int score;
    private final Date date;


    public ScoreSheet() {
        date = new Date();
    }

    public ScoreSheet(String user, String palindrome, int score) {
        this();
        this.user = user;
        this.palindrome = palindrome;
        this.score = score;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setPalindrome(String palindrome) {
        this.palindrome = palindrome;
    }

    public String getPalindrome() {
        return palindrome;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public Date getDate() {
        return date;
    }
}
