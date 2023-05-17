package com.likelion.seorang.letter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LetterDto {

    private Long id;

    private String content;

    public LetterDto(LetterEntity letterEntity){
        this.id = letterEntity.getId();
        this.content = letterEntity.getContent();
    }

    public LetterDto() {

    }
}
