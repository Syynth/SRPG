/**
 * @date Apr 29, 2013
 * @author Ben Cochrane
 */
package cc.ngon.srpg.gfx;

import org.lwjgl.util.vector.*;

public class Face {

    public Vector3f v;
    public Vector3f n;
    public Vector2f t;
    
    public Face(Vector3f vertexIndex, Vector3f normalIndex, Vector2f texIndex) {
        v = vertexIndex;
        n = normalIndex;
        t = texIndex;
    }
    
}
