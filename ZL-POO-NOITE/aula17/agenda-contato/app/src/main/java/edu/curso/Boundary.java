package edu.curso;

import javafx.scene.layout.Pane;

public interface Boundary {
    Pane render();
    Executor getExecutor();
    void setExecutor( Executor e );
}
