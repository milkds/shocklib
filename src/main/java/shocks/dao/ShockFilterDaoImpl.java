package shocks.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import shocks.model.ShockFilter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ShockFilterDaoImpl implements ShockFilterDao {
    private SessionFactory sessionFactory;
    private static final Logger logger = LogManager.getLogger(ShockFilterDaoImpl.class.getName());


    @Override
    public void populateFilters(ShockFilter filterKeep) {
        filterKeep.setShockMakes(getDataForFilter(filterKeep,"SHOCK_MAKE"));
        filterKeep.setCoLengths(getDataForFilter(filterKeep,"COLLAPSED_LENGTH"));
        filterKeep.setExtLengths(getDataForFilter(filterKeep,"EXTENDED_LENGTH"));
        filterKeep.setUpMounts(getDataForFilter(filterKeep,"UPPER_MOUNTING"));
        filterKeep.setLowMounts(getDataForFilter(filterKeep,"LOWER_MOUNTING"));
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private List<String> getDataForFilter(ShockFilter filterKeep, String colName){
        List<String> data;
        Session session = sessionFactory.getCurrentSession();
        String queryString = buildQueryString(filterKeep);
        queryString = String.format(queryString,colName, colName);
        logger.info("prepared query string: "+queryString);
        Query query = session.createNativeQuery(queryString);
        data= query.list();
        data.add(0,"--- Select ---");
        logger.info(Arrays.toString(data.toArray()));

        return data;
    }

    private String buildQueryString(ShockFilter filterKeep){
        StringBuilder sb = new StringBuilder();
        Boolean hasFilters = false;
        sb.append("SELECT distinct %s FROM shock_abs.shocks");
        String shockMake = filterKeep.getShockMake();
        hasFilters = addFilterInfo(sb,hasFilters,"SHOCK_MAKE", shockMake);
        String coLength = filterKeep.getCoLength();
        hasFilters = addFilterInfo(sb,hasFilters, "COLLAPSED_LENGTH", coLength);
        String extLength = filterKeep.getExtLength();
        hasFilters = addFilterInfo(sb,hasFilters, "EXTENDED_LENGTH", extLength);
        String upMount = filterKeep.getUpMount();
        hasFilters = addFilterInfo(sb,hasFilters, "UPPER_MOUNTING", upMount);
        String lowMount = filterKeep.getLowMount();
        addFilterInfo(sb, hasFilters, "LOWER_MOUNTING", lowMount);
        sb.append(" order by %s asc");

        return sb.toString();
    }

    private Boolean addFilterInfo(StringBuilder prev, Boolean hasFilters, String colName, String colValue ){
        if (colValue!=null&&colValue.length()!=0){
            if (!hasFilters){
                prev.append(" where ");
                hasFilters = true;
            }
            else {
                prev.append(" and ");
            }
            prev.append(colName);
            prev.append(" = '");
            prev.append(colValue);
            prev.append("'");
        }

        return hasFilters;
    }
}
