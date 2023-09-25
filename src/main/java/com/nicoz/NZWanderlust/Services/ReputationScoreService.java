package com.nicoz.NZWanderlust.Services;

import com.nicoz.NZWanderlust.Entities.ReputationScore;
import com.nicoz.NZWanderlust.Repositories.ReputationScoreRepository;
import com.nicoz.NZWanderlust.NewReputationScoreRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReputationScoreService {
    private final ReputationScoreRepository reputationScoreRepository;

    public ReputationScoreService(ReputationScoreRepository reputationScoreRepository) {
        this.reputationScoreRepository = reputationScoreRepository;
    }

    public List<ReputationScore> getReputationScore() {
        return reputationScoreRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ReputationScore getReputationScoreById(Long id) {
        return reputationScoreRepository.findById(id).get();
    }

    public void addReputationScore(NewReputationScoreRequest newReputationScoreRequest) {
        ReputationScore reputationScore = new ReputationScore();
        reputationScore.setScore(newReputationScoreRequest.getScore());
        reputationScoreRepository.save(reputationScore);
    }

    public ResponseEntity<ReputationScore> updateReputationScore(Long id, ReputationScore reputationScoreDetails) {
        Optional<ReputationScore> optionalReputationScore = reputationScoreRepository.findById(id);
        if (!optionalReputationScore.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ReputationScore reputationScore = optionalReputationScore.get();
        //reputationScore.setUser(reputationScoreDetails.getUser());
        reputationScore.setScore(reputationScoreDetails.getScore());
        ReputationScore updateReputationScore = reputationScoreRepository.save(reputationScore);
        return new ResponseEntity<>(updateReputationScore, HttpStatus.OK);
    }

    public void delete(Long id) {
        reputationScoreRepository.deleteById(id);
    }
}
