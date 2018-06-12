package shocks.service;

import shocks.model.ShockAbsorber;
import shocks.model.ShockFilter;

import java.util.List;

public interface ShockService {
    List<ShockAbsorber> getShocks(ShockFilter shockFilter);
}
