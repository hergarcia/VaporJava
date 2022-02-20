package com.company.objects;

import java.util.Date;

public class Purchase {

    private User buyer;
    private Game game;
    private Double price;
    private Date date;
    private Integer purchase_id;

    public Purchase(User buyer, Game game, Double price, Date date, Integer purchase_id) {
        this.buyer = buyer;
        this.game = game;
        this.price = price;
        this.date = date;
        this.purchase_id = purchase_id;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(Integer id) {
        this.purchase_id = id;
    }
}
