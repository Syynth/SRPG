/**
 * @date Apr 29, 2013
 * @author Ben Cochrane
 */
package cc.ngon.srpg;

public class Map {

    public Map(int width, int height) {
        this.width = width;
        this.height = height;

        field = new Terrain[width][height];
        actors = new Entity[width][height];
    }

    public void update() {
    }

    public void render() {
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }
    protected Terrain[][] field;
    protected Entity[][] actors;
    protected int width;
    protected int height;
}
