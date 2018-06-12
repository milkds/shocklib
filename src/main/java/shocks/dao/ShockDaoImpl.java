package shocks.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import shocks.model.ShockAbsorber;
import shocks.model.ShockAbsorberRev;
import shocks.model.ShockFilter;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ShockDaoImpl implements ShockDao {
    private SessionFactory sessionFactory;

    private static final Logger logger = LogManager.getLogger(ShockDaoImpl.class.getName());

    @Override
    public List<ShockAbsorber> getShocks(ShockFilter shockFilter) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ShockAbsorber>query=builder.createQuery(ShockAbsorber.class);
        Root<ShockAbsorber> root = query.from(ShockAbsorber.class);
        List<Predicate> predicates = getPredicates(shockFilter,builder,root);
        if (predicates.size()==1){
            query.where(predicates.get(0));
        }
        else {
            Predicate[] preds = predicates.toArray(new Predicate[0]);
            query.where(builder.and(preds));
        }
        Query q = session.createQuery(query);
        List<ShockAbsorber> shocks = q.getResultList();
        for (ShockAbsorber absorber:shocks){
            logger.info(absorber);
        }

        return shocks;
    }

    @Override
    public ShockAbsorberRev getShock(String partNo) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ShockAbsorberRev>query=builder.createQuery(ShockAbsorberRev.class);
        Root<ShockAbsorberRev> root = query.from(ShockAbsorberRev.class);
        query.where(builder.equal(root.get("partNo"),partNo));
        Query q = session.createQuery(query);
        ShockAbsorberRev shock = (ShockAbsorberRev)q.getSingleResult();
        logger.info(shock);

        return shock;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private List<Predicate> getPredicates(ShockFilter filterKeep, CriteriaBuilder builder, Root<ShockAbsorber> root){
        List<Predicate> predicates = new ArrayList<>();
        String shockMake = filterKeep.getShockMake();
        String colLength = filterKeep.getCoLength();
        String extLength = filterKeep.getExtLength();
        String upMount = filterKeep.getUpMount();
        String lowMount = filterKeep.getLowMount();
        if (shockMake!=null&&shockMake.length()>0){
            predicates.add(builder.equal(root.get("shockMake"),shockMake));
        }
        if (colLength!=null&&colLength.length()>0){
            predicates.add(builder.equal(root.get("colLength"),colLength));
        }
        if (extLength!=null&&extLength.length()>0){
            predicates.add(builder.equal(root.get("extLength"),extLength));
        }
        if (upMount!=null&&upMount.length()>0){
            predicates.add(builder.equal(root.get("upMount"),upMount));
        }
        if (lowMount!=null&&lowMount.length()>0){
            predicates.add(builder.equal(root.get("lowMount"),lowMount));
        }

        return predicates;
    }
}
