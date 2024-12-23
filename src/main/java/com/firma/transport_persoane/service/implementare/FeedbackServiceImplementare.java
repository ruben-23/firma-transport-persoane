package com.firma.transport_persoane.service .implementare;

import com.firma.transport_persoane.dto.FeedbackDTO;
import com.firma.transport_persoane.entity.Feedback;
import com.firma.transport_persoane.entity.Firma;
import com.firma.transport_persoane.mapper.FeedbackMapper;
import com.firma.transport_persoane.repository.FeedbackRepository;
import com.firma.transport_persoane.service.FeedbackService;
import com.firma.transport_persoane.service.FirmaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImplementare implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final FeedbackMapper feedbackMapper;
    private final FirmaService firmaService;

    @Autowired
    public FeedbackServiceImplementare(FeedbackRepository feedbackRepository, FeedbackMapper feedbackMapper, FirmaService firmaService) {
        this.feedbackRepository = feedbackRepository;
        this.feedbackMapper = feedbackMapper;
        this.firmaService = firmaService;
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
        Firma firma = firmaService.getFirmaById(feedbackDTO.getIdFirma());
        Feedback feedback = feedbackMapper.toEntity(feedbackDTO, firma);
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