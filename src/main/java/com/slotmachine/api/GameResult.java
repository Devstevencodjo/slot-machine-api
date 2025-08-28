package com.slotmachine.api;

public class GameResult {
    private double balance;
    private double bet;
    private String[] spin;
    private boolean isWin;
    private double gain;
    private String message;

    // Constructeur
    public GameResult(double balance, double bet, String[] spin, boolean isWin, double gain, String message) {
        this.balance = balance;
        this.bet = bet;
        this.spin = spin;
        this.isWin = isWin;
        this.gain = gain;
        this.message = message;
    }

    // Getters et Setters
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public double getBet() { return bet; }
    public void setBet(double bet) { this.bet = bet; }

    public String[] getSpin() { return spin; }
    public void setSpin(String[] spin) { this.spin = spin; }

    public boolean isWin() { return isWin; }
    public void setWin(boolean win) { isWin = win; }

    public double getGain() { return gain; }
    public void setGain(double gain) { this.gain = gain; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}