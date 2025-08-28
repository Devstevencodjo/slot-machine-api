package com.slotmachine.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/slot-machine")
@CrossOrigin(origins = "*")
public class SlotMachineController {

    @Autowired
    private GameService gameService;

    @GetMapping("/balance")
    public ResponseEntity<Double> getBalance() {
        return ResponseEntity.ok(gameService.getBalance());
    }

    @PostMapping("/deposit")
    public ResponseEntity<Double> deposit(@RequestBody DepositRequest request) {
        gameService.addDeposit(request.getAmount());
        return ResponseEntity.ok(gameService.getBalance());
    }

    @PostMapping("/spin")
    public ResponseEntity<GameResult> spin(@RequestBody BetRequest request) {
        GameResult result = gameService.spin(request.getBet());
        return ResponseEntity.ok(result);
    }

    // Classes pour les requêtes
    public static class BetRequest {
        private double bet;
        public double getBet() { return bet; }
        public void setBet(double bet) { this.bet = bet; }
    }

    public static class DepositRequest {
        private double amount;
        public double getAmount() { return amount; }
        public void setAmount(double amount) { this.amount = amount; }
    }
}