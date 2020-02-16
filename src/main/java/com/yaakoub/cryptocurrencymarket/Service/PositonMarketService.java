package com.yaakoub.cryptocurrencymarket.Service;

import com.yaakoub.cryptocurrencymarket.model.Position;
import com.yaakoub.cryptocurrencymarket.repository.PositionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PositonMarketService {

    private static final Logger log = LoggerFactory.getLogger(PositonMarketService.class);

    @Autowired
    PositionRepository positionRepository;

    public Position findPostionMarketById(Long id){
        return positionRepository.findById(id).orElse(null);
    }

    public Position createPosition(Position position){
        return positionRepository.save(position);
    }

    public void deletePositionById(Long positionId){
            positionRepository.deleteById(positionId);
    }

    public void buyPositionById(Long idPosition){
        positionRepository.updateStatusPositionById(idPosition);
    }
}
