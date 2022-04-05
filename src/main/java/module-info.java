module bonkTheTowerTD {
    requires hanyaeger;

    exports game;

    opens audio;
    opens backgrounds;
    opens sprites;
    opens sprites.enemies;
    opens sprites.towers;
    exports game.scenes;
    exports game.entities.buttons;
    exports game.entities.tilemap.ground;
    exports game.entities.buttons.compositebutton;
    exports game.entities.enemies;
    exports game.scenes.gamescreen;
}
