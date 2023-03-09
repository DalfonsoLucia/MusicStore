package com.lucy.musicStore.ordination.data.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucy.musicStore.product.music.data.model.Album;
import com.lucy.musicStore.product.music.data.model.Gadget;
import com.lucy.musicStore.product.music.data.model.Single;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = Ordination.TABLE_NAME)
public class Ordination {
    public static final String TABLE_NAME = "ordination";

    @Id
    @Column(name = "id_ordination")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "insert_ordination_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date insertOrdinationDate;

    @ManyToMany
    private List<Album> albums;

    @ManyToMany
    private List<Single> singles;

    @ManyToMany
    private List<Gadget> gadgets;
}
