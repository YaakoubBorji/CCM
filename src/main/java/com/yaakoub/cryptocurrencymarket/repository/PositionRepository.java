package com.yaakoub.cryptocurrencymarket.repository;

import com.yaakoub.cryptocurrencymarket.model.Position;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PositionRepository extends CrudRepository<Position,Long> {


    public Position save(Position position);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Position p SET p.status = 1 WHERE p.id = :positionId")
    public void updateStatusPositionById(@Param("positionId") Long positionId);


    public List<Position> findAllByStatus(Position.StatusEnum status);

    public Position findPositionById(Long positionId);
}
