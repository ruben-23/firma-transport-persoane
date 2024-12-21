package com.firma.transport_persoane.controller;

import com.firma.transport_persoane.dto.FeedbackDTO;
import com.firma.transport_persoane.entity.Feedback;
import com.firma.transport_persoane.mapper.FeedbackMapper;
import com.firma.transport_persoane.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("firma/feedbackuri")
public class FeedbackController {

    private final FeedbackService feedbackService;
    private final FeedbackMapper feedbackMapper;

    @Autowired
    public FeedbackController(FeedbackService feedbackService, FeedbackMapper feedbackMapper) {
        this.feedbackService = feedbackService;
        this.feedbackMapper = feedbackMapper;
    }

    @GetMapping
    public ResponseEntity<List<FeedbackDTO>> getAllFeedbackuri() {
        List<Feedback> feedbackuri = feedbackService.getAllFeedbackuri();
        return ResponseEntity.ok(feedbackMapper.toDTOList(feedbackuri));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackDTO> getFeedbackById(@PathVariable Integer id) {
        Feedback feedback = feedbackService.getFeedbackById(id);
        return ResponseEntity.ok(feedbackMapper.toDTO(feedback));
    }

    @PostMapping
    public ResponseEntity<FeedbackDTO> adaugaFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        Feedback feedback = feedbackService.adaugaFeedback(feedbackDTO);
        return ResponseEntity.ok(feedbackMapper.toDTO(feedback));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedbackDTO> actualizareFeedback(@PathVariable Integer id, @RequestBody FeedbackDTO feedbackDTO) {
        feedbackDTO.setIdFeedback(id);
        Feedback feedback = feedbackService.actualizareFeedback(id, feedbackDTO);
        return ResponseEntity.ok(feedbackMapper.toDTO(feedback));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> stergeFeedback(@PathVariable Integer id) {
        feedbackService.stergeFeedback(id);
        return ResponseEntity.noContent().build();
    }
}