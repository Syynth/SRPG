/**
 * @date Apr 29, 2013
 * @author Ben Cochrane
 */
package cc.ngon.srpg;


public class Terrain {

    public Terrain(Map m, boolean passable, float z, float delay) {
        this.m = m;
        this.passable = passable;
        this.z = z;
        this.delay = delay;
    }
    
    protected boolean passable;
    protected float z;
    protected float delay;
    
    protected Map m;
    
}
