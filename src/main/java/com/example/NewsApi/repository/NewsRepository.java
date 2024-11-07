package com.example.NewsApi.repository;


import com.example.NewsApi.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface NewsRepository extends JpaRepository<News,UUID > {
    List<News> findByPublishDate(Date publishDate);

    @Query("SELECT n FROM News n JOIN n.cities c WHERE c.id = :cityId")
    List<News> findByCityId(@Param("cityId") UUID cityId);

    @Query("SELECT n FROM News n JOIN n.states s WHERE s.id = :stateId")
    List<News> findByStateId(@Param("stateId") UUID stateId);

    List<News> findByGlobalNews(boolean globalNews);


}
