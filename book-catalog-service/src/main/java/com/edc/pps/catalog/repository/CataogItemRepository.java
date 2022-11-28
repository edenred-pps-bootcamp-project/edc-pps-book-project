package com.edc.pps.catalog.repository;

import com.edc.pps.catalog.dto.CatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CataogItemRepository extends JpaRepository<CatalogItem, Long> {

}
