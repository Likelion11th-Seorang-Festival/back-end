package com.likelion.seorang.letter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class LetterService {

    private LetterRepository letterRepository;

    // 저장
    @Transactional
    public Long saveLetter(LetterDto letterDto) {

        LetterEntity letter = LetterEntity.builder()
                .content(letterDto.getContent())
                .background(letterDto.getBackground())
                .build();

        letterRepository.save(letter);

        return letter.getId();
    }

    // 목록 조회
    @Transactional(readOnly = true)
    public List<LetterEntity> getList() {
        return letterRepository.findAllByOrderByIdDesc();
    }

    // 1개 조회 - id
    @Transactional(readOnly = true)
    public LetterDto getLetter(Long id) {
        LetterEntity letter = letterRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        LetterDto letterDto = new LetterDto();
        letterDto.setId(letter.getId());
        letterDto.setContent(letter.getContent());
        letterDto.setBackground(letter.getBackground());
        return letterDto;
    }

}
