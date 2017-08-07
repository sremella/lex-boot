package com.kubra.stitch.service;

import com.kubra.stitch.model.Intent;

import java.util.List;

public interface IntentService {
    public Intent create(Intent intent);
    public Intent getById(Long id);
    public Intent update(Long id, Intent newIntent);
    public void delete(Long id);
    public List<Intent> getAll();
}
