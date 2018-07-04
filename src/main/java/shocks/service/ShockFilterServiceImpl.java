package shocks.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shocks.dao.ShockFilterDao;
import shocks.model.ShockFilter;

@Service
public class ShockFilterServiceImpl implements ShockFilterService {

    private ShockFilterDao shockFilterDao;

    public void setShockFilterDao(ShockFilterDao shockFilterDao) {
        this.shockFilterDao = shockFilterDao;
    }

    @Transactional
    public void populateFilters(ShockFilter filterKeep) {
        checkFilterForDrop(filterKeep);
        checkIfReadyForFilter(filterKeep);
        this.shockFilterDao.populateFilters(filterKeep);
    }

    @Override
    public void processInput(ShockFilter keeper) {
        System.out.println("input processed");
    }


    //this it for case, when user removes his previous choice
    private void checkFilterForDrop(ShockFilter filterKeep){
        String nullInput = "--- Select ---";
        String shockMake = filterKeep.getShockMake();
        String upMount = filterKeep.getUpMount();
        String lowMount = filterKeep.getLowMount();

        if (shockMake!=null){
            if (shockMake.equals(nullInput)){
                filterKeep.setShockMake(null);
            }
        }
        if (upMount!=null){
            if (upMount.equals(nullInput)){
                filterKeep.setUpMount(null);
            }
        }
        if (lowMount!=null){
            if (lowMount.equals(nullInput)){
                filterKeep.setLowMount(null);
            }
        }
    }

    private void checkIfReadyForFilter(ShockFilter filterKeep){
        String upMount = filterKeep.getUpMount();
        String lowMount = filterKeep.getLowMount();
        if (upMount!=null&&upMount.length()>0){
            filterKeep.setReadyForFilter(true);
            return;
        }
        if (lowMount!=null&&lowMount.length()>0){
            filterKeep.setReadyForFilter(true);
        }
    }
}
