package com.git.studygittmp.data.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class OnikesumResponseDto {
    private Long number;
    private String name;
    private int age;
    private int sid;


    public OnikesumResponseDto() {

    }
}
