package shocks.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shocks.dao.ShockDao;
import shocks.model.ShockAbsorber;
import shocks.model.ShockFilter;

import java.util.List;

@Service
public class ShockServiceImpl implements ShockService {
    private ShockDao shockDao;

    public void setShockDao(ShockDao shockDao) {
        this.shockDao = shockDao;
    }

    @Transactional
    public List<ShockAbsorber> getShocks(ShockFilter shockFilter) {
        List<ShockAbsorber> absorbers = this.shockDao.getShocks(shockFilter);

        return absorbers;
    }
}
