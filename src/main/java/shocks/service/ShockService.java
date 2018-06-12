package shocks.service;

import shocks.model.ShockAbsorber;
import shocks.model.ShockAbsorberRev;
import shocks.model.ShockFilter;

import java.util.List;

public interface ShockService {
    List<ShockAbsorber> getShocks(ShockFilter shockFilter);

    ShockAbsorberRev getShock(String partNo);
}
