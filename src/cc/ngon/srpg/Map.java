/**
 * @date Apr 29, 2013
 * @author Ben Cochrane
 */
package cc.ngon.srpg;

import cc.ngon.srpg.gfx.Camera;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class Map {

    public Map(int width, int height) {
        this.width = width;
        this.height = height;

        field = new Terrain[width][height];
        actors = new Entity[width][height];
        camera = new Camera();
        camera.initGL();
    }

    public void update() {
        if (Keyboard.isKeyDown(Keyboard.KEY_W)) { camera.moveBy(new Vector3f(1, 0, 0)); }
        if (Keyboard.isKeyDown(Keyboard.KEY_S)) { camera.moveBy(new Vector3f(-1, 0, 0)); }
        if (Keyboard.isKeyDown(Keyboard.KEY_A)) { camera.moveBy(new Vector3f(0, 1, 0)); }
        if (Keyboard.isKeyDown(Keyboard.KEY_D)) { camera.moveBy(new Vector3f(0, -1, 0)); }
        if (Keyboard.isKeyDown(Keyboard.KEY_Q)) { camera.moveBy(new Vector3f(0, 0, 1)); }
        if (Keyboard.isKeyDown(Keyboard.KEY_E)) { camera.moveBy(new Vector3f(0, 0, -1)); }
        
        if (Keyboard.isKeyDown(Keyboard.KEY_UP)) { camera.rotateBy(new Vector3f(0, 1, 0)); }
        if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) { camera.rotateBy(new Vector3f(0, -1, 0)); }
        if (Keyboard.isKeyDown(Keyboard.KEY_UP)) { camera.rotateBy(new Vector3f(1, 0, 0)); }
        if (Keyboard.isKeyDown(Keyboard.KEY_UP)) { camera.rotateBy(new Vector3f(-1, 0, 0)); }
    }

    public void render() {
        camera.renderMap(this);
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }
    
    public Terrain[][] field;
    public Entity[][] actors;
    protected int width;
    protected int height;
    protected Camera camera;
    
}