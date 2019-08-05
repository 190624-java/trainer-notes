package com.revature.soap.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.soap.beans.Parcel;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Integer>{

}
