package com.shop.ShopProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="cart")
@Getter
@Setter
@ToString
public class Cart {

    @Id
    @Column(name = "cart")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name="member_id")
    private Member member;



}
