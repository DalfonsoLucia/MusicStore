package com.lucy.musicStore.product.music.data.model.abstactModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public abstract class ProductMusicAbstract {


    @Column(name = "TITLE")
    private String title;
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "YEAR")
    private Date year;
    @Column(name = "AMOUNT")
    private Double amountStock;
    @Column(name = "SORT_KIND")
    private String type;
    @Column(name = "CREATED_DATE")
    private Date createdDate;





}
