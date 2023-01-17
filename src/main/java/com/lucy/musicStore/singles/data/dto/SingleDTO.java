package com.lucy.musicStore.singles.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SingleDTO {
    private Integer id;
    private String artist;
    private String title;
    private String genre;
    private String type;
}
