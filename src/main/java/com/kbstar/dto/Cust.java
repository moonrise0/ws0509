package com.kbstar.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Cust {
    @Size(min=4, max=10, message = "ID는 최소4개 최대10 입니다.")
    @NotEmpty(message = "ID는 필수 항목 입니다.")
    private String id;
    @Size(min=5, max=10, message = "ID는 최소5개 최대10 입니다.")
    @NotEmpty(message = "PWD는 필수 항목 입니다.")
    private String pwd;
    @NotEmpty(message = "NAME는 필수 항목 입니다.")
    private String name;
}
