/**
 * @date Apr 29, 2013
 * @author Ben Cochrane
 */
package cc.ngon.srpg;

import cc.ngon.srpg.gfx.*;
import org.lwjgl.util.vector.Vector3f;

public class Terrain extends Node {

    public Terrain(Map m, Vector3f position, boolean weather, float impediment, float defense) {
        this.map = m;
        this.info = new TerrainInfo(impediment, defense, weather);
        this.position = position;
    }
    
    public Terrain(Map m, TerrainInfo t, Vector3f position) {
        this.map = m;
        this.info = t;
        this.position = position;
    }

    TerrainInfo info;
    Vector3f position;
    Map map;

    public static final int FLOOR_ID = 0;
    public static final TerrainInfo FLOOR_INFO = new TerrainInfo(1, 0, false);
    
    public static final int GROUND_ID = 1;
    public static final TerrainInfo GROUND_INFO = new TerrainInfo(1, 0, true);
    
    public static final int WALL_ID = 2;
    public static final TerrainInfo WALL_INFO = new TerrainInfo(999, 999, false);
    
    public static final int NULL_ID = 3;
    public static final TerrainInfo NULL_INFO = new TerrainInfo(999, 999, false);
    
    public static final int WATER_ID = 4;
    public static final TerrainInfo WATER_INFO = new TerrainInfo(1, -1, true);
    
    public static final int TREE_ID = 5;
    public static final TerrainInfo TREE_INFO = new TerrainInfo(1, 1, true);
    
    public static class TerrainInfo {
        boolean weather;
        float impediment;
        float defense;
        
        public TerrainInfo(float impediment, float defense, boolean weather) {
            this.impediment = impediment;
            this.defense = defense;
            this.weather = weather;
        }
    }
}
