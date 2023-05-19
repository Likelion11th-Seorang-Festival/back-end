package com.likelion.seorang.letter;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "letter")
@Getter @Setter
@ToString
@NoArgsConstructor
public class LetterEntity {

    // id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "letter_id")
    private Long id;

    // 글
    @Lob
    @Column(nullable = false)
    private String content;

    @Builder
    public LetterEntity(Long id, String content) {
        this.id = id;
        this.content = content;
    }

}
