package th.ac.mahidol.ict.gemini6.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.mahidol.ict.gemini6.Model.SciencePlan;

public interface SciencePlanRepository extends JpaRepository<SciencePlan, String> {
    // JpaRepository provides built-in methods like save(), findById(), findAll(), and deleteById()
    // You can also add custom queries here if needed.
}
