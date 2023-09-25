package com.nicoz.NZWanderlust.Repositories;

import com.nicoz.NZWanderlust.Entities.ReputationScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReputationScoreRepository extends JpaRepository<ReputationScore, Long> {

}
