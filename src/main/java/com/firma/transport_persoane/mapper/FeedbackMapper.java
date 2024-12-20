package com.firma.transport_persoane.mapper;

import com.firma.transport_persoane.dto.FeedbackDTO;
import com.firma.transport_persoane.entity.Feedback;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FeedbackMapper {

    public FeedbackDTO toDTO(Feedback feedback) {
        if (feedback == null) {
            return null;
        }
        FeedbackDTO dto = new FeedbackDTO();
        dto.setIdFeedback(feedback.getIdFeedback());
        dto.setTip(feedback.getTip());
        dto.setTimpTrimitere(feedback.getTimpTrimitere());
        dto.setMesaj(feedback.getMesaj());
        dto.setIdFirma(feedback.getFirma().getIdFirma());

        return dto;
    }

    public List<FeedbackDTO> toDTOList(List<Feedback> feedbackuri) {
        List<FeedbackDTO> feedbackDTOs = new ArrayList<>();
        for (Feedback feedback : feedbackuri) {
            feedbackDTOs.add(toDTO(feedback));
        }
        return feedbackDTOs;
    }

    public Feedback toEntity(FeedbackDTO feedbackDTO) {
        if (feedbackDTO == null) {
            return null;
        }
        Feedback feedback = new Feedback();
        feedback.setIdFeedback(feedbackDTO.getIdFeedback());
        feedback.setTip(feedbackDTO.getTip());
        feedback.setTimpTrimitere(feedbackDTO.getTimpTrimitere());
        feedback.setMesaj(feedbackDTO.getMesaj());

        return feedback;
    }

    public void updateEntityFromDTO(FeedbackDTO feedbackDTO, Feedback feedback) {
        if (feedbackDTO != null && feedback != null) {
            feedback.setTip(feedbackDTO.getTip());
            feedback.setTimpTrimitere(feedbackDTO.getTimpTrimitere());
            feedback.setMesaj(feedbackDTO.getMesaj());
        }
    }
}