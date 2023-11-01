package org.daniel.model;

import java.util.Arrays;

public class Album {
    private final String name;
    private final String author;
    private final int year;
    private Song[] songs;

    public Album(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public static class Song {
        private final String name;
        private final int duration;

        public Song(String name, int duration) {
            this.name = name;
            this.duration = duration;
        }

        public String getName() {
            return name;
        }

        public int getDuration() {
            return duration;
        }

        @Override
        public String toString() {
            return "Song{" +
                    "name='" + name + '\'' +
                    ", duration=" + duration + "s" +
                    '}';
        }
    }

    public void setAlbum(Song[] songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", songs=" + Arrays.toString(songs) +
                '}';
    }

    public static void main(String[] args) {
        Album album = new Album("Album", "Author", 2021);
        Song[] songs = new Song[3];
        songs[0] = new Song("Song 1", 120);
        songs[1] = new Song("Song 2", 180);
        songs[2] = new Song("Song 3", 240);
        album.setAlbum(songs);
        System.out.println(album);
    }
}
