package com.likelion.seorang.letter;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LetterRepository extends JpaRepository<LetterEntity, Long> {

    List<LetterEntity> findAllByOrderByIdDesc();

}
