/**
 * @date Apr 29, 2013
 * @author Ben Cochrane
 */
package cc.ngon.srpg;

import cc.ngon.srpg.gfx.Camera;

public class Map {

    public Map(int width, int height) {
        this.width = width;
        this.height = height;

        field = new Terrain[width][height];
        actors = new Entity[width][height];
        camera = new Camera();
    }

    public void update() {
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
