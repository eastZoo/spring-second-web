package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {
    @NotEmpty(message = "회원 이름은 필수 입니다.")
    private String name;    // javax validation을 통해서 spring이 값이 비어있으면 오류 띄워줌

    private String city;

    private String street;

    private String zipcode;
}
