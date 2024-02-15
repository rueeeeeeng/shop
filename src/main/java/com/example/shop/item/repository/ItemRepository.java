package com.example.shop.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.example.shop.item.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>,
			QuerydslPredicateExecutor<Item>{
	
	List<Item> findByItemNm(String ItemNm);
	
	List<Item> findByItemNmOrItemDetail(String itemnm, String itemDetail);
	
	//Item이라고 class명을 적어줘야함
	@Query("select i from Item i where i.itemDetail like %:itemDetail% "
			+ "order by i.price asc")
	List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);
	
	//item이라고 디비에 있는 테이블명을 적어줘야함(native는 순수하게 테이블만을 바라보기 때문에
	//itemDetail이 아닌 디비에 있는대로 item_detail이라고 적어줘야함
	@Query(value = "select * from item i where i.item_detail like %:itemDetail% "
			+ "order by i.price asc", nativeQuery = true)
	List<Item> findByItemDetailNative(@Param("itemDetail") String itemDetail);
}
