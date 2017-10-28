package com.base.game;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.lwjgl.opengl.GL11.*;

public class Main {
    public static void main (String[] args) {
        initDisplay();
        game();
        clean();
    }

    private static void initDisplay() {
        try {
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();

            Keyboard.create();
        } catch (LWJGLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void clean() {
        Display.destroy();
        Keyboard.destroy();
    }

    private static void game() {
        while (!Display.isCloseRequested()) {
            render();
        }
    }

    private static void render() {
        glClear(GL_COLOR_BUFFER_BIT);
        glLoadIdentity();

        Display.update();
        Display.sync(60);
    }
}