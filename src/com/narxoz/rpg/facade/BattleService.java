package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

import java.util.Random;

public class BattleService {
    private Random random = new Random(1L);

    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        // TODO: Implement the battle flow.
        // Questions to answer:
        // - Who attacks first?
        // - How many rounds are allowed?
        // - How is damage resolved?
        // - How will randomness affect the result, if at all?
        AdventureResult result = new AdventureResult();
        int rounds = 0;
        result.addLine("Battle started: " + hero.getName() + " vs " + boss.getName());
        result.addLine("Hero uses action: " + action.getActionName());
        result.addLine("Action effects: " + action.getEffectSummary());
        while (hero.isAlive() && boss.isAlive()) {
            rounds++;

            int heroDamage = action.getDamage() + random.nextInt(3);
            boss.takeDamage(heroDamage);
            result.addLine("Round " + rounds + ": "
                    + hero.getName() + " deals " + heroDamage + " damage to "
                    + boss.getName() + " (boss HP: " + boss.getHealth() + ")");

            if (!boss.isAlive()) {
                result.setWinner(hero.getName());
                break;
            }

            int bossDamage = boss.getAttackPower();
            hero.takeDamage(bossDamage);
            result.addLine("Round " + rounds + ": "
                    + boss.getName() + " deals " + bossDamage + " damage to "
                    + hero.getName() + " (hero HP: " + hero.getHealth() + ")");

            if (!hero.isAlive()) {
                result.setWinner(boss.getName());
                break;
            }
        }
//        result.setWinner("TODO");
//        result.setRounds(0);
//        result.setReward("TODO");
//        result.addLine("TODO: implement battle logic");
//
//        // Keep the field in use so students can decide whether to rely on it.
//        if (random.nextInt(1) == 0) {
//            // TODO: Replace placeholder branch with real deterministic or random logic.
//        }
        result.setRounds(rounds);
        result.setReward("Pending");

        return result;
    }
}
