package com.likelion.seorang.letter;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class LetterController {

    public LetterService letterService;
    public LetterRepository letterRepository;


//    @GetMapping("/api/letter")
//    public ResponseEntity<List<LetterEntity>> getLetters() {
//        List<LetterEntity> letterEntities = letterService.getList();
//        return ResponseEntity.status(HttpStatus.OK).body(letterEntities);
//    }

    @GetMapping("/api/letter")
    public ResponseEntity<LetterListReturn> getLetters() {
        List<LetterEntity> letterEntities = letterService.getList();
        int count = letterEntities.size();

        LetterListReturn response = new LetterListReturn(letterEntities, count);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PostMapping("/api/letter/write")
    public ResponseEntity<LetterEntity> createLetter(@RequestBody LetterDto letterDto) {
        Long letterId = letterService.saveLetter(letterDto);
        LetterEntity letter = letterRepository.findById(letterId).orElseThrow(EntityNotFoundException::new);
        return ResponseEntity.ok(letter);
    }

    @GetMapping("/api/letter/{id}")
    public ResponseEntity<LetterDto> getLetterDtl(@PathVariable("id") Long id) {
        LetterDto letterDto = letterService.getLetter(id);
        return ResponseEntity.status(HttpStatus.OK).body(letterDto);
    }

}
