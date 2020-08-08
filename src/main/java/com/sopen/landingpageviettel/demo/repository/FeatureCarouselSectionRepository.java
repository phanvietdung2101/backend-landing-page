package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.FeatureCarousel;
import com.sopen.landingpageviettel.demo.models.FeatureCarouselSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureCarouselSectionRepository extends JpaRepository<FeatureCarouselSection, Long> {
    FeatureCarouselSection findTopByOrderByIdDesc();
}
