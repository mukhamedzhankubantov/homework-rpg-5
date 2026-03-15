package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult battleResult) {
        // TODO: Decide reward rules based on battle outcome.
        if (battleResult == null || battleResult.getWinner() == null || battleResult.getWinner().isBlank()) {
            return "No reward";
        }
        if (battleResult.getWinner().toLowerCase().contains("boss")) {
            return "Consolation reward: 20 gold, 50 EXP";
        }
        return "Victory reward: 100 gold, 250 EXP, Rare Rune";
    }
}
