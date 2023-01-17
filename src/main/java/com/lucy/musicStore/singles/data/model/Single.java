package com.lucy.musicStore.singles.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = Single.TABLE_NAME)
public class Single {
    public static final String TABLE_NAME = "single";

    @Id
    @Column(name = "ID_SINGLE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ARTIST")
    private String artist;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "ALBUM")
    private String album;
    @Column(name = "YEAR")
    private Date year;
    @Column(name = "DURATION")
    private Time duration;
    @Column(name = "AMOUNT")
    private Double amount;
    @Column(name = "SORT_KIND")
    private String type;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
}
