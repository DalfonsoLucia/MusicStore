package com.lucy.musicStore.album.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = Album.TABLE_NAME)
public class Album {
    public static final String TABLE_NAME = "album";

    @Id
    @Column(name = "ID_ALBUM")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ARTIST")
    private String artist;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "YEAR")
    private Date year;
    @Column(name = "TRACKS_NUMBER")
    private Integer tracksNumber;
    @Column(name = "DURATION")
    private Time duration;
    @Column(name = "AMOUNT")
    private Double amount;
    @Column(name = "SORT_KIND")
    private String sortKind;
    @Column(name = "CREATED_DATE")
    private Date createdDate;

}
