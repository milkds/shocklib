package shocks.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shocks.dao.ShockDao;
import shocks.model.ShockAbsorber;
import shocks.model.ShockAbsorberRev;
import shocks.model.ShockFilter;

import java.util.Arrays;
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
        for (ShockAbsorber shock: absorbers){
            String imgUrl = shock.getImgLink();
            if (imgUrl!=null&&imgUrl.length()>0){
                String split[] = imgUrl.split("\n");
                List<String> imgs = Arrays.asList(split);
                shock.setImgLink(imgs.get(0));
            }
        }

        return absorbers;
    }

    @Transactional
    public ShockAbsorberRev getShock(String partNo) {
        ShockAbsorberRev shock = shockDao.getShock(partNo);
        String imgUrl = shock.getImgLink();
        if (imgUrl!=null&&imgUrl.length()>0){
            String split[] = imgUrl.split("\n");
            List<String> imgs = Arrays.asList(split);
            shock.setImgLink(imgs.get(0));
            shock.setImgLinks(imgs);
        }

        return this.shockDao.getShock(partNo);
    }
}
