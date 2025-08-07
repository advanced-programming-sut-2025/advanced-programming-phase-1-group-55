package com.StardewValley.model.Animal.Fishing;

import java.util.Random;

public enum FishMovementType {
    MIXED {
        @Override
        public FishMovementPattern createPattern() {
            return new MixedMovement();
        }
    },
    SMOOTH {
        @Override
        public FishMovementPattern createPattern() {
            return new SmoothMovement();
        }
    },
    SINKER {
        @Override
        public FishMovementPattern createPattern() {
            return new SinkerMovement();
        }
    },
    FLOATER {
        @Override
        public FishMovementPattern createPattern() {
            return new FloaterMovement();
        }
    },
    DART {
        @Override
        public FishMovementPattern createPattern() {
            return new DartMovement();
        }
    };

    public abstract FishMovementPattern createPattern();

    private static final Random RANDOM = new Random();

    public static FishMovementType getRandomType() {
        FishMovementType[] values = FishMovementType.values();
        return values[RANDOM.nextInt(values.length)];
    }
}
