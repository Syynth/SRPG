/**
 * @date Apr 29, 2013
 * @author Ben Cochrane
 */
package cc.ngon.srpg;

import cc.ngon.srpg.gfx.Mesh;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


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
            
        }
        
        return m;
    }
    
}
