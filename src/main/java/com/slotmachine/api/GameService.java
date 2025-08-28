package com.slotmachine.api;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class GameService {
    private double balance = 100.0;
    private final String[] emojis = {"🍒", "🍋", "🍊", "💎", "⭐"};
    private final Random random = new Random();

    public double getBalance() {
        return balance;
    }

    public void addDeposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public GameResult spin(double bet) {
        // Valider la mise
        if (bet <= 0) {
            return new GameResult(balance, bet, null, false, 0, "Invalid bet");
        }

        if (bet > balance) {
            return new GameResult(balance, bet, null, false, 0, "Insufficient funds");
        }

        // Déduire la mise
        balance -= bet;

        // Générer le spin
        String[] spin = new String[3];
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(emojis.length);
            spin[i] = emojis[index];
        }

        // Vérifier la victoire
        if (spin[0].equals(spin[1]) && spin[1].equals(spin[2])) {
            double gain = calculateGain(spin[0], bet);
            balance += gain;
            return new GameResult(balance, bet, spin, true, gain, "JACKPOT! 🎉");
        } else {
            return new GameResult(balance, bet, spin, false, 0, "You lost!");
        }
    }

    private double calculateGain(String emoji, double bet) {
        if (emoji.equals("⭐")) {
            return bet * 4;
        } else if (emoji.equals("💎")) {
            return bet * 3;
        } else {
            return bet * 2;
        }
    }
}