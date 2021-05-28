package org.example;

import java.io.Serializable;

public class Lot implements Serializable {
    enum status {
        DELETED,
        EMPTY,
        CREATED,
        PLACED,
        STOPPED,
    }

    private int startPrice;
    private status lotStatus;
    User owner;
    private String name, description;
    private int id;
    private String link = "";
    Bid lastBid;

    public void makeBid(User bidder, int priceIncrease){
        if(priceIncrease > 0 && this.lotStatus == status.PLACED) {
            int newPrice = lastBid == null ? startPrice + priceIncrease : lastBid.price + priceIncrease;
            this.lastBid = new Bid(bidder, newPrice);
        }
    }

    public Lot(int startPrice, String name, String description) {
        this.startPrice = startPrice;
        this.name = name;
        this.description = description;
        this.lotStatus = status.CREATED;
    }

    public Lot() {
        this.lotStatus = status.EMPTY;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public status getLotStatus() {
        return lotStatus;
    }

    public void setLotStatus(status lotStatus) {
        this.lotStatus = lotStatus;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Lot{" +
                "startPrice=" + startPrice +
                ", lotStatus=" + lotStatus +
                ", owner=" + owner +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", lastBid=" + lastBid +
                '}';
    }
}
