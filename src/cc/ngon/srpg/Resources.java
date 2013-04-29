/**
 * @date Apr 29, 2013
 * @author Ben Cochrane
 */
package cc.ngon.srpg;

import cc.ngon.srpg.gfx.Face;
import cc.ngon.srpg.gfx.Mesh;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.lwjgl.util.vector.Vector3f;


public final class Resources {

    /**
     * Don't call me.
     */
    private Resources() {}
    
    public static Mesh loadObjFile(File f) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(f));
        Mesh m = new Mesh();
        
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("v ")) {
                float x = Float.valueOf(line.split(" ")[1]);
                float y = Float.valueOf(line.split(" ")[2]);
                float z = Float.valueOf(line.split(" ")[3]);
                m.verts.add(new Vector3f(x, y, z));
            } else if (line.startsWith("vn ")) {
                float x = Float.valueOf(line.split(" ")[1]);
                float y = Float.valueOf(line.split(" ")[2]);
                float z = Float.valueOf(line.split(" ")[3]);
                m.norms.add(new Vector3f(x, y, z));
            } else if (line.startsWith("f ")) {
                Vector3f vInd = new Vector3f(
                        Float.valueOf(line.split(" ")[1].split("/")[0]),
                        Float.valueOf(line.split(" ")[2].split("/")[0]),
                        Float.valueOf(line.split(" ")[3].split("/")[0]));
                Vector3f nInd = new Vector3f(
                        Float.valueOf(line.split(" ")[1].split("/")[2]),
                        Float.valueOf(line.split(" ")[2].split("/")[2]),
                        Float.valueOf(line.split(" ")[3].split("/")[2]));
                m.faces.add(new Face(vInd, nInd, null));
            }
        }
        reader.close();
        return m;
    }
    
}
