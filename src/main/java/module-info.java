module bonkTheTowerTD {
    requires hanyaeger;

    exports game;

    opens audio;
    opens backgrounds;
    opens backgrounds.maps;
    opens sprites;
    exports game.scenes;
    exports game.entities.buttons;
    exports game.scenes.maps;
    exports game.entities.tilemap.ground;
}
