package com.likelion.seorang.letter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LetterDto {

    private Long id;

    private String content;

    private Integer background;

    public LetterDto(LetterEntity letterEntity){
        this.id = letterEntity.getId();
        this.content = letterEntity.getContent();
        this.background = letterEntity.getBackground();
    }

    public LetterDto() {

    }
}
