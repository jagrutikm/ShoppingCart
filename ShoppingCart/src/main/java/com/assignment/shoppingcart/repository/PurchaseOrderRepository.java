package com.assignment.shoppingcart.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


import com.assignment.shoppingcart.model.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Integer> {
	 Optional<PurchaseOrder>  findBycartId(int cartid);
}
