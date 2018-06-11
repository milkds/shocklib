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


    //this it for case, when user removes his previous choice
    private void checkFilterForDrop(ShockFilter filterKeep){
        String shockMake = filterKeep.getShockMake();
        String colLength = filterKeep.getCoLength();
        String extLength = filterKeep.getExtLength();
        String upMount = filterKeep.getUpMount();
        String lowMount = filterKeep.getLowMount();

        if (shockMake!=null){
            if (shockMake.equals("--- Select ---")){
                filterKeep.setShockMake(null);
            }
        }
        if (colLength!=null){
            if (colLength.equals("--- Select ---")){
                filterKeep.setCoLength(null);
            }
        }
        if (extLength!=null){
            if (extLength.equals("--- Select ---")){
                filterKeep.setExtLength(null);
            }
        }
        if (upMount!=null){
            if (upMount.equals("--- Select ---")){
                filterKeep.setUpMount(null);
            }
        }
        if (lowMount!=null){
            if (lowMount.equals("--- Select ---")){
                filterKeep.setLowMount(null);
            }
        }
    }

    private void checkIfReadyForFilter(ShockFilter filterKeep){
        String colLength = filterKeep.getCoLength();
        String extLength = filterKeep.getExtLength();
        String upMount = filterKeep.getUpMount();
        String lowMount = filterKeep.getLowMount();
        if (colLength!=null&&colLength.length()>0){
            filterKeep.setReadyForFilter(true);
            return;
        }
        if (extLength!=null&&extLength.length()>0){
            filterKeep.setReadyForFilter(true);
            return;
        }
        if (upMount!=null&&upMount.length()>0){
            filterKeep.setReadyForFilter(true);
            return;
        }
        if (lowMount!=null&&lowMount.length()>0){
            filterKeep.setReadyForFilter(true);
        }
    }
}
