package com.firma.transport_persoane.service;

import com.firma.transport_persoane.dto.FeedbackDTO;
import com.firma.transport_persoane.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> getAllFeedbackuri();
    Feedback getFeedbackById(Integer id);
    Feedback adaugaFeedback(FeedbackDTO feedbackDTO);
    Feedback actualizareFeedback(Integer id, FeedbackDTO feedbackDTO);
    void stergeFeedback(Integer id);
}