package shocks.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import shocks.model.ShockFilter;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShockFilterDaoMockImpl implements ShockFilterDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void populateFilters(ShockFilter filterKeep) {
         List<String> shockMakes = new ArrayList<>();
         List<String> coLengths = new ArrayList<>();
         List<String> extLengths = new ArrayList<>();
         List<String> upMounts = new ArrayList<>();
         List<String> lowMounts = new ArrayList<>();


         shockMakes.add("--- Select ---");
         shockMakes.add("Bilstein");
         shockMakes.add("Fox Shocks");
         shockMakes.add("Skyjacker");

         coLengths.add("20");
         coLengths.add("30");
         coLengths.add("40");

         extLengths.add("30");
         extLengths.add("40");
         extLengths.add("50");

         upMounts.add("S1");
         upMounts.add("EB7");
         upMounts.add("ES34");

         lowMounts.add("BP4");
         lowMounts.add("EP4");
         lowMounts.add("ES34");

         filterKeep.setShockMakes(shockMakes);
         filterKeep.setCoLengths(coLengths);
         filterKeep.setExtLengths(extLengths);
         filterKeep.setUpMounts(upMounts);
         filterKeep.setLowMounts(lowMounts);
    }
}
