package com.StardewValley.Controller;

import com.StardewValley.model.User;
import com.StardewValley.model.Animal.Animal;

public class AnimalMovingController {
    private User player;

    public AnimalMovingController(User player) {
        this.player = player;
    }

    public User getPlayer() {
        return player;
    }
    public void setPlayer(User player) {
        this.player = player;
    }




    public boolean checkIfClickedOnAnimal(float x, float y) {
        if (player == null || player.getMyAnimals() == null) return false;

        float tile = 64f;
        try {
            var lands = player.getFarm().getFarmLands();
            if (lands != null && !lands.isEmpty() && lands.get(0).getCollisionRect() != null) {
                var r = lands.get(0).getCollisionRect();
                tile = Math.min(r.getWidth(), r.getHeight());
            }
        } catch (Exception ignored) {}

        for (Animal a : player.getMyAnimals()) {
            if (a.isIn()) continue;

            var s = a.getSprite();
            float ax = a.getWorldX(), ay = a.getWorldY();
            float w = s.getWidth(), h = s.getHeight();
            boolean hit = (x >= ax && x <= ax + w && y >= ay && y <= ay + h);
            if (!hit) continue;



            java.util.concurrent.ThreadLocalRandom rng = java.util.concurrent.ThreadLocalRandom.current();
            // shoaa tasadofi
//            float radius = (float) (rng.nextDouble() * (MAX_TILES_PER_CLICK * tile));


            //kollan 10 ta khone bre baraye namayesh vazeh tar
            final float TILES_PER_CLICK = 10f;
            float radius = TILES_PER_CLICK * tile;
            float theta   = (float) (rng.nextDouble() * Math.PI * 2.0);




            float dx = (float) Math.cos(theta) * radius;
            float dy = (float) Math.sin(theta) * radius;
            float cx = ax + w / 2f, cy = ay + h / 2f;
            float targetX = cx + dx - w / 2f;
            float targetY = cy + dy - h / 2f;


            a.setTarget(targetX, targetY);
            return true;
        }
        return false;
    }


}
