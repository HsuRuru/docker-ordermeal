package com.order.springorder.service;

import com.order.springorder.model.MerryOrderSupplier;
import com.order.springorder.repository.SupplierRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.lang.System.*;

@Service
public class SupplierService {

    @Autowired
    SupplierRespository respository;



    public List<MerryOrderSupplier> getSupplier(String orgId){
        out.println("getSu"+orgId);
        return respository.findAllByStatusAndOrg(true,orgId);
    }

    public List<MerryOrderSupplier> getSuppByCondi(String orgId,String suppName){
        return respository.findAllByStatusAndOrgAndSuppNameContaining(true,orgId,suppName);
    }

    public List<MerryOrderSupplier> getSupplierBySuppId(Long suppId){
        return respository.findAllByStatusAndSuppId(true,suppId);
    }

    public void addMerryOrderSupplier(MerryOrderSupplier supplier){
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        supplier.setCreateDate(Timestamp.valueOf(sdf.format(date)));
        respository.save(supplier);
    }

    public void deletSupplierById(Long id){
        respository.deleteAllBySuppId(id);
    }


    public void putSupplier(MerryOrderSupplier input){
        out.println("MerryOrderSupplier"+input.getSuppId());
        MerryOrderSupplier supplier = respository.findBySuppId(input.getSuppId());

        supplier.setSuppName(input.getSuppName());
        supplier.setTel(input.getTel());
        supplier.setFax(input.getFax());
        supplier.setAddress(input.getAddress());
        supplier.setOrg(input.getOrg());
        supplier.setStatus(input.getStatus());
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        supplier.setUpdateDate(Timestamp.valueOf(sdf.format(date)));
        supplier.setUpdatePerson(supplier.getUpdatePerson());

        respository.save(supplier);
    }

}
