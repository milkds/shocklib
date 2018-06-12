package shocks.dao;

import shocks.model.ShockAbsorber;
import shocks.model.ShockAbsorberRev;
import shocks.model.ShockFilter;

import java.util.List;

public interface ShockDao {
    List<ShockAbsorber> getShocks(ShockFilter shockFilter);

    ShockAbsorberRev getShock(String partNo);
}
