package com.narxoz.rpg.decorator;

public class CriticalFocusDecorator extends ActionDecorator {
    public CriticalFocusDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        // TODO: Decide how this decorator changes the visible action name.
        return super.getActionName() + " + Critical Focus";
    }

    @Override
    public int getDamage() {
        // TODO: Add critical-related behavior on top of wrapped damage.
        return super.getDamage() + 7;
    }

    @Override
    public String getEffectSummary() {
        // TODO: Append or compose the critical effect description.
        return super.getEffectSummary() + ", boosts critical power";
    }
}
