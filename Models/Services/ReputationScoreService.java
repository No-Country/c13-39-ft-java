package com.woderlust.services;

import com.woderlust.NewReputationScoreRequest;
import com.woderlust.entities.ReputationScore;
import com.woderlust.repository.IReputationScoreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReputationScoreService {
    private final IReputationScoreRepository reputationScoreRepository;

    public ReputationScoreService(IReputationScoreRepository reputationScoreRepository) {
        this.reputationScoreRepository = reputationScoreRepository;
    }

    public List<ReputationScore> getReputationScore(){
        return reputationScoreRepository.findAll();
    }

    public ReputationScore get(Long id){
        return reputationScoreRepository.findById(id).get();
    }

    public void addReputationScore(NewReputationScoreRequest newReputationScoreRequest){
        ReputationScore reputationScore = new ReputationScore();
        reputationScore.setUserIdReputation(newReputationScoreRequest.getUserIdReputation());
        reputationScore.setScore(newReputationScoreRequest.getScore());
        reputationScoreRepository.save(reputationScore);
    }

    public ResponseEntity<ReputationScore> updateReputationScore(Long id, ReputationScore reputationScoreDetails){
        Optional<ReputationScore> optionalReputationScore = reputationScoreRepository.findById(id);
        if(!optionalReputationScore.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ReputationScore reputationScore = optionalReputationScore.get();
        reputationScore.setUserIdReputation(reputationScoreDetails.getUserIdReputation());
        reputationScore.setScore(reputationScoreDetails.getScore());
        ReputationScore updateReputationScore = reputationScoreRepository.save(reputationScore);
        return new ResponseEntity<>(updateReputationScore, HttpStatus.OK);
    }

    public void delete(Long id){ reputationScoreRepository.deleteById(id); }
}