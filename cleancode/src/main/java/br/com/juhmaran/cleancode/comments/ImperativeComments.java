package br.com.juhmaran.cleancode.comments;

public class ImperativeComments {

    /**
     * @param title             The title of the CD
     * @param author            The author of the CD
     * @param tracks            The number of tracks on the CD
     * @param durationInMinutes The duration of the CD in minute
     */
    public void addCD(String title, String author, int tracks, int durationInMinutes) {
        CD cd = new CD();
        cd.title = title;
        cd.author = author;
        cd.tracks = tracks;
        cd.duration = durationInMinutes;
        // cdList.add(cd);
    }

    public static class CD {
        private String title;
        private String author;
        private int tracks;
        private int duration;

        public CD() {
        }

    }

}
