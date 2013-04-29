/**
 * @date Apr 29, 2013
 * @author Ben Cochrane
 */
package cc.ngon.srpg.gfx;

import java.util.ArrayList;
import java.util.List;
import org.lwjgl.util.vector.Vector3f;

public class Mesh {

    public Mesh() {
        verts = new ArrayList<>();
        norms = new ArrayList<>();
        tex = new ArrayList<>();
        faces = new ArrayList<>();
    }
    
    public List<Vector3f> verts;
    public List<Vector3f> norms;
    public List<Vector3f> tex;
    public List<Face> faces;
        
}
