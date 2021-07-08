package ru.wts.kotlin;

public class IdeaStudy {
    double price;
    boolean isReady;

    public static void main(String[] args) {

        IdeaStudy ideaStudy = new IdeaStudy();
        if (ideaStudy.isReady) System.out.println("all is ok!");

        if (!ideaStudy.isReady) { }
    }
}
