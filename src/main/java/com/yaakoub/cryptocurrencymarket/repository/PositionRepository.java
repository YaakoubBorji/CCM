package com.yaakoub.cryptocurrencymarket.repository;

import com.yaakoub.cryptocurrencymarket.model.Position;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position,Long> {

//    public Position findPosition(Long id);

    public Position save(Position position);

//    public void deletePositionByPositionId(Long id);

//    @Modifying(clearAutomatically = true)
//    @Query("")
//    public void buyPositionById(Integer id);
}
