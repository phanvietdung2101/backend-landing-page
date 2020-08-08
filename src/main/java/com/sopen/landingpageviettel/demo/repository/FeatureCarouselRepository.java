package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.FeatureCarousel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureCarouselRepository extends JpaRepository<FeatureCarousel, Long> {
}
