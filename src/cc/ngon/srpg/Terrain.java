/**
 * @date Apr 29, 2013
 * @author Ben Cochrane
 */
package cc.ngon.srpg;

import cc.ngon.srpg.gfx.*;


public class Terrain extends Node  {

    public Terrain(Map m, float x, float y, float z, boolean passable, float delay) {
        this.m = m;
        this.passable = passable;
        this.z = z;
        this.delay = delay;
    }
    
    protected boolean passable;
    protected float delay;
    
    protected float x;
    protected float y;
    protected float z;
    
    protected Map m;
    
}
