package shocks.service;

import shocks.model.ShockFilter;

public interface ShockFilterService {
    void populateFilters(ShockFilter filterKeep);

    void processInput(ShockFilter keeper);
}
