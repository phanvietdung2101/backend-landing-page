package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.FeatureCarousel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureCarouselRepository extends CrudRepository<FeatureCarousel, Long> {
}
