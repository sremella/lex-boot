package com.kubra.stitch.service;

import com.kubra.stitch.model.Utterance;

import java.util.List;

public interface UtteranceService {
    public Utterance create(Utterance utterance);
    public Utterance getById(Long id);
    public Utterance update(Long id, Utterance newUtterance);
    public void delete(Long id);
    public List<Utterance> getAll();
}
