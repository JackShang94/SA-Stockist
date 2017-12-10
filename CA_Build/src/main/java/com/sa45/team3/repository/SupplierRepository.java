/*package com.sa45.team3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sa45.team3.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}*/


package com.sa45.team3.repository;



import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;*/
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sa45.team3.model.Supplier;


public interface SupplierRepository extends JpaRepository<Supplier, Integer>{

	/*@Query
	("SELECT s FROM Supplier s where s.supplierID = :supplierID")
	Supplier findSupplierById(@Param("supplierID") Integer supplierID);*/

	/*@Query("SELECT s FROM Suppliers s where s.supplierName = :supplierName")
	Supplier findSupplierByName(@Param("supplierName") String supplierName);
	
	@Query("SELECT s FROM Suppliers s where s.contactNumber = :contactNumber")
	Supplier findSupplierByContactNumber(@Param("contactNumber") Integer contactNumber);
	
	@Query("SELECT s FROM Suppliers s where s.address = :address")
	Supplier findSupplierByAddress(@Param("address") String address);
	
	@Query("SELECT s FROM Suppliers s where s.contactPerson = :contactPerson")
	Supplier findSupplierByContactPerson(@Param("contactPerson") String contactPerson);*/


}
