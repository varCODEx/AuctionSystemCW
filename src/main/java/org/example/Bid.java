package org.example;

import java.io.Serializable;

public class Bid implements Serializable {
    User bidder;
    int price;

    public Bid(User bidder, int price) {
        this.bidder = bidder;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "bidder=" + bidder +
                ", price=" + price +
                '}';
    }
}
