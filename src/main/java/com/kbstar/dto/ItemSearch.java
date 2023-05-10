package com.kbstar.dto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ItemSearch {
    private String name;
    private Integer price;
    //int가 아닌 integer로 하면 null값이 가능하다
    private String startdate;
    private String enddate;


}