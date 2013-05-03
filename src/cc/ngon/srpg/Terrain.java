/**
 * @date Apr 29, 2013
 * @author Ben Cochrane
 */
package cc.ngon.srpg;

import cc.ngon.Config;
import cc.ngon.L;
import cc.ngon.srpg.gfx.*;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.opengl.Texture;

public class Terrain extends Node {

    public Terrain(Map m, Vector3f position, boolean weather, float impediment, float defense) {
        this(m, new TerrainInfo(impediment, defense, weather, Resources.getTexture("grass_terrain_tex")), position);
    }
    
    public Terrain(Map m, TerrainInfo t, Vector3f position) {
        this.map = m;
        this.info = new TerrainInfo(t);
        this.position = new Vector3f(position);
        this.mesh = genMesh();
        this.material = new Material(t.texture);
    }
    
    private Mesh genMesh() {
        Mesh m = new Mesh();
        float xx = position.x * info.size.x;
        float yy = position.y * info.size.y;
        L.p(position.x + "," + position.y);
        m.verts.add(new Vector2f(xx, yy));
        m.verts.add(new Vector2f(xx + info.size.x, yy));
        m.verts.add(new Vector2f(xx + info.size.x, yy + info.size.y));
        m.verts.add(new Vector2f(xx, yy + info.size.y));
        
        m.tex.add(new Vector2f(0, 0));
        m.tex.add(new Vector2f(1, 0));
        m.tex.add(new Vector2f(1, 1));
        m.tex.add(new Vector2f(0, 1));
        
        m.faces.add(new Face(new Vector3f(3, 2, 1), null, new Vector3f(3, 2, 1)));
        m.faces.add(new Face(new Vector3f(4, 3, 1), null, new Vector3f(4, 3, 1)));
        // <editor-fold defaultstate="collapsed" desc="3D Model Code">
        /*m.verts.add(new Vector3f(position.x, position.y, position.z));      //v0
        m.verts.add(new Vector3f(position.x + 1, position.y, position.z));  //v1
        m.verts.add(new Vector3f(position.x + 1, position.y + 1, position.z)); //v2
        m.verts.add(new Vector3f(position.x, position.y + 1, position.z));  //v3
        m.verts.add(new Vector3f(position.x, position.y, 0));               //v4
        m.verts.add(new Vector3f(position.x + 1, position.y, 0));           //v5
        m.verts.add(new Vector3f(position.x + 1, position.y + 1, 0));       //v6
        m.verts.add(new Vector3f(position.x, position.y + 1, 0));           //v7
        // TODO: Add normals
        m.tex.add(new Vector2f(0, 0));      //t0
        m.tex.add(new Vector2f(1, 0));      //t1
        m.tex.add(new Vector2f(0, 0.5f));   //t2
        m.tex.add(new Vector2f(1, 0.5f));   //t3
        m.tex.add(new Vector2f(0, 1));      //t4
        m.tex.add(new Vector2f(1, 1));      //t5
        
        m.faces.add(new Face(new Vector3f(2, 1, 0), null, new Vector3f(3, 1, 0)));
        m.faces.add(new Face(new Vector3f(3, 2, 0), null, new Vector3f(2, 3, 0)));
        m.faces.add(new Face(new Vector3f(6, 2, 3), null, new Vector3f(5, 3, 2)));
        m.faces.add(new Face(new Vector3f(7, 6, 3), null, new Vector3f(4, 5, 2)));
        m.faces.add(new Face(new Vector3f(2, 6, 1), null, new Vector3f(2, 4, 3)));
        m.faces.add(new Face(new Vector3f(6, 5, 1), null, new Vector3f(4, 5, 3)));
        m.faces.add(new Face(new Vector3f(5, 4, 1), null, new Vector3f(4, 5, 2)));
        m.faces.add(new Face(new Vector3f(4, 0, 1), null, new Vector3f(5, 3, 2)));
        m.faces.add(new Face(new Vector3f(4, 3, 0), null, new Vector3f(4, 3, 2)));
        m.faces.add(new Face(new Vector3f(4, 7, 3), null, new Vector3f(4, 5, 3)));*/
        // </editor-fold>
        return m;
    }
    
    @Override
    public String toString() {
        return position.toString();
    }

    public TerrainInfo info;
    public Vector3f position;
    Map map;

    public static final int FLOOR_ID = 0;
    public static final TerrainInfo FLOOR_INFO = new TerrainInfo(1, 0, false, Resources.getTexture("grass_terrain_tex"));
    
    public static final int GROUND_ID = 1;
    public static final TerrainInfo GROUND_INFO = new TerrainInfo(1, 0, true, Resources.getTexture("grass_terrain_tex"));
    
    public static final int WALL_ID = 2;
    public static final TerrainInfo WALL_INFO = new TerrainInfo(999, 999, false, Resources.getTexture("grass_terrain_tex"));
    
    public static final int NULL_ID = 3;
    public static final TerrainInfo NULL_INFO = new TerrainInfo(999, 999, false, Resources.getTexture("grass_terrain_tex"));
    
    public static final int WATER_ID = 4;
    public static final TerrainInfo WATER_INFO = new TerrainInfo(1, -1, true, Resources.getTexture("grass_terrain_tex"));
    
    public static final int TREE_ID = 5;
    public static final TerrainInfo TREE_INFO = new TerrainInfo(1, 1, true, Resources.getTexture("grass_terrain_tex"));
    
    public static class TerrainInfo {
        boolean weather;
        float impediment;
        float defense;
        Texture texture;
        Vector2f size;
        
        public TerrainInfo(float impediment, float defense, boolean weather, Texture texture) {
            this.impediment = impediment;
            this.defense = defense;
            this.weather = weather;
            this.texture = texture;
            this.size = new Vector2f(Config.getInt("game", "tileWidth"), Config.getInt("game", "tileHeight"));
        }
        
        public TerrainInfo(TerrainInfo tinf) {
            this.impediment = tinf.impediment;
            this.defense = tinf.defense;
            this.weather = tinf.weather;
            this.texture = tinf.texture;
            this.size = new Vector2f(tinf.size);
        }
    }
}
