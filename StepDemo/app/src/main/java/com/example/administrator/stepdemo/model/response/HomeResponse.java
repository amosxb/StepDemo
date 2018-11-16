package com.example.administrator.stepdemo.model.response;

public class HomeResponse {

    private int wallet_url;
    private String wallet;
    private String amount;


    public HomeResponse(int wallet_url, String wallet, String amount) {
        this.wallet_url = wallet_url;
        this.wallet = wallet;
        this.amount = amount;
    }

    public int getWallet_url() {
        return wallet_url;
    }

    public String getWallet() {
        return wallet;
    }

    public String getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "HomeResponse{" +
                "wallet_url='" + wallet_url + '\'' +
                ", wallet='" + wallet + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
