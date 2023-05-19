package com.likelion.seorang.letter;

import java.util.List;

public class LetterListReturn {
    private List<LetterEntity> letters;
    private int total;

    public LetterListReturn(List<LetterEntity> letters, int total) {
        this.letters = letters;
        this.total = total;
    }

    public List<LetterEntity> getLetters() {
        return letters;
    }

    public int getTotal() {
        return total;
    }
}
