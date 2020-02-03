package com.yaakoub.cryptocurrencymarket.Service;

import com.yaakoub.cryptocurrencymarket.model.Position;
import com.yaakoub.cryptocurrencymarket.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PositonMarketService {

    @Autowired
    PositionRepository positionRepository;

    public Position findPostionMarketById(Long id){
        return positionRepository.findById(id).get();
    }

    public Position createPosition(Position position){
        return positionRepository.save(position);
    }

//    public boolean deletePositionById(Long positionId){
//         positionRepository.deletePositionByPositionId(positionId);
//         return true;
//    }


}
