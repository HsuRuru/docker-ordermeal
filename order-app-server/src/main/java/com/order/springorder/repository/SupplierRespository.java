package com.order.springorder.repository;

import com.order.springorder.model.MerryOrderSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface SupplierRespository extends JpaRepository<MerryOrderSupplier,Long> {

    List<MerryOrderSupplier> findAllByStatusAndOrg(Boolean status,String org);

    List<MerryOrderSupplier> findAllByStatusAndOrgAndSuppNameContaining(Boolean status,String org,String suppName);

    List<MerryOrderSupplier> findAllByStatusAndSuppId(Boolean status,Long supplierId);

    @Modifying
    @Transactional
    void deleteAllBySuppId(Long id);

    MerryOrderSupplier findBySuppId(Long suppId);

}
