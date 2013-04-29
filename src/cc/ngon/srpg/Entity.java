/**
 * @date Apr 29, 2013
 * @author Ben Cochrane
 */
package cc.ngon.srpg;


public class Entity {

    public Entity(Map m, int x, int y, int hp, int movement) {
        this.m = m;
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.movement = movement;
    }
    
    protected int x;
    protected int y;
    protected float z;
    
    protected float hp;
    protected float movement;
    
    protected Map m;
    
}
