package com.firma.transport_persoane.service .implementare;

import com.firma.transport_persoane.dto.FeedbackDTO;
import com.firma.transport_persoane.entity.Feedback;
import com.firma.transport_persoane.mapper.FeedbackMapper;
import com.firma.transport_persoane.repository.FeedbackRepository;
import com.firma.transport_persoane.service.FeedbackService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImplementare implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final FeedbackMapper feedbackMapper;

    @Autowired
    public FeedbackServiceImplementare(FeedbackRepository feedbackRepository, FeedbackMapper feedbackMapper) {
        this.feedbackRepository = feedbackRepository;
        this.feedbackMapper = feedbackMapper;
    }

    @Override
    public List<Feedback> getAllFeedbackuri() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback getFeedbackById(Integer id) {
        return feedbackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback nu a fost gasit"));
    }

    @Transactional
    @Override
    public Feedback adaugaFeedback(FeedbackDTO feedbackDTO) {
        Feedback feedback = feedbackMapper.toEntity(feedbackDTO);
        return feedbackRepository.save(feedback);
    }

    @Transactional
    @Override
    public Feedback actualizareFeedback(Integer id, FeedbackDTO feedbackDTO) {
        Feedback feedbackActual = getFeedbackById(id);
        feedbackMapper.updateEntityFromDTO(feedbackDTO, feedbackActual);
        return feedbackRepository.save(feedbackActual);
    }

    @Override
    public void stergeFeedback(Integer id) {
        feedbackRepository.delete(getFeedbackById(id));
    }
}