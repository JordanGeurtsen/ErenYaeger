module waterworld {
    requires hanyaeger;

    exports game;

    opens audio;
    opens backgrounds;
    opens sprites;
    exports game.scenes;
    exports game.buttons;
    exports game.scenes.maps;
}
