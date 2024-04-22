package com.shop.ShopProject.repository;

import com.shop.ShopProject.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
