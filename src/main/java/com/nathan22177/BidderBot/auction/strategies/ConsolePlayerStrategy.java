package com.nathan22177.BidderBot.auction.strategies;

import com.nathan22177.BidderBot.auction.bidder.BidderImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/***
 * Enables to play against user.
 * */
public class ConsolePlayerStrategy implements BiddingStrategy {

    @Override
    public int getBiddingAmount(BidderImpl bidder) {
        System.out.println("Current balance: " + bidder.getBalance());
        System.out.println("Acquired QU: " + bidder.getAcquiredAmount());
        System.out.println("Please enter the amount of MU you would liker to place" + "\n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = "0";
        try {
            userInput = reader.readLine();
        } catch (Exception ignore) {
        }

        int userBid;

        try {
            userBid = Integer.parseInt(userInput);
        } catch (NumberFormatException exception) {
            System.out.println("Input must be a number. Try again!");
            return getBiddingAmount(bidder);
        }

        if (userBid < 0) {
            System.out.println("You can't place negative amount of money. Try again!");
            return getBiddingAmount(bidder);
        }

        if (userBid > bidder.getBalance()) {
            System.out.println("You cannot place more MU than you have on your balance. Try again!");
            return getBiddingAmount(bidder);
        }
        return userBid;

    }
}
