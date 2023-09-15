package org.attias.open.interactive.simulation.example;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.attias.open.interactive.simulation.core.OIS;
import org.attias.open.interactive.simulation.core.state.SimpleState;
import org.attias.open.interactive.simulation.core.tools.Timer;
import org.attias.open.interactive.simulation.core.utils.Utils;

public class BlueState extends SimpleState {
    private final Timer timer = new Timer(5);

    SpriteBatch batch = new SpriteBatch();
    Texture img= new Texture("icon.png");

    @Override
    public boolean enter(Object... objects) {
        timer.reset();
        return true;
    }

    @Override
    public void exit() {

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void render() {
        Utils.clearScreen(0,0,1);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
    }

    @Override
    public boolean update(float v) {
        timer.tic(v);
        if (timer.isOver()) {
            OIS.engine.stateManager.changeState("Green");
        }
        return true;
    }

    @Override
    public void dispose () {
        batch.dispose();
        img.dispose();
    }
}
