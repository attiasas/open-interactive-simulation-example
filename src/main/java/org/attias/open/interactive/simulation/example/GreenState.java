package org.attias.open.interactive.simulation.example;

import org.attias.open.interactive.simulation.core.OIS;
import org.attias.open.interactive.simulation.core.state.SimpleState;
import org.attias.open.interactive.simulation.core.tools.Timer;
import org.attias.open.interactive.simulation.core.utils.Utils;

public class GreenState extends SimpleState {
    private final Timer timer = new Timer(5);

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
        Utils.clearScreen(0,1,0);
    }

    @Override
    public boolean update(float v) {
        timer.tic(v);
        if (timer.isOver()) {
            OIS.engine.stateManager.changeState("Red");
        }
        return true;
    }

    @Override
    public void dispose() {

    }
}
