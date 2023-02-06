package com.git.studygittmp.controller;

import com.git.studygittmp.data.dto.ChangeOnikesumNameDto;
import com.git.studygittmp.data.dto.OnikesumDto;
import com.git.studygittmp.data.dto.OnikesumResponseDto;
import com.git.studygittmp.service.OnikesumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Onikesum")
public class OnikesumController {
    private final OnikesumService onikesumService;

    @Autowired
    public OnikesumController(OnikesumService onikesumService){
        this.onikesumService = onikesumService;

    }

    @GetMapping()
    public ResponseEntity<OnikesumResponseDto> getOnikesum(Long number){
        OnikesumResponseDto OnikesumResponseDto = onikesumService.getOnikesum(number);
        return ResponseEntity.status(HttpStatus.OK).body(OnikesumResponseDto);
    }
    @PostMapping()
    public ResponseEntity<OnikesumResponseDto> createOnikesum(@RequestBody OnikesumDto onikesumDto){
        OnikesumResponseDto OnikesumResponseDto = onikesumService.saveOnikesum(onikesumDto);
        return ResponseEntity.status(HttpStatus.OK).body(OnikesumResponseDto);
    }

    @PutMapping()
    public ResponseEntity<OnikesumResponseDto> changeOnikesumName(
            @RequestBody ChangeOnikesumNameDto changeOnikesumNameDto) throws Exception{
        OnikesumResponseDto onikesumResponseDto = onikesumService.changeOnikesum(
                changeOnikesumNameDto.getNumber(),
                changeOnikesumNameDto.getName());
        return ResponseEntity.status(HttpStatus.OK).body(onikesumResponseDto);
    }
    @DeleteMapping()
    public ResponseEntity<String> deleteOnikesum(Long number) throws Exception{
        onikesumService.deleteOnikesum(number);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}

}
