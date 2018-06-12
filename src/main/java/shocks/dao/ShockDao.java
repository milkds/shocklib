package shocks.dao;

import shocks.model.ShockAbsorber;
import shocks.model.ShockFilter;

import java.util.List;

public interface ShockDao {
    List<ShockAbsorber> getShocks(ShockFilter shockFilter);
}
